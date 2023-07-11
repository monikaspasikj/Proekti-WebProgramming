package mk.ukim.finki.proekti.repository;

import mk.ukim.finki.proekti.models.NationalProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NationalProjectRepository extends JpaRepository<NationalProject, Long> {
    String findAllByName(String name);
    String findAllByKeyWords (String words);

}
