package mk.ukim.finki.proekti.models.DTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import mk.ukim.finki.proekti.models.Povik;
import mk.ukim.finki.proekti.models.Teacher;
import mk.ukim.finki.proekti.models.enumerations.TypeStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
public class NationalProjectDto {
    String name;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate dateEntry;

    TypeStatus typeStatus;
    String keyWords;
    String summary;
    String benefits;


    List<Long> members;

    Long manager;

    Long povik;

    public NationalProjectDto(String name, LocalDate dateEntry, TypeStatus typeStatus, String keyWords, String summary, String benefits, List<Long> members, Long manager, Long povik) {
        this.name = name;
        this.dateEntry = dateEntry;
        this.typeStatus = typeStatus;
        this.keyWords = keyWords;
        this.summary = summary;
        this.benefits = benefits;
        this.members = members;
        this.manager = manager;
        this.povik = povik;
    }
}
