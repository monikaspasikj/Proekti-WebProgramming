package mk.ukim.finki.proekti.service;

import mk.ukim.finki.proekti.models.DTO.PovikDto;
import mk.ukim.finki.proekti.models.Povik;

import java.util.List;
import java.util.Optional;

public interface PovikService {
    List<Povik> findAll();

    Optional<Povik> findById(Long id);

    void delete(Long id);

    Optional<Povik> addPovik(PovikDto povikDto);

    Optional<Povik> editPovik(Long id, PovikDto povikDto);
}
