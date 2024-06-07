package model;

import base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
@ToString(callSuper = true)
@Table(name = "wallet")

public class Wallet extends BaseEntity<Long> {
    @NotNull
    @Min(0)
    Long amount;

}
