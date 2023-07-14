package mk.ukim.finki.proekti.service.impl;

import mk.ukim.finki.proekti.models.DTO.CallDto;
import mk.ukim.finki.proekti.models.Institution;
import mk.ukim.finki.proekti.models.Call;
import mk.ukim.finki.proekti.models.exceptions.InstitutionNotFoundException;
import mk.ukim.finki.proekti.models.exceptions.CallNotFoundException;
import mk.ukim.finki.proekti.repository.CallRepository;
import mk.ukim.finki.proekti.service.InstitutionService;
import mk.ukim.finki.proekti.service.CallService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CallServiceImpl implements CallService {


    private final CallRepository callRepository;
    private final InstitutionService institutionService;

    public CallServiceImpl(CallRepository callRepository, InstitutionService institutionService) {
        this.callRepository = callRepository;
        this.institutionService = institutionService;
    }


    @Override
    public List<Call> findAll() {
        return this.callRepository.findAll();
    }

    @Override
    public Optional<Call> findById(Long id) {
        return this.callRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        Call call = this.findById(id).orElseThrow(CallNotFoundException::new);
        this.callRepository.delete(call);
    }

    @Override
    public Optional<Call> addCall(CallDto callDto) {
        Institution institution = this.institutionService.findById(callDto.getInstitutionId()).orElseThrow(InstitutionNotFoundException::new);
        Call call = new Call(callDto.getName(), callDto.getAcronym(), callDto.getEndDate(), callDto.getTypeCall(), institution, callDto.getTypeStatus());
        return Optional.of(this.callRepository.save(call));

    }

    @Override
    public Optional<Call> editCall(Long id, CallDto callDto) {
        Call call = this.findById(id).orElseThrow(CallNotFoundException::new);
        Institution institution = this.institutionService.findById(callDto.getInstitutionId()).orElseThrow(InstitutionNotFoundException::new);


        call.setName(callDto.getName());
        call.setAcronym(callDto.getAcronym());
        call.setTypeStatus(callDto.getTypeStatus());
        call.setInstitution(institution);
        call.setEndDate(callDto.getEndDate());
        call.setTypeStatus(callDto.getTypeStatus());


        return Optional.of(this.callRepository.save(call));
    }
}
