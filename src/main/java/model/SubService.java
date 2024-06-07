package model;

import base.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
@ToString(callSuper = true)
@Table(name = "subService")
public class SubService extends BaseEntity<Long> {
    @Column(unique = true)
    String name;
    @Min(0)
    Long basePrice;
    @NotNull
    String description;
    @ManyToOne
    Service service;
    @OneToMany(mappedBy = "subService", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    @ToString.Exclude
    List<TechnicianSubService> technicianSubServices;
    @ToString.Exclude
    @OneToMany(mappedBy = "subservice", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    List<Order> orders;
}
