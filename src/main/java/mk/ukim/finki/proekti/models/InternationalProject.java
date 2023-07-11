package mk.ukim.finki.proekti.models;


import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.proekti.models.enumerations.TypeStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Entity
public class InternationalProject {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    String name;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate dateEntry;
    @Enumerated(EnumType.STRING)
    TypeStatus typeStatus;
    String description;
    String type;
    String goals;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate startDate;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate endDate;
    @OneToOne
    Institution primaryInstitution;
    @OneToOne
    Institution anotherInstitution;
    @OneToOne
    Institution carrier;
    @OneToOne
    Institution partners;

    public InternationalProject(String name, LocalDate dateEntry, TypeStatus typeStatus, String description, String type, String goals, LocalDate startDate, LocalDate endDate, Institution primaryInstitution, Institution anotherInstitution, Institution carrier, Institution partners) {
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

    public InternationalProject() {

    }
}
