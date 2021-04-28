/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers.AdoptionsController;

import com.models.Animal;
import com.services.AnimalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author PC
 */
@Controller
public class AdoptionContoller {
    @Autowired
    private AnimalService animalService;
    

    
    @GetMapping("/adoption")
    public String adoptionController(Model model){
        List<Animal> animalList = animalService.getAnimaux();
        model.addAttribute("animaux", animalList);
        
    return "adoption";
}
    
}
