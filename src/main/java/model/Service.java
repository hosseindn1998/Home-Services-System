package model;

import base.entity.BaseEntity;
import jakarta.persistence.*;
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
@Table(name = "service")
public class Service extends BaseEntity<Long> {
    @Column(unique = true)
    @NotNull
    String name;
    @OneToMany(mappedBy = "service",cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    @ElementCollection()
    @ToString.Exclude
    List<SubService> subServices;

}
