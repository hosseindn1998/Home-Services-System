package model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString(callSuper = true)
@Table(name = "customer")
public class Customer extends Person{
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "customer",cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    @ToString.Exclude
    List<Order> orders;
    @Builder
    public Customer(String firstName, String lastName, String email, String password, LocalDate registeredDate, Wallet wallet) {
        super(firstName, lastName, email, password, registeredDate, wallet);
    }
}
