package mk.ukim.finki.proekti.service;

import mk.ukim.finki.proekti.models.DTO.NationalProjectDto;
import mk.ukim.finki.proekti.models.NationalProject;
import mk.ukim.finki.proekti.models.enumerations.TypeStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface NationalProjectService {
    List<NationalProject> findAll();

    Optional<NationalProject> findById(Long id);

    List<NationalProject> findByCallOrStatus(Long povik, TypeStatus status);

    List<NationalProject> findByName(String name);

    List<NationalProject> findByKeyWord(String keyword);

    void delete(Long id);

    Optional<NationalProject> addNationalProject(NationalProjectDto nationalProjectDto);

    Optional<NationalProject> editNationalProject(Long id, NationalProjectDto nationalProjectDto);

    List<NationalProject> findAllApproved();

    Optional<NationalProject> makeApproved(Long id);

    Page<NationalProject> findAllByPagination(Pageable pageable);
}
