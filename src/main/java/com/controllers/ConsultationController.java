/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.Consultation;
import com.services.ConsultationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author PC
 */
@Controller
public class ConsultationController {
    
     @Autowired
    private ConsultationService consultationService;
    
    //retourne les consultations
    @GetMapping("/consultations")
    public String getConsultations(Model model){
        
        List<Consultation> consultationList = consultationService.getConsultations();
        model.addAttribute("consultations", consultationList);
        return "consultation";
    }
    
    @PostMapping("/consultations/addNew")
    public String addNew(Consultation consultation,
                         @RequestParam String date,
                         @RequestParam String heureDebutTime,
                         @RequestParam String heureFinTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            consultation.setHeureDebut(sdf.parse(date.concat(" ").concat(heureDebutTime)));
            consultation.setHeureFin(sdf.parse(date.concat(" ").concat(heureFinTime)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        consultationService.save(consultation);
        return "redirect:/consultations";
    }
    
    @RequestMapping("consultations/findById")
    @ResponseBody
    public Optional<Consultation> findById(Long id){
        return consultationService.findById(id);
    }
    @RequestMapping(value="/consultations/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Consultation consultation){
    consultationService.save(consultation);
    return "redirect:/consultations";
    }
    
    @RequestMapping(value="/consultations/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id){
    consultationService.delete(id);
    return "redirect:/consultations";
    }
    
}
