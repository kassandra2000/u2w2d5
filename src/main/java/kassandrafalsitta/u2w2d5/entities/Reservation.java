package kassandrafalsitta.u2w2d5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;
    private LocalDate date;
    private String preferences;

    @ManyToOne
    @JoinColumn(name = "travel_id")
    private Travel travel;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
