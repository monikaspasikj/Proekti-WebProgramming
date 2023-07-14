package mk.ukim.finki.proekti.repository;

import mk.ukim.finki.proekti.models.Call;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CallRepository extends JpaRepository<Call, Long> {
}
