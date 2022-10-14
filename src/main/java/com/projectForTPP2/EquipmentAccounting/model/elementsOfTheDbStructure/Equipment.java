package com.projectForTPP2.EquipmentAccounting.model.elementsOfTheDbStructure;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "equipments")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "number_position")
    private String numberPosition;
    private String name;
    @Column(name = "ship_condition")
    private int shipCondition;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_equipment")
    private Set<Defect> defects = new HashSet<>();

}
