package kassandrafalsitta.u2w2d5.services;

import kassandrafalsitta.u2w2d5.entities.Travel;
import kassandrafalsitta.u2w2d5.enums.StateTravel;
import kassandrafalsitta.u2w2d5.exceptions.BadRequestException;
import kassandrafalsitta.u2w2d5.exceptions.NotFoundException;
import kassandrafalsitta.u2w2d5.payloads.TravelDTO;
import kassandrafalsitta.u2w2d5.repositories.TravelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TravelsService {
    @Autowired
    private TravelsRepository travelsRepository;

    public Page<Travel> findAll(int page, int size, String sortBy) {
        if (page > 100) page = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.travelsRepository.findAll(pageable);
    }

    public Travel saveTravel(TravelDTO body) {
        Optional<Travel> dateTravel = travelsRepository.findByDate(body.date());
        Optional<Travel> destinationTravel = travelsRepository.findByDestination(body.destination());
        if (dateTravel.isPresent() && destinationTravel.isPresent()) {
            throw new BadRequestException("La data " + body.date() + " e la destinazione " + body.destination() + " sono già in uso!");
        }
        StateTravel stateTravel = null;
        try {
             stateTravel = StateTravel.valueOf(body.stateTravel());
        } catch (IllegalArgumentException e) {
           throw new BadRequestException("Stato del viaggio non valido: " + body.stateTravel());
        }
        Travel employee = new Travel(body.destination(), body.date(), stateTravel);
        return this.travelsRepository.save(employee);
    }

    public Travel findById(UUID travelId) {
        return this.travelsRepository.findById(travelId).orElseThrow(() -> new NotFoundException(travelId));
    }

    public Travel findByIdAndUpdate(UUID reservationId, TravelDTO updatedTravel) {
        Travel found = findById(reservationId);
        found.setDate(updatedTravel.date());
        StateTravel stateTravel = null;
        try {
            stateTravel = StateTravel.valueOf(updatedTravel.stateTravel());
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Stato del viaggio non valido: " + updatedTravel.stateTravel());
        }
        found.setStateTravel(stateTravel);
        found.setDestination(updatedTravel.destination());
        return this.travelsRepository.save(found);
    }

    public void findByIdAndDelete(UUID travelId) {
        this.travelsRepository.delete(this.findById(travelId));
    }
}
