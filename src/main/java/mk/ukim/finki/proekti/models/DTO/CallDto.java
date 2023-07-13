package mk.ukim.finki.proekti.models.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Data;
import mk.ukim.finki.proekti.models.Institution;
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

    TypeCall typePovik;

    Long institution;

    TypeStatus typeStatus;

    public CallDto(String name, String acronym, LocalDate endDate, TypeCall typePovik, Long institution, TypeStatus typeStatus) {
        this.name=name;
        this.acronym = acronym;
        this.endDate = endDate;
        this.typePovik = typePovik;
        this.institution = institution;
        this.typeStatus = typeStatus;
    }
}
