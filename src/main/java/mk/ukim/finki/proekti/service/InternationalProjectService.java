package mk.ukim.finki.proekti.service;

import mk.ukim.finki.proekti.models.DTO.InternationalProjectDto;
import mk.ukim.finki.proekti.models.InternationalProject;
import mk.ukim.finki.proekti.models.NationalProject;
import mk.ukim.finki.proekti.models.enumerations.TypeStatus;

import java.util.List;
import java.util.Optional;

public interface InternationalProjectService {
    List<InternationalProject> findAll();

    Optional<InternationalProject> findById(Long id);

    List<InternationalProject> findByTypeStatus(TypeStatus typeStatus);

    List<InternationalProject> findByName(String name);

    List<InternationalProject> findByKeyword(String keyword);

    void delete(Long id);

    Optional<InternationalProject> addInternationalProject(InternationalProjectDto internationalProjectDTO);

    Optional<InternationalProject> editInternationalProject(Long id, InternationalProjectDto internationalProjectDTO);

    List<InternationalProject> findAllApproved();

    Optional<InternationalProject> makeApproved(Long id);

}
