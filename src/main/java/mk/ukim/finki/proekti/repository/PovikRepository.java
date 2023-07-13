package mk.ukim.finki.proekti.repository;

import mk.ukim.finki.proekti.models.Povik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PovikRepository extends JpaRepository<Povik, Long> {
    List<Povik> findAllByAcronym(String acronym);
}
