package kassandrafalsitta.u2w2d5.entities;

import jakarta.persistence.*;
import kassandrafalsitta.u2w2d5.enums.StateTravel;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "travels")
public class Travel {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String destination;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private StateTravel stateTravel;
}
