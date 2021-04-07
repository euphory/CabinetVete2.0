/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.Animal;
import com.models.Prestation;
import com.services.AnimalService;
import com.services.ConsultationService;
import com.services.PrestationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author PC
 */
@Controller
public class PrestationController {
        
    @Autowired
    private PrestationService prestationService;
    @Autowired
    private AnimalService animalService;
    @Autowired
    private ConsultationService consultationService;

    //retourne les prestations
    @GetMapping("/prestations")
    public String getPrestations(Model model){
        
        List<Animal> animalList = animalService.getAnimaux();
        model.addAttribute("animaux", animalList);        
        
        List<Prestation> prestationList = prestationService.getPrestations();
        model.addAttribute("prestations", prestationList);
        return "prestation";
    }
    
    @PostMapping("/prestations/addNew")
    public String addNew(Prestation prestation,            
            @RequestParam Long idConsultation){
        prestation.setConsultation(consultationService.findById(idConsultation).orElse(null));
        prestationService.save(prestation);
        return "redirect:/prestations";
    }
    
    @RequestMapping("prestations/findById")
    @ResponseBody
    public Optional<Prestation> findById(Long id){
        return prestationService.findById(id);
    }
    @RequestMapping(value="/prestations/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Prestation prestation){
    prestationService.save(prestation);
    return "redirect:/prestations";
    }
    
    @RequestMapping(value="/prestations/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id){
    prestationService.delete(id);
    return "redirect:/prestations";
    }
    
}
