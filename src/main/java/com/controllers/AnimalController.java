/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.Adoptable;
import com.models.Animal;
import com.models.Antecedent;
import com.models.Espece;
import com.models.Personne;
import com.services.AdoptableService;
import com.services.AnimalService;
import com.services.AntecedentService;
import com.services.EspeceService;
import com.services.PersonneService;
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
public class AnimalController {
    
    @Autowired
    private AnimalService animalService;
    @Autowired
    private AdoptableService adoptableService;
    @Autowired
    private EspeceService especeService;
    @Autowired
    private AntecedentService antecedentService;
    @Autowired
    private PersonneService personneService;
    
    //retourne les animaux
    @GetMapping("/animaux")
    public String getAnimaux(Model model){
        
        List<Adoptable> adoptableList = adoptableService.getAdoptables();
        model.addAttribute("adoptable", adoptableList);
        
        List<Antecedent> antecedentList = antecedentService.getAntecedents();
        model.addAttribute("antecedent", antecedentList); 
        
        List<Espece> especeList = especeService.getEspeces();
        model.addAttribute("especes", especeList);
        
        List<Animal> animalList = animalService.getAnimaux();
        model.addAttribute("animaux", animalList);
        
        List<Personne> personneList = personneService.getPersonnes();
        model.addAttribute("personne", personneList);
        
        
        return "animal";
    }
    
    @PostMapping("/animaux/addNew")
    public String addNew(Animal animal, 
            @RequestParam Long idEspece){
        animal.setEspece(especeService.findById(idEspece).orElse(null));
        animalService.save(animal);
        return "redirect:/animaux";
    }
    
    @RequestMapping("animaux/findById")
    @ResponseBody
    public Optional<Animal> findById(Long id){
        return animalService.findById(id);
    }
    @RequestMapping(value="/animaux/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Animal animal){
    animalService.save(animal);
    return "redirect:/animaux";
    }
    
    @RequestMapping(value="/animaux/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id){
    animalService.delete(id);
    return "redirect:/animaux";
    }
}
