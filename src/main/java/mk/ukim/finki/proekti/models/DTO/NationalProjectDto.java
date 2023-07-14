package mk.ukim.finki.proekti.models.DTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import mk.ukim.finki.proekti.models.enumerations.TypeStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
public class NationalProjectDto {
    private String name;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateEntry;
    private TypeStatus typeStatus;
    private String keyWords;
    private String summary;
    private String benefits;
    private List<Long> members;
    private Long manager;
    private Long callId;
    private Boolean approved;

    public NationalProjectDto(String name, LocalDate dateEntry, TypeStatus typeStatus, String keyWords, String summary, String benefits, List<Long> members, Long manager, Long callId) {
        this.name = name;
        this.dateEntry = dateEntry;
        this.typeStatus = typeStatus;
        this.keyWords = keyWords;
        this.summary = summary;
        this.benefits = benefits;
        this.members = members;
        this.manager = manager;
        this.callId = callId;
        this.approved = false;
    }
}
