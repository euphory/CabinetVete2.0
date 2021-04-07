/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.Adoptable;
import com.models.Adoption;
import com.models.Animal;
import com.models.Formulaire;
import com.services.AdoptableService;
import com.services.AdoptionService;
import com.services.AnimalService;
import com.services.FormulaireService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author PC
 */
@Controller
public class AdoptionController {
    
    @Autowired
    private AdoptionService adoptionService;
    @Autowired
    private FormulaireService formulaireService;
    @Autowired
    private AdoptableService adoptableService;
    @Autowired
    private AnimalService animalService;
    
    //retourne les adoptions
    @GetMapping("/adoptions")
    public String getAdoptions(Model model){
        
        List<Formulaire> formulaireList = formulaireService.getFormulaires();
        model.addAttribute("formulaires", formulaireList);
        
        List<Adoption> adoptionList = adoptionService.getAdoptions();
        model.addAttribute("adoptions", adoptionList);
        
        List<Animal> animalList = animalService.getAnimaux();
        model.addAttribute("animals", animalList);
        
        List<Adoptable> adoptableList = adoptableService.getAdoptables();
        model.addAttribute("adoptables", adoptableList);

        return "adoption";
    }
    
    @PostMapping("/adoptions/addNew")
    public String addNew(Adoption adoption){
        adoptionService.save(adoption);
        return "redirect:/adoptions";
    }
    
    @RequestMapping("adoptions/findById")
    @ResponseBody
    public Optional<Adoption> findById(Long id){
        return adoptionService.findById(id);
    }
    @RequestMapping(value="/adoptions/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Adoption adoption){
    adoptionService.save(adoption);
    return "redirect:/adoptions";
    }
    
    @RequestMapping(value="/adoptions/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id){
    adoptionService.delete(id);
    return "redirect:/adoptions";
    }
    
}
