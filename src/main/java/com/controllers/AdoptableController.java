/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.Adoptable;
import com.models.Animal;
import com.services.AdoptableService;
import com.services.AnimalService;
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
public class AdoptableController {
    
    @Autowired
    private AdoptableService adoptableService;
    @Autowired
    private AnimalService animalService;
    
    
    //retourne les adoptables
    @GetMapping("/adoptables")
    public String getAdoptables(Model model){
        
        List<Animal> animalList = animalService.getAnimaux();
        model.addAttribute("animals", animalList);
        
        List<Adoptable> adoptableList = adoptableService.getAdoptables();
        model.addAttribute("adoptables", adoptableList);
        return "adoptable";
    }
    
    @PostMapping("/adoptables/addNew")
    public String addNew(Adoptable adoptable){       
        adoptableService.save(adoptable);
        return "redirect:/adoptables";
    }
    
    @RequestMapping("adoptables/findById")
    @ResponseBody
    public Optional<Adoptable> findById(Long id){
        return adoptableService.findById(id);
    }
    @RequestMapping(value="/adoptables/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Adoptable adoptable){
    adoptableService.save(adoptable);
    return "redirect:/adoptables";
    }
    
    @RequestMapping(value="/adoptables/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id){
    adoptableService.delete(id);
    return "redirect:/adoptables";
    }
    
    
}
