package mk.ukim.finki.proekti.service.impl;

import mk.ukim.finki.proekti.models.Institution;
import mk.ukim.finki.proekti.repository.InstitutionRepository;
import mk.ukim.finki.proekti.service.InstitutionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstitutionServiceImpl implements InstitutionService {
    private final InstitutionRepository institutionRepository;

    public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    @Override
    public Optional<Institution> findById(Long id) {
        return institutionRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        Optional<Institution> institution = findById(id);
        institution.ifPresent(institutionRepository::delete);
    }

    @Override
    public Optional<Institution> addInstitution(String name, String location) {
        return Optional.of(institutionRepository.save(new Institution(name, location)));
    }

    @Override
    public Optional<Institution> editInstitution(Long id, String name, String location) {
        delete(id);
        return addInstitution(name, location);
    }

}
