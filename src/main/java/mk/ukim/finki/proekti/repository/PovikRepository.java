package mk.ukim.finki.proekti.repository;

import mk.ukim.finki.proekti.models.Povik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PovikRepository extends JpaRepository<Povik, Long> {
    String findAllByAcronym(String acronym);
}
