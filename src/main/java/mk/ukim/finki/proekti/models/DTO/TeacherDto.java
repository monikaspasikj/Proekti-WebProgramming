package mk.ukim.finki.proekti.models.DTO;

import lombok.Data;
import mk.ukim.finki.proekti.models.enumerations.TypeTeacher;

@Data
public class TeacherDto {
    String name;
    String surname;
    String email;
    TypeTeacher typeTeacher;

    public TeacherDto(String name, String surname, String email, TypeTeacher typeTeacher) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.typeTeacher = typeTeacher;
    }
}
