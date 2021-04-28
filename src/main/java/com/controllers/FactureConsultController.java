/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.FactureConsult;
import com.services.FactureConsultService;
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
public class FactureConsultController {
    
    @Autowired
    private FactureConsultService factureConsultService;

    //retourne les factures
    @GetMapping("/factureConsults")
    public String getFactureConsults(Model model){
        
        List<FactureConsult> factureConsultList = factureConsultService.getFactureConsults();
        model.addAttribute("factureConsults", factureConsultList);
        return "factureConsult";
    }
    
    @PostMapping("/factureConsults/addNew")
    public String addNew(FactureConsult factureConsult){
        factureConsultService.save(factureConsult);
        return "redirect:/factureConsults";
    }
    
    @RequestMapping("factureConsults/findById")
    @ResponseBody
    public Optional<FactureConsult> findById(Long id){
        return factureConsultService.findById(id);
    }
    @RequestMapping(value="/factureConsults/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(FactureConsult factureConsult){
    factureConsultService.save(factureConsult);
    return "redirect:/factureConsults";
    }
    
    @RequestMapping(value="/factureConsults/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id){
    factureConsultService.delete(id);
    return "redirect:/factureConsults";
    }
    
}
