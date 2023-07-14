package mk.ukim.finki.proekti.models;


import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.proekti.models.enumerations.TypeCall;
import mk.ukim.finki.proekti.models.enumerations.TypeStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Entity
public class Call {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String acronym;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate endDate;
    @Enumerated(EnumType.STRING)
    TypeCall typeCall;
    @OneToOne
    Institution institution;
    @Enumerated(EnumType.STRING)
    TypeStatus typeStatus;

    public Call(String name, String acronym, LocalDate endDate, TypeCall typeCall, Institution institution, TypeStatus typeStatus) {
        this.name = name;
        this.acronym = acronym;
        this.endDate = endDate;
        this.typeCall = typeCall;
        this.institution = institution;
        this.typeStatus = typeStatus;
    }

    public Call() {

    }
}
