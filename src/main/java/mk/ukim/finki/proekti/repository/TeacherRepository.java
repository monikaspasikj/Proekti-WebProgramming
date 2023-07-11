package mk.ukim.finki.proekti.repository;

import mk.ukim.finki.proekti.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    String findAllByName(String name);
    String findAllBySurname(String surname);
}
