package kassandrafalsitta.u2w2d5.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public record ReservationDTO(
        @NotNull(message = "La data è obbligatoria")
        LocalDate date,
        @NotEmpty(message = "La preferenza è obbligatoria")
        @Size(min = 3, max = 100, message = "La preferenza deve essere compresa tra 3 e 100 caratteri")
        String preferences,
        @NotNull(message = "L'UUID del viaggio è obbligatorio")
        UUID travelID,
        @NotNull(message = "L'UUID del dipendente è obbligatorio")
        UUID employeeID
) {
}
