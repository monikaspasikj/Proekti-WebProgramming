package mk.ukim.finki.proekti.service.impl;

import mk.ukim.finki.proekti.models.DTO.InternationalProjectDto;
import mk.ukim.finki.proekti.models.Institution;
import mk.ukim.finki.proekti.models.InternationalProject;
import mk.ukim.finki.proekti.models.enumerations.TypeStatus;
import mk.ukim.finki.proekti.models.exceptions.InstitutionNotFoundException;
import mk.ukim.finki.proekti.repository.InstitutionRepository;
import mk.ukim.finki.proekti.repository.InternationalProjectRepository;
import mk.ukim.finki.proekti.service.InternationalProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InternationalProjectServiceImpl implements InternationalProjectService {


    private final InternationalProjectRepository projectRepository;
    private final InstitutionRepository institutionRepository;

    public InternationalProjectServiceImpl(InternationalProjectRepository projectRepository, InstitutionRepository institutionRepository) {
        this.projectRepository = projectRepository;
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<InternationalProject> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<InternationalProject> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public List<InternationalProject> findByTypeStatus(TypeStatus typeStatus) {
        return projectRepository.findByTypeStatus(typeStatus);
    }

    @Override
    public List<InternationalProject> findByName(String name) {
        return projectRepository.findAllByName(name);
    }

    @Override
    public List<InternationalProject> findByKeyword(String keyword) {
        return projectRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword);
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Optional<InternationalProject> addInternationalProject(InternationalProjectDto internationalProjectDto) {
        Institution primaryInstitution = internationalProjectDto.getPrimaryInstitution();
        Institution anotherInstitution = internationalProjectDto.getAnotherInstitution();
        Institution carrier = internationalProjectDto.getCarrier();
        Institution partners = internationalProjectDto.getPartners();

        InternationalProject internationalProject = new InternationalProject(
                internationalProjectDto.getName(),
                internationalProjectDto.getDateEntry(),
                internationalProjectDto.getTypeStatus(),
                internationalProjectDto.getDescription(),
                internationalProjectDto.getType(),
                internationalProjectDto.getGoals(),
                internationalProjectDto.getStartDate(),
                internationalProjectDto.getEndDate(),
                primaryInstitution,
                anotherInstitution,
                carrier,
                partners
        );

        return Optional.of(projectRepository.save(internationalProject));
    }

    @Override
    public Optional<InternationalProject> editInternationalProject(Long id, InternationalProjectDto internationalProjectDto) {
        Optional<InternationalProject> optionalProject = projectRepository.findById(id);
        if (optionalProject.isPresent()) {
            InternationalProject internationalProject = optionalProject.get();

            Institution primaryInstitution = internationalProjectDto.getPrimaryInstitution();
            Institution anotherInstitution = internationalProjectDto.getAnotherInstitution();
            Institution carrier = internationalProjectDto.getCarrier();
            Institution partners = internationalProjectDto.getPartners();

            internationalProject.setName(internationalProjectDto.getName());
            internationalProject.setDateEntry(internationalProjectDto.getDateEntry());
            internationalProject.setTypeStatus(internationalProjectDto.getTypeStatus());
            internationalProject.setDescription(internationalProjectDto.getDescription());
            internationalProject.setType(internationalProjectDto.getType());
            internationalProject.setGoals(internationalProjectDto.getGoals());
            internationalProject.setStartDate(internationalProjectDto.getStartDate());
            internationalProject.setEndDate(internationalProjectDto.getEndDate());
            internationalProject.setPrimaryInstitution(primaryInstitution);
            internationalProject.setAnotherInstitution(anotherInstitution);
            internationalProject.setCarrier(carrier);
            internationalProject.setPartners(partners);

            return Optional.of(projectRepository.save(internationalProject));
        }
        return Optional.empty();
    }
}
