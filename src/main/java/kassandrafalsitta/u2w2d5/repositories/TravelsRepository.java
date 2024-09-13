package kassandrafalsitta.u2w2d5.repositories;

import kassandrafalsitta.u2w2d5.entities.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TravelsRepository extends JpaRepository<Travel, UUID> {
}
