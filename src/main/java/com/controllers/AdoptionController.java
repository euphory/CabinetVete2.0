/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.Adoption;
import com.models.Consultation;
import com.services.AdoptionService;
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
public class AdoptionController {
    
    @Autowired
    private AdoptionService adoptionService;
    
    //retourne les adoptions
    @GetMapping("/adoptions")
    public String getAdoptions(Model model){
        List<Adoption> adoptionList = adoptionService.getAdoptions();
        model.addAttribute("adoptions", adoptionList);
        return "adoption";
    }
    
    @PostMapping("/adoptions/addNew")
    public String addNew(Adoption adoption){
        adoptionService.save(adoption);
        return "redirect:/adoptions";
    }
}
