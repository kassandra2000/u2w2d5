package kassandrafalsitta.u2w2d5.services;

import kassandrafalsitta.u2w2d5.entities.Employee;
import kassandrafalsitta.u2w2d5.entities.Reservation;
import kassandrafalsitta.u2w2d5.exceptions.NotFoundException;
import kassandrafalsitta.u2w2d5.repositories.ReservationsRepository;
import kassandrafalsitta.u2w2d5.repositories.TravelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReservationsService {
    @Autowired
    private ReservationsRepository reservationsRepository;

    public Page<Reservation> findAll(int page, int size, String sortBy) {
        if (page > 100) page = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.reservationsRepository.findAll(pageable);
    }

    public Reservation findById(UUID reservationId) {
        return this.reservationsRepository.findById(reservationId).orElseThrow(() -> new NotFoundException(reservationId));
    }
}
