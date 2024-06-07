package model;

import base.entity.BaseEntity;
import jakarta.persistence.*;
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
@Builder
@ToString(callSuper = true)
@Table(name = "odrer")
public class Order extends BaseEntity<Long> {
    @ManyToOne
    SubService subservice;
    @ManyToOne
    Customer customer;
    @Min(0)
    Long suggestedPrice;
    @Min(0)
    Long agreedPrice;
    @Min(0)
    Long technicianWalletId;
    @NotNull
    Boolean isPaid;
    @NotNull
    String description;
    LocalDate dateForDo;
    @NotNull
    String address;
    @Enumerated
    OrderStatus orderStatus;
    @OneToMany(mappedBy = "odrer",cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
    @ToString.Exclude
    List<Offer> offers;
    @OneToOne
    Offer choosedOffer;
}
