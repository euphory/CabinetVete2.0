/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.Antecedent;
import com.models.Formulaire;
import com.services.AntecedentService;
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
public class AntecedentsController {
    
    @Autowired
    private AntecedentService antecedentService;
    
    //retourne les antecedents
    @GetMapping("/antecedents")
    public String getAntecedents(Model model){
          
    List<Antecedent> antecedentList = antecedentService.getAntecedents();
    model.addAttribute("antecedents", antecedentList);
    
    return "antecedent";
    }
    
    @PostMapping("/antecedents/addNew")
    public String addNew(Antecedent antecedent){
        antecedentService.save(antecedent);
        return "redirect:/antecedents";
    }
    
    @RequestMapping("antecedents/findById")
    @ResponseBody
    public Optional<Antecedent> findById(Long id){
        return antecedentService.findById(id);
    }
    @RequestMapping(value="/antecedents/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Antecedent antecedent){
    antecedentService.save(antecedent);
    return "redirect:/antecedents";
    }
    
    @RequestMapping(value="/antecedents/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id){
    antecedentService.delete(id);
    return "redirect:/antecedents";
    }
    
}
