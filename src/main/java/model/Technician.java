package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString(callSuper = true)
@Table(name = "Technician")
public class Technician extends Person {
    @Enumerated(EnumType.ORDINAL)
    TechnicianStatus technicianStatus;
    @NotNull
    @Min(0)
    @Max(5)
    double rate;
    @Lob
    @ToString.Exclude
    byte[] avatar;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "technician", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @ToString.Exclude
    List<TechnicianSubService> technicianSubServices;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "technician", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @ToString.Exclude
    List<Comment> comments;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "technician", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @ToString.Exclude
    List<Offer> offers;

    @Builder
    public Technician(String firstName, String lastName, String email, String password, LocalDate registeredDate, Wallet wallet, TechnicianStatus technicianStatus, double rate, byte[] avatar, List<TechnicianSubService> technicianSubServices, List<Comment> comments, List<Offer> offers) {
        super(firstName, lastName, email, password, registeredDate, wallet);
        this.technicianStatus = technicianStatus;
        this.rate = rate;
        this.avatar = avatar;
        this.technicianSubServices = technicianSubServices;
        this.comments = comments;
        this.offers = offers;
    }
}
