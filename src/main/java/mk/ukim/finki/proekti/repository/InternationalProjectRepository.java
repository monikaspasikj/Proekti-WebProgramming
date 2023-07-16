package mk.ukim.finki.proekti.repository;

import mk.ukim.finki.proekti.models.InternationalProject;
import mk.ukim.finki.proekti.models.enumerations.TypeStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternationalProjectRepository extends JpaRepository<InternationalProject, Long> {
    List<InternationalProject> findAllByName(String name);

    List<InternationalProject> findByTypeStatus(TypeStatus typeStatus);

    List<InternationalProject> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String description);

    List<InternationalProject> findByApprovedIsTrue();

    Page<InternationalProject> findAll(Pageable pageable);
}
