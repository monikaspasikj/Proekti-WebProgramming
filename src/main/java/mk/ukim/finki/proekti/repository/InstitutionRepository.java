package mk.ukim.finki.proekti.repository;

import mk.ukim.finki.proekti.models.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    List<Institution> findByLocation(String location);
    Institution findByName(String name);
}
