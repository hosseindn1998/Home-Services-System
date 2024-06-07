package model;

import base.entity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "technician_subservice")
public class TechnicianSubService extends BaseEntity<Long> {
    @ManyToOne(cascade = {CascadeType.MERGE})
    Technician technician;
    @ManyToOne(cascade = {CascadeType.MERGE})
    SubService subService;
}
