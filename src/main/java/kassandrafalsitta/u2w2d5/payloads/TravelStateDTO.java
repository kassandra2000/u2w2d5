package kassandrafalsitta.u2w2d5.payloads;

import jakarta.validation.constraints.NotEmpty;

public record TravelStateDTO(
        @NotEmpty(message = "Lo stato è obbligatorio")
        String stateTravel
) {
}
