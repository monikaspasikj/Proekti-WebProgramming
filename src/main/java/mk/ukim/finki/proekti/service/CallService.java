package mk.ukim.finki.proekti.service;

import mk.ukim.finki.proekti.models.DTO.CallDto;
import mk.ukim.finki.proekti.models.Call;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CallService {
    List<Call> findAll();

    Optional<Call> findById(Long id);

    void delete(Long id);

    Optional<Call> addCall(CallDto callDto);

    Optional<Call> editCall(Long id, CallDto callDto);

    Page<Call> findAllByPagination(Pageable pageable);
}
