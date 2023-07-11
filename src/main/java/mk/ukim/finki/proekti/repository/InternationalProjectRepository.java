package mk.ukim.finki.proekti.repository;

import mk.ukim.finki.proekti.models.InternationalProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternationalProjectRepository extends JpaRepository<InternationalProject, Long> {
    String findAllByName(String name);
}
