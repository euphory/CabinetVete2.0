/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers.consultations;

import com.models.Consultation;
import com.services.ConsultationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author PC
 */
@Controller
public class ConsultationController {
    
    @Autowired
    private ConsultationService consultationService;
    
    @GetMapping("/consultations")
    public String getConsultations(Model model){
        List<Consultation> consultationList = consultationService.getConsultations();
        model.addAttribute("consultation", consultationList);
        return "consultation";
    }
    
    @PostMapping("/consultations/addNew")
    public String addNew(Consultation consultation){
        consultationService.save(consultation);
        return "redirect:/consultations";
    }
    
}
