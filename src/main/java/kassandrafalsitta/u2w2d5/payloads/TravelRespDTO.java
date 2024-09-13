package kassandrafalsitta.u2w2d5.payloads;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record TravelRespDTO(
        @NotNull(message = "L'UUID è obbligatorio")
        UUID travelId
) {
}
