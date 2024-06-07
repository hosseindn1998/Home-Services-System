package model;

import base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
@ToString(callSuper = true)
@Table(name = "offer")
public class Offer extends BaseEntity<Long> {
    @ManyToOne
    @ToString.Exclude
    Order odrer;
    LocalDate dateOfOfferToStart;
    @Min(0)
    Long suggestPrice;
    LocalDate dateOfOfferToDone;
    @ManyToOne
    Technician technician;
    Boolean isAccepted;

}
