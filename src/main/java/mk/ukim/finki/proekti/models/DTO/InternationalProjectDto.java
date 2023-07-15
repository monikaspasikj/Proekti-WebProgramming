package mk.ukim.finki.proekti.models.DTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import mk.ukim.finki.proekti.models.Institution;
import mk.ukim.finki.proekti.models.enumerations.TypeStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class InternationalProjectDto {

    private String name;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateEntry;
    private TypeStatus typeStatus;
    private String description;
    private String type;
    private String goals;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDate;
    private Institution primaryInstitution;
    private Institution anotherInstitution;
    private Institution carrier;
    private Institution partners;


    public InternationalProjectDto(String name, LocalDate dateEntry, TypeStatus typeStatus, String description, String type, String goals, LocalDate startDate, LocalDate endDate, Institution primaryInstitution, Institution anotherInstitution, Institution carrier, Institution partners) {
        this.name = name;
        this.dateEntry = dateEntry;
        this.typeStatus = typeStatus;
        this.description = description;
        this.type = type;
        this.goals = goals;
        this.startDate = startDate;
        this.endDate = endDate;
        this.primaryInstitution = primaryInstitution;
        this.anotherInstitution = anotherInstitution;
        this.carrier = carrier;
        this.partners = partners;
    }

}
