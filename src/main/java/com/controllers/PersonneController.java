/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.Formulaire;
import com.models.Personne;
import com.services.FormulaireService;
import com.services.PersonneService;
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
public class PersonneController {
    
    @Autowired
    private PersonneService personneService;
    @Autowired
    private FormulaireService formulaireService;
    
    //retourne les personnes
    @GetMapping("/personnes")
    public String getPersonnes(Model model){
        List<Personne> personneList = personneService.getPersonnes();
        model.addAttribute("personnes", personneList);
        return "personne";
    }
    
    @PostMapping("/personnes/addNew")
    public String addNew(Personne personne){
        personneService.save(personne);
        return "redirect:/personnes";
    }
    
    @RequestMapping("personnes/findById")
    @ResponseBody
    public Optional<Personne> findById(Long id){
        return personneService.findById(id);
    }
    @RequestMapping(value="/personnes/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Personne personne){
        personneService.save(personne);
        return "redirect:/personnes";
    }
    
    @RequestMapping(value="/personnes/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id){
        personneService.delete(id);
        return "redirect:/personnes";
    }
    
}
