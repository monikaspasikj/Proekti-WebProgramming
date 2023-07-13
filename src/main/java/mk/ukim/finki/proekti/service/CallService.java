package mk.ukim.finki.proekti.service;

import mk.ukim.finki.proekti.models.DTO.CallDto;
import mk.ukim.finki.proekti.models.Call;

import java.util.List;
import java.util.Optional;

public interface CallService {
    List<Call> findAll();

    Optional<Call> findById(Long id);

    void delete(Long id);

    Optional<Call> addPovik(CallDto callDto);

    Optional<Call> editPovik(Long id, CallDto callDto);
}
