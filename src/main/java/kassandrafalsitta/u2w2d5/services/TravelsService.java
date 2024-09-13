package kassandrafalsitta.u2w2d5.services;

import kassandrafalsitta.u2w2d5.entities.Travel;
import kassandrafalsitta.u2w2d5.exceptions.NotFoundException;
import kassandrafalsitta.u2w2d5.repositories.TravelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    public Travel findById(UUID travelId) {
        return this.travelsRepository.findById(travelId).orElseThrow(() -> new NotFoundException(travelId));
    }
}
