package mk.ukim.finki.proekti.repository;

import mk.ukim.finki.proekti.models.Call;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CallRepository extends JpaRepository<Call, Long> {

    Page<Call> findAll(Pageable pageable);
}
