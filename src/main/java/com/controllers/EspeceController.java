/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.Animal;
import com.models.Espece;
import com.services.AnimalService;
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
public class EspeceController {
    
    @Autowired
    private EspeceService especeService;

    //retourne les especes
    @GetMapping("/especes")
    public String getEspeces(Model model){
        
        List<Espece> especeList = especeService.getEspeces();
        model.addAttribute("especes", especeList);
        return "espece";
    }
    
    @PostMapping("/especes/addNew")
    public String addNew(Espece espece){
        especeService.save(espece);
        return "redirect:/especes";
    }
    
    @RequestMapping("especes/findById")
    @ResponseBody
    public Optional<Espece> findById(Long id){
        return especeService.findById(id);
    }
    @RequestMapping(value="/especes/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Espece espece){
    especeService.save(espece);
    return "redirect:/especes";
    }
    
    @RequestMapping(value="/especes/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id){
    especeService.delete(id);
    return "redirect:/especes";
    }
    
    
}
