package com.projectForTPP2.EquipmentAccounting.model.elementsOfTheDbStructure;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "defects")
public class Defect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(name = "defect_description")
    private String defectDescription;
    private Date date;
}
