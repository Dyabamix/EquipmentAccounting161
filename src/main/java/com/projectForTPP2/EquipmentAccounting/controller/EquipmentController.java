package com.projectForTPP2.EquipmentAccounting.controller;

import com.projectForTPP2.EquipmentAccounting.model.elementsOfTheDbStructure.Equipment;
import com.projectForTPP2.EquipmentAccounting.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EquipmentController {

    private final EquipmentService equipmentService;

    @Autowired
    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/equipments")
    public String findAll(Model model){
        List<Equipment> equipments = equipmentService.findAll();
        model.addAttribute("equipments" ,equipments);
        return "equipment-list";
    }

    @GetMapping("/equipment-create")
    public String createEquipmentForm(Equipment equipment){
        return "equipment-create";
    }

    @PostMapping("/equipment-create")
    public String createEquipment(Equipment equipment){
        equipmentService.saveEquipment(equipment);
        return "redirect:/equipments";
    }

}
