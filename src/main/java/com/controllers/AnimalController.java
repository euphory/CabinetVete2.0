/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.Animal;
import com.models.Espece;
import com.services.AdoptableService;
import com.services.AnimalService;
import com.services.AntecedentService;
import com.services.EspeceService;
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
public class AnimalController {
    
    @Autowired
    private AnimalService animalService;
    @Autowired
    private AdoptableService adoptableService;
    @Autowired
    private EspeceService especeService;
    @Autowired
    private AntecedentService antecedentService;
    
    //retourne les animaux
    @GetMapping("/animaux")
    public String getAnimaux(Model model){
        
        List<Espece> especeList = especeService.getEspeces();
        model.addAttribute("especes", especeList);
        
        List<Animal> animalList = animalService.getAnimaux();
        model.addAttribute("animaux", animalList);
        
        return "animal";
    }
    
    @PostMapping("/animaux/addNew")
    public String addNew(Animal animal){
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
