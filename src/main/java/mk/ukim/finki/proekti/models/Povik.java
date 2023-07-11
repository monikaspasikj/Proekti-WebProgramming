package mk.ukim.finki.proekti.models;


import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.proekti.models.enumerations.TypePovik;
import mk.ukim.finki.proekti.models.enumerations.TypeStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Entity
public class Povik {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    String acronym;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate endDate;
    @Enumerated(EnumType.STRING)
    TypePovik typePovik;
    @OneToOne
    Institution institution;
    @Enumerated(EnumType.STRING)
    TypeStatus typeStatus;

    public Povik(String acronym, LocalDate endDate, TypePovik typePovik, Institution institution, TypeStatus typeStatus) {
        this.acronym = acronym;
        this.endDate = endDate;
        this.typePovik = typePovik;
        this.institution = institution;
        this.typeStatus =  typeStatus;
    }

    public Povik() {

    }
}
