package mk.ukim.finki.proekti.service.impl;

import mk.ukim.finki.proekti.models.DTO.NationalProjectDto;
import mk.ukim.finki.proekti.models.NationalProject;
import mk.ukim.finki.proekti.models.Povik;
import mk.ukim.finki.proekti.models.Teacher;
import mk.ukim.finki.proekti.models.enumerations.TypeStatus;
import mk.ukim.finki.proekti.models.exceptions.NationalProjectNotFoundException;
import mk.ukim.finki.proekti.models.exceptions.PovikNotFoundException;
import mk.ukim.finki.proekti.models.exceptions.TeacherNotFoundException;
import mk.ukim.finki.proekti.repository.NationalProjectRepository;
import mk.ukim.finki.proekti.repository.TeacherRepository;
import mk.ukim.finki.proekti.service.NationalProjectService;
import mk.ukim.finki.proekti.service.PovikService;
import mk.ukim.finki.proekti.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class NationalProjectServiceImpl implements NationalProjectService {

    private final NationalProjectRepository nationalProjectRepository;
    private final PovikService povikService;
    private final TeacherRepository teacherRepository;

    public NationalProjectServiceImpl(NationalProjectRepository nationalProjectRepository, PovikService povikService, TeacherRepository teacherRepository) {
        this.nationalProjectRepository = nationalProjectRepository;
        this.povikService = povikService;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<NationalProject> findAll() {
        return this.nationalProjectRepository.findAll();
    }

    @Override
    public Optional<NationalProject> findById(Long id) {
        return this.nationalProjectRepository.findById(id);
    }

    @Override
    public List<NationalProject> findByPovikorStatus(Long povik, TypeStatus status) {
        Povik p = this.povikService.findById(povik).orElseThrow(PovikNotFoundException::new);
        if (povik == null && status == null)
            return this.findAll();

        if (povik == null)
            return this.findAll().stream().filter(project -> project.getTypeStatus().equals(status)).toList();
        else if (status == null)
            return this.findAll().stream().filter(project -> project.getPovik().equals(p)).toList();

        return this.findAll().stream().filter(nationalProject -> nationalProject.getPovik().equals(p) && nationalProject.getTypeStatus().equals(status)).toList();
    }

    @Override
    public List<NationalProject> findByName(String name) {
        if (name == null)
            return this.findAll();

        return this.nationalProjectRepository.findAllByNameContainingIgnoreCase(name);
    }

    @Override
    public List<NationalProject> findByKeyWord(String keyword) {
        if (keyword == null)
            return this.findAll();
        return this.nationalProjectRepository.findAllByKeyWordsContainingIgnoreCase(keyword);
    }

    @Override
    public void delete(Long id) {
        NationalProject project = this.findById(id).orElseThrow(NationalProjectNotFoundException::new);
        this.nationalProjectRepository.delete(project);

    }

    @Override
    public Optional<NationalProject> addNationalProject(NationalProjectDto nationalProjectDto) {
        Teacher manager = this.teacherRepository.findById(nationalProjectDto.getManager()).orElseThrow(TeacherNotFoundException::new);
        Povik povik = this.povikService.findById(nationalProjectDto.getPovik()).orElseThrow(PovikNotFoundException::new);
        List<Teacher> members = this.teacherRepository.findAllById(nationalProjectDto.getMembers());

        NationalProject nationalProject = new NationalProject(nationalProjectDto.getName(),
                nationalProjectDto.getDateEntry(), nationalProjectDto.getTypeStatus(),
                nationalProjectDto.getKeyWords(), nationalProjectDto.getSummary(), nationalProjectDto.getBenefits(),
                members, manager, povik);

        return Optional.of(this.nationalProjectRepository.save(nationalProject));
    }

    @Override
    public Optional<NationalProject> editNationalProject(Long id, NationalProjectDto nationalProjectDto) {
        Teacher manager = this.teacherRepository.findById(nationalProjectDto.getManager()).orElseThrow(TeacherNotFoundException::new);
        Povik povik = this.povikService.findById(nationalProjectDto.getPovik()).orElseThrow(PovikNotFoundException::new);
        List<Teacher> members = this.teacherRepository.findAllById(nationalProjectDto.getMembers());

        NationalProject nationalProject = this.findById(id).orElseThrow(NationalProjectNotFoundException::new);
        nationalProject.setName(nationalProjectDto.getName());
        nationalProject.setDateEntry(nationalProjectDto.getDateEntry());
        nationalProject.setTypeStatus(nationalProjectDto.getTypeStatus());
        nationalProject.setBenefits(nationalProjectDto.getBenefits());
        nationalProject.setSummary(nationalProjectDto.getSummary());
        nationalProject.setKeyWords(nationalProjectDto.getKeyWords());
        nationalProject.setManager(manager);
        nationalProject.setMembers(members);
        nationalProject.setPovik(povik);

        return Optional.of(this.nationalProjectRepository.save(nationalProject));
    }


}
