package mk.ukim.finki.proekti.service.impl;

import mk.ukim.finki.proekti.models.DTO.PovikDto;
import mk.ukim.finki.proekti.models.Institution;
import mk.ukim.finki.proekti.models.Povik;
import mk.ukim.finki.proekti.models.exceptions.InstitutionNotFoundException;
import mk.ukim.finki.proekti.models.exceptions.PovikNotFoundException;
import mk.ukim.finki.proekti.repository.PovikRepository;
import mk.ukim.finki.proekti.service.InstitutionService;
import mk.ukim.finki.proekti.service.PovikService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PovikServiceImpl implements PovikService {


    private final PovikRepository povikRepository;
    private final InstitutionService institutionService;

    public PovikServiceImpl(PovikRepository povikRepository, InstitutionService institutionService) {
        this.povikRepository = povikRepository;
        this.institutionService = institutionService;
    }


    @Override
    public List<Povik> findAll() {
        return this.povikRepository.findAll();
    }

    @Override
    public Optional<Povik> findById(Long id) {
        return this.povikRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        Povik povik=this.findById(id).orElseThrow(PovikNotFoundException::new);
        this.povikRepository.delete(povik);
    }

    @Override
    public Optional<Povik> addPovik(PovikDto povikDto) {
        Institution institution=this.institutionService.findById(povikDto.getInstitution()).orElseThrow(InstitutionNotFoundException::new);
        Povik povik=new Povik(povikDto.getName(),povikDto.getAcronym(),povikDto.getEndDate(),povikDto.getTypePovik(),institution,povikDto.getTypeStatus());
        return Optional.of(this.povikRepository.save(povik));

    }

    @Override
    public Optional<Povik> editPovik(Long id, PovikDto povikDto) {
        Povik povik=this.findById(id).orElseThrow(PovikNotFoundException::new);
        Institution institution=this.institutionService.findById(povikDto.getInstitution()).orElseThrow(InstitutionNotFoundException::new);


        povik.setName(povikDto.getName());
        povik.setAcronym(povikDto.getAcronym());
        povik.setTypePovik(povikDto.getTypePovik());
        povik.setInstitution(institution);
        povik.setEndDate(povikDto.getEndDate());
        povik.setTypeStatus(povikDto.getTypeStatus());


        return Optional.of(this.povikRepository.save(povik));
    }
}
