package mk.ukim.finki.proekti.models.DTO;

import lombok.Data;

@Data
public class InstitutionDto {
    String name;
    String location;

    public InstitutionDto(String name, String location) {
        this.name = name;
        this.location = location;
    }
}
