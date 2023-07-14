package mk.ukim.finki.proekti.service.impl;

import mk.ukim.finki.proekti.models.DTO.NationalProjectDto;
import mk.ukim.finki.proekti.models.NationalProject;
import mk.ukim.finki.proekti.models.Call;
import mk.ukim.finki.proekti.models.Teacher;
import mk.ukim.finki.proekti.models.enumerations.TypeStatus;
import mk.ukim.finki.proekti.models.exceptions.NationalProjectNotFoundException;
import mk.ukim.finki.proekti.models.exceptions.CallNotFoundException;
import mk.ukim.finki.proekti.models.exceptions.TeacherNotFoundException;
import mk.ukim.finki.proekti.repository.NationalProjectRepository;
import mk.ukim.finki.proekti.repository.TeacherRepository;
import mk.ukim.finki.proekti.service.NationalProjectService;
import mk.ukim.finki.proekti.service.CallService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class NationalProjectServiceImpl implements NationalProjectService {

    private final NationalProjectRepository nationalProjectRepository;
    private final CallService callService;
    private final TeacherRepository teacherRepository;

    public NationalProjectServiceImpl(NationalProjectRepository nationalProjectRepository, CallService callService, TeacherRepository teacherRepository) {
        this.nationalProjectRepository = nationalProjectRepository;
        this.callService = callService;
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
    public List<NationalProject> findByCallOrStatus(Long call, TypeStatus status) {
        Call p = this.callService.findById(call).orElseThrow(CallNotFoundException::new);
        if (call == null && status == null)
            return this.findAll();

        if (call == null)
            return this.findAll().stream().filter(project -> project.getTypeStatus().equals(status)).toList();
        else if (status == null)
            return this.findAll().stream().filter(project -> project.getCall().equals(p)).toList();

        return this.findAll().stream().filter(nationalProject -> nationalProject.getCall().equals(p) && nationalProject.getTypeStatus().equals(status)).toList();
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
        Call call = this.callService.findById(nationalProjectDto.getCallId()).orElseThrow(CallNotFoundException::new);
        List<Teacher> members = this.teacherRepository.findAllById(nationalProjectDto.getMembers());

        NationalProject nationalProject = new NationalProject(nationalProjectDto.getName(),
                nationalProjectDto.getDateEntry(), nationalProjectDto.getTypeStatus(),
                nationalProjectDto.getKeyWords(), nationalProjectDto.getSummary(), nationalProjectDto.getBenefits(),
                members, manager, call);

        return Optional.of(this.nationalProjectRepository.save(nationalProject));
    }

    @Override
    public Optional<NationalProject> editNationalProject(Long id, NationalProjectDto nationalProjectDto) {
        Teacher manager = this.teacherRepository.findById(nationalProjectDto.getManager()).orElseThrow(TeacherNotFoundException::new);
        Call call = this.callService.findById(nationalProjectDto.getCallId()).orElseThrow(CallNotFoundException::new);
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
        nationalProject.setCall(call);

        return Optional.of(this.nationalProjectRepository.save(nationalProject));
    }

    @Override
    public List<NationalProject> findAllApproved() {
        return nationalProjectRepository.findByApprovedIsTrue();
    }

    //TODO
    @Override
    public Optional<NationalProject> makeApproved(Long id) {
        return Optional.empty();
    }


}
