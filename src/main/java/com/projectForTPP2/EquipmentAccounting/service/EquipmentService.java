package com.projectForTPP2.EquipmentAccounting.service;

import com.projectForTPP2.EquipmentAccounting.model.elementsOfTheDbStructure.Defect;
import com.projectForTPP2.EquipmentAccounting.model.elementsOfTheDbStructure.Equipment;
import com.projectForTPP2.EquipmentAccounting.repository.elementsOfTheDbStructureRepository.DefectRepository;
import com.projectForTPP2.EquipmentAccounting.repository.elementsOfTheDbStructureRepository.EquipmentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class EquipmentService {

    private final EquipmentsRepository equipmentsRepository;
    private final DefectRepository defectRepository;

    //Equipment service
    public Equipment findById(Long id){
        return equipmentsRepository.findById(id).orElse(null);
    }

    public List<Equipment> findAll(){
        return equipmentsRepository.findAll();
    }

    public void saveEquipment(Equipment equipment){
        equipmentsRepository.save(equipment);
    }

    public void deleteById(Long id){
        equipmentsRepository.deleteById(id);
    }

    //Defect service
    public Defect findDefectById(Long id){
        return defectRepository.findById(id).orElse(null);
    }

    public List<Defect> findAllDefect(){
        return defectRepository.findAll();
    }

    public void saveDefect(Defect defect){
        defectRepository.save(defect);
    }

    public void deleteDefectById(Long id){
        defectRepository.deleteById(id);
    }
}
