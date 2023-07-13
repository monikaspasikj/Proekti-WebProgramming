package mk.ukim.finki.proekti.repository;

import mk.ukim.finki.proekti.models.InternationalProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternationalProjectRepository extends JpaRepository<InternationalProject, Long> {
    List<InternationalProject> findAllByName(String name);
}
