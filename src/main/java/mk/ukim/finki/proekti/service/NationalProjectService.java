package mk.ukim.finki.proekti.service;

import mk.ukim.finki.proekti.models.DTO.NationalProjectDto;
import mk.ukim.finki.proekti.models.DTO.PovikDto;
import mk.ukim.finki.proekti.models.NationalProject;
import mk.ukim.finki.proekti.models.Povik;
import mk.ukim.finki.proekti.models.enumerations.TypeStatus;

import java.util.List;
import java.util.Optional;

public interface NationalProjectService {
    List<NationalProject> findAll();

    Optional<NationalProject> findById(Long id);
    List<NationalProject> findByPovikorStatus(Long povik, TypeStatus status);
    List<NationalProject> findByName(String name);
    List<NationalProject> findByKeyWord(String keyword);

    void delete(Long id);

    Optional<NationalProject> addNationalProject(NationalProjectDto nationalProjectDto);

    Optional<NationalProject> editNationalProject(Long id, NationalProjectDto nationalProjectDto);
}
