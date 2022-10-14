package com.projectForTPP2.EquipmentAccounting.controller;

import com.projectForTPP2.EquipmentAccounting.model.elementsOfTheDbStructure.Defect;
import com.projectForTPP2.EquipmentAccounting.model.elementsOfTheDbStructure.Equipment;
import com.projectForTPP2.EquipmentAccounting.model.elementsOfTheDbStructure.EquipmentForm;
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
        List<Defect> defects = equipmentService.findAllDefect();

        model.addAttribute("equipments" ,equipments);
        model.addAttribute("defects", defects);
        return "equipment-list";
    }

    //Equipment create/delete/update
    @GetMapping("/equipment-create")
    public String createEquipmentForm(EquipmentForm equipmentForm){
        return "equipment-create";
    }

    @PostMapping("/equipment-create")
    public String createEquipment(EquipmentForm equipmentForm){
        if (equipmentForm.getDefect().getDate() != null){
            equipmentForm.getEquipment().getDefects().add(equipmentForm.getDefect());
        }
        System.out.println(equipmentForm.getEquipment().getId());
        System.out.println(equipmentForm.getDefect().getId());

        equipmentService.saveEquipment(equipmentForm.getEquipment());
        return "redirect:/equipments";
    }

}
