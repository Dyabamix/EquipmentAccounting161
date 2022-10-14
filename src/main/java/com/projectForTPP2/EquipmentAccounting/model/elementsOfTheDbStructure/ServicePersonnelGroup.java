package com.projectForTPP2.EquipmentAccounting.model.elementsOfTheDbStructure;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "service_personnel_group")
public class ServicePersonnelGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_subgroup")
    private Set<Subgroup> subgroups = new HashSet<>();
}
