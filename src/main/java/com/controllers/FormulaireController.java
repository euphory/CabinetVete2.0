/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.Adoption;
import com.models.Formulaire;
import com.services.AdoptionService;
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
public class FormulaireController {
    
    @Autowired
    private FormulaireService formulaireService;
    @Autowired
    private AdoptionService adoptionService;
    
    //retourne les formulaires
    @GetMapping("/formulaires")
    public String getFormulaires(Model model){
        List<Formulaire> formulaireList = formulaireService.getFormulaires();
        model.addAttribute("formulaires", formulaireList);
        
        List<Adoption> adoptionList = adoptionService.getAdoptions();
        model.addAttribute("adoptions", adoptionList);
        return "formulaire";
    }
    
    @PostMapping("/formulaires/addNew")
    public String addNew(Formulaire formulaire){
        formulaireService.save(formulaire);
        return "redirect:/formulaires";
    }
    
    @RequestMapping("formulaires/findById")
    @ResponseBody
    public Optional<Formulaire> findById(int id){
        return formulaireService.findById(id);
    }
    @RequestMapping(value="/formulaires/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Formulaire formulaire){
    formulaireService.save(formulaire);
    return "redirect:/formulaires";
    }
    
    @RequestMapping(value="/formulaires/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
    formulaireService.delete(id);
    return "redirect:/formulaires";
    }
}
    