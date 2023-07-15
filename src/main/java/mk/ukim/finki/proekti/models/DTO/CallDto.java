package mk.ukim.finki.proekti.models.DTO;


import lombok.Data;
import mk.ukim.finki.proekti.models.enumerations.TypeCall;
import mk.ukim.finki.proekti.models.enumerations.TypeStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class CallDto {

    String name;
    String acronym;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate endDate;
    TypeCall typeCall;
    Long institutionId;
    TypeStatus typeStatus;

    public CallDto(String name, String acronym, LocalDate endDate, TypeCall typeCall, Long institutionId, TypeStatus typeStatus) {
        this.name = name;
        this.acronym = acronym;
        this.endDate = endDate;
        this.typeCall = typeCall;
        this.institutionId = institutionId;
        this.typeStatus = typeStatus;
    }
}
