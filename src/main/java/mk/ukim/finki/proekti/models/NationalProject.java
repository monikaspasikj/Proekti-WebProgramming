package mk.ukim.finki.proekti.models;


import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.proekti.models.enumerations.TypeStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class NationalProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate dateEntry;
    @Enumerated(EnumType.STRING)
    TypeStatus typeStatus;
    String keyWords;
    String summary;
    String benefits;
    @OneToMany
    List<Teacher> members;
    @OneToOne
    Teacher manager;
    @OneToOne
    Call call;
    Boolean approved;

    public NationalProject(String name, LocalDate dateEntry, TypeStatus typeStatus, String keyWords, String summary, String benefits, List<Teacher> members, Teacher manager, Call call) {
        this.name = name;
        this.dateEntry = dateEntry;
        this.typeStatus = typeStatus;
        this.keyWords = keyWords;
        this.summary = summary;
        this.benefits = benefits;
        this.members = members;
        this.manager = manager;
        this.call = call;
        this.approved = false;
    }

    public NationalProject() {

    }
}
