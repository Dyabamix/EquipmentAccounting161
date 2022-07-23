package com.projectForTPP2.EquipmentAccounting.repository.elementsOfTheDbStructureRepository;

import com.projectForTPP2.EquipmentAccounting.model.elementsOfTheDbStructure.Defect;
import com.projectForTPP2.EquipmentAccounting.model.elementsOfTheDbStructure.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DefectRepository extends JpaRepository<Defect, Long> {
    List<Defect> findDefectsByEquipment_Id(Long equipmentId);
}
