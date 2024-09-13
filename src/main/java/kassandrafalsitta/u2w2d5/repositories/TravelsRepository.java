package kassandrafalsitta.u2w2d5.repositories;

import kassandrafalsitta.u2w2d5.entities.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TravelsRepository extends JpaRepository<Travel, UUID> {
    Optional<Travel> findByDate(LocalDate date);
    Optional<Travel> findByDestination(String destination);

}
