package mk.ukim.finki.proekti.models;



import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.proekti.models.enumerations.TypeTeacher;
@Data
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;
    String email;
    @Enumerated(EnumType.STRING)
    TypeTeacher typeTeacher;

    public Teacher(String name, String surname, String email, TypeTeacher typeTeacher) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.typeTeacher = typeTeacher;
    }


    public Teacher() {

    }
}
