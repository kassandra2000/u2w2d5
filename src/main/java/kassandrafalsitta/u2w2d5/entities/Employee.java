package kassandrafalsitta.u2w2d5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "employees")
public class Employee {
        @Id
        @GeneratedValue
        @Setter(AccessLevel.NONE)
        private UUID id;
        private String username;
        private String name;
        private String surname;
        private String email;
        private String avatar;
}
