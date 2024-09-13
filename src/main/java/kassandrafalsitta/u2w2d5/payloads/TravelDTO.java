package kassandrafalsitta.u2w2d5.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kassandrafalsitta.u2w2d5.enums.StateTravel;

import java.time.LocalDate;

public record TravelDTO(
        @NotEmpty(message = "La destinazione è obbligatoria")
        @Size(min = 3, max = 30, message = "La destinazione deve essere compresa tra 3 e 30 caratteri")
        String destination,
        @NotNull(message = "La data è obbligatoria")
        LocalDate date,
        @NotEmpty(message = "Lo stato è obbligatorio")
        String stateTravel
) {
}
