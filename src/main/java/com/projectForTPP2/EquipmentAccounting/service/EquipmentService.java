package com.projectForTPP2.EquipmentAccounting.service;

import com.projectForTPP2.EquipmentAccounting.model.elementsOfTheDbStructure.Equipment;
import com.projectForTPP2.EquipmentAccounting.repository.elementsOfTheDbStructureRepository.EquipmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EquipmentService {

    private final EquipmentsRepository equipmentsRepository;

    @Autowired
    public EquipmentService(EquipmentsRepository equipmentsRepository) {
        this.equipmentsRepository = equipmentsRepository;
    }

    public Equipment findById(Long id){
        return equipmentsRepository.findById(id).orElse(null);
    }

    public List<Equipment> findAll(){
        return equipmentsRepository.findAll();
    }

    public Equipment saveEquipment(Equipment equipment){
        return equipmentsRepository.save(equipment);
    }

    public void deleteById(Long id){
        equipmentsRepository.deleteById(id);
    }
}
