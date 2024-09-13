package kassandrafalsitta.u2w2d5.repositories;

import kassandrafalsitta.u2w2d5.entities.Reservation;
import kassandrafalsitta.u2w2d5.entities.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservation, UUID> {
    //anche se non ho un parametro chiamato EmployeeId Spring si va a cercare l'id del dipendente perchè tramite il nome capisce che sto cercando il campo id
    Optional<Reservation> findByEmployeeIdAndDate(UUID employeeId, LocalDate date);
}
