package kassandrafalsitta.u2w2d5.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record EmployeeDTO(
        @NotEmpty(message = "Lo username è obbligatorio")
        @Size(min = 3, max = 40, message = "Lo username deve essere compreso tra 3 e 40 caratteri")
        String username,
        @NotEmpty(message = "Il nome proprio è obbligatorio")
        @Size(min = 3, max = 40, message = "Il nome proprio deve essere compreso tra 3 e 40 caratteri")
        String name,
        @NotEmpty(message = "Il cognome è obbligatorio")
        @Size(min = 3, max = 40, message = "Il cognome deve essere compreso tra 3 e 40 caratteri")
        String surname,
        @NotEmpty(message = "L'email è obbligatoria")
        @Email(message = "L'email inserita non è valida")
        String email
) {
}
