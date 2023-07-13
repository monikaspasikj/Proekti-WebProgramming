package mk.ukim.finki.proekti.repository;

import mk.ukim.finki.proekti.models.NationalProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NationalProjectRepository extends JpaRepository<NationalProject, Long> {

    List<NationalProject> findAllByNameContainingIgnoreCase(String name);

    List<NationalProject> findAllByKeyWordsContainingIgnoreCase(String words);
}
