package mk.ukim.finki.proekti.repository;

import mk.ukim.finki.proekti.models.NationalProject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NationalProjectRepository extends JpaRepository<NationalProject, Long> {

    List<NationalProject> findAllByNameContainingIgnoreCase(String name);

    List<NationalProject> findAllByKeyWordsContainingIgnoreCase(String words);

    List<NationalProject> findByApprovedIsTrue();

    Page<NationalProject> findAll(Pageable pageable);
}
