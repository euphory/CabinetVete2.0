/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.Facture;
import com.models.Formulaire;
import com.services.FactureService;
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
public class FactureController {
    
    @Autowired
    private FactureService factureService;
    @Autowired
    private FormulaireService formulaireService;
    
    //retourne les factures
    @GetMapping("/factures")
    public String getFactures(Model model){
        
        List<Facture> factureList = factureService.getFactures();
        model.addAttribute("factures", factureList);
        return "facture";
    }
    
    @PostMapping("/factures/addNew")
    public String addNew(Facture facture){
        factureService.save(facture);
        return "redirect:/factures";
    }
    
    @RequestMapping("factures/findById")
    @ResponseBody
    public Optional<Facture> findById(Long id){
        return factureService.findById(id);
    }
    @RequestMapping(value="/factures/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Facture facture){
    factureService.save(facture);
    return "redirect:/factures";
    }
    
    @RequestMapping(value="/factures/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id){
    factureService.delete(id);
    return "redirect:/factures";
    }
    
}

    

