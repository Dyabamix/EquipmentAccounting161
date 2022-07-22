package com.projectForTPP2.EquipmentAccounting.controller;

import com.projectForTPP2.EquipmentAccounting.model.elementsOfTheDbStructure.Defect;
import com.projectForTPP2.EquipmentAccounting.model.elementsOfTheDbStructure.Equipment;
import com.projectForTPP2.EquipmentAccounting.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EquipmentController {

    private final EquipmentService equipmentService;

    @Autowired
    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/equipments")
    public String findAll(@RequestParam(name = "equipment_id", required = false) Long equipment_id,
                          @RequestParam(name = "defect_id", required = false) Long defect_id,
                          Model model){
        System.out.println(equipment_id);
        System.out.println(defect_id);
        if (equipment_id != null){
            equipmentService.deleteById(equipment_id);
            return "redirect:/equipments";
        }
        if (defect_id != null){
            equipmentService.deleteDefectById(defect_id);
            return "redirect:/equipments";
        }

        List<Equipment> equipments = equipmentService.findAll();
        List<Defect> defects = equipmentService.findAllDefect();

        model.addAttribute("equipments" ,equipments);
        model.addAttribute("defects", defects);
        return "equipment-list";
    }

    //Equipment create/delete/update
    @GetMapping("/equipment-create")
    public String createEquipmentForm(Equipment equipment){
        return "equipment-create";
    }

    @PostMapping("/equipment-create")
    public String createEquipment(Equipment equipment){
        equipmentService.saveEquipment(equipment);
        return "redirect:/equipments";
    }


    //Defect create/delete/update
    @GetMapping("/defect-create")
    public String createDefectForm(Defect defect){
        return "defect-create";
    }

    @PostMapping("/defect-create")
    public String createDefect(Defect defect){
        equipmentService.saveDefect(defect);
        return "redirect:/equipments";
    }

}
