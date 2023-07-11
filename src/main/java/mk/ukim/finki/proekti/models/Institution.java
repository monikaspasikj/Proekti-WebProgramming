package mk.ukim.finki.proekti.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Institution {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    String name;
    String location;

    public Institution(String name, String location) {
        this.name = name;
        this.location = location;
    }


    public Institution() {

    }
}
