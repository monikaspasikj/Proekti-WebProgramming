package mk.ukim.finki.proekti.service.impl;

import mk.ukim.finki.proekti.models.DTO.InstitutionDto;
import mk.ukim.finki.proekti.models.Institution;
import mk.ukim.finki.proekti.models.exceptions.InstitutionNotFoundException;
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
        Institution institution = this.findById(id).orElseThrow(InstitutionNotFoundException::new);
        this.institutionRepository.delete(institution);
    }

    @Override
    public Optional<Institution> addInstitution(InstitutionDto institutionDto) {
        Institution institution= new Institution(institutionDto.getName(), institutionDto.getLocation());
        return  Optional.of(this.institutionRepository.save(institution));
    }

    @Override
    public Optional<Institution> editInstitution(Long id, InstitutionDto institutionDto) {
        Institution institution=this.findById(id).orElseThrow(InstitutionNotFoundException::new);
        institution.setName(institutionDto.getName());
        institution.setLocation(institutionDto.getLocation());
        return Optional.of(this.institutionRepository.save(institution));
    }

}
