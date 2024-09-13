package kassandrafalsitta.u2w2d5.controllers;
import kassandrafalsitta.u2w2d5.entities.Travel;
import kassandrafalsitta.u2w2d5.exceptions.BadRequestException;
import kassandrafalsitta.u2w2d5.payloads.TravelDTO;
import kassandrafalsitta.u2w2d5.payloads.TravelRespDTO;
import kassandrafalsitta.u2w2d5.services.TravelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/travels")
public class TravelsController {
    @Autowired
    private TravelsService travelsService;

    @GetMapping
    public Page<Travel> getAllTravels(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size,
                                                @RequestParam(defaultValue = "id") String sortBy) {
        return this.travelsService.findAll(page, size, sortBy);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TravelRespDTO createTravel(@RequestBody @Validated TravelDTO body, BindingResult validationResult) {
        if(validationResult.hasErrors())  {
            String messages = validationResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(". "));
            throw new BadRequestException("Ci sono stati errori nel payload. " + messages);
        } else {
            return new TravelRespDTO(this.travelsService.saveTravel(body).getId());
        }
    }

    @GetMapping("/{travelId}")
    public Travel getTravelById(@PathVariable UUID travelId) {
        return travelsService.findById(travelId);
    }

    @PutMapping("/{travelId}")
    public Travel findTravelByIdAndUpdate(@PathVariable UUID travelId, @RequestBody TravelDTO body) {
        return travelsService.findByIdAndUpdate(travelId, body);
    }

    @DeleteMapping("/{travelId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findTravelByIdAndDelete(@PathVariable UUID travelId) {
        travelsService.findByIdAndDelete(travelId);
    }


}
