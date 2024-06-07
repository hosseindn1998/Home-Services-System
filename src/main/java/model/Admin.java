package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString(callSuper = true)
@Table(name = "admins")
public class Admin extends Person {
    @Builder
    public Admin(String firstName, String lastName, String email, String password, LocalDate registeredDate, Wallet wallet) {
        super(firstName, lastName, email, password, registeredDate, wallet);
    }
}
