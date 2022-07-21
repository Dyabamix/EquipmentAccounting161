package com.projectForTPP2.EquipmentAccounting.repository.elementsOfTheDbStructureRepository;

import com.projectForTPP2.EquipmentAccounting.model.elementsOfTheDbStructure.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentsRepository extends JpaRepository<Equipment, Long> {

}
