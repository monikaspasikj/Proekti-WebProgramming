package mk.ukim.finki.proekti.service;

import mk.ukim.finki.proekti.models.DTO.InstitutionDto;
import mk.ukim.finki.proekti.models.Institution;

import java.util.List;
import java.util.Optional;

public interface InstitutionService {
    List<Institution> findAll();

    Optional<Institution> findById(Long id);

    void delete(Long id);

    Optional<Institution> addInstitution(InstitutionDto institutionDto);

    Optional<Institution> editInstitution(Long id, InstitutionDto institutionDto);

    List<Institution> findByLocation(String location);

    Institution findByName(String name);

}
