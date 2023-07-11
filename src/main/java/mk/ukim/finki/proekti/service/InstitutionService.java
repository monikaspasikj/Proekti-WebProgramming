package mk.ukim.finki.proekti.service;

import mk.ukim.finki.proekti.models.Institution;

import java.util.List;
import java.util.Optional;

public interface InstitutionService {
    List<Institution> findAll();

    Optional<Institution> findById(Long id);

    void delete(Long id);

    void addInstitution(String name, String location);

}
