package mk.ukim.finki.proekti.data;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.proekti.models.Institution;
import mk.ukim.finki.proekti.models.Teacher;
import mk.ukim.finki.proekti.models.enumerations.TypeTeacher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Institution> institutions = new ArrayList<>();
    public static List<Teacher> teachers = new ArrayList<>();

    @PostConstruct
    public void init() {
        teachers.add(new Teacher("Ристе", "Стојанов", "riste.stojanov@finki.ukim.mk", TypeTeacher.Docent));
        teachers.add(new Teacher("Костадин", "Мишев", "kostadin.mishev@finki.ukim.mk", TypeTeacher.Docent));
        teachers.add(new Teacher("Сашо", "Граматиков", "sasho.gramatikov@finki.ukim.mk", TypeTeacher.Redoven));
        institutions.add(new Institution("Факултет за информатички науки и компјутерско инженерство", "Скопје"));
        institutions.add(new Institution("Министерство за образование и наука", "Скопје"));
    }
}
