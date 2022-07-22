package com.projectForTPP2.EquipmentAccounting.repository.elementsOfTheDbStructureRepository;

import com.projectForTPP2.EquipmentAccounting.model.elementsOfTheDbStructure.Defect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefectRepository extends JpaRepository<Defect, Long> {
}
