/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.Medicament;
import com.services.MedicamentService;
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
public class MedicamentController {
    @Autowired
    private MedicamentService medicamentService;
    
    //retourne les medicaments
    @GetMapping("/medicaments")
    public String getArticleMedicaux(Model model){
          
    List<Medicament> medicamentList = medicamentService.getArticleMedicaux();
    model.addAttribute("medicaments", medicamentList);
    
    return "medicament";
    }
    
    @PostMapping("/medicaments/addNew")
    public String addNew(Medicament medicament){
        medicamentService.save(medicament);
        return "redirect:/medicaments";
    }
    
    @RequestMapping("medicaments/findById")
    @ResponseBody
    public Optional<Medicament> findById(Long id){
        return medicamentService.findById(id);
    }
    @RequestMapping(value="/medicaments/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Medicament medicament){
    medicamentService.save(medicament);
    return "redirect:/medicaments";
    }
    
    @RequestMapping(value="/medicaments/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id){
    medicamentService.delete(id);
    return "redirect:/medicaments";
    }
    
    
}
