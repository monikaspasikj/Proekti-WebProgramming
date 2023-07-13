package mk.ukim.finki.proekti.repository;

import mk.ukim.finki.proekti.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAllByName(String name);
    List<Teacher> findAllBySurname(String surname);
}
