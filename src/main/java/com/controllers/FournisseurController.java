/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.Fournisseur;
import com.services.FournisseurService;
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
public class FournisseurController {
    
    @Autowired
    private FournisseurService fournisseurService;

    //retourne les fournisseurs
    @GetMapping("/fournisseurs")
    public String getFournisseurs(Model model){
        
        List<Fournisseur> fournisseurList = fournisseurService.getFournisseurs();
        model.addAttribute("fournisseurs", fournisseurList);
        return "fournisseur";
    }
    
    @PostMapping("/fournisseurs/addNew")
    public String addNew(Fournisseur fournisseur){
        fournisseurService.save(fournisseur);
        return "redirect:/fournisseurs";
    }
    
    @RequestMapping("fournisseurs/findById")
    @ResponseBody
    public Optional<Fournisseur> findById(Long id){
        return fournisseurService.findById(id);
    }
    @RequestMapping(value="/fournisseurs/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Fournisseur fournisseur){
    fournisseurService.save(fournisseur);
    return "redirect:/fournisseurs";
    }
    
    @RequestMapping(value="/fournisseurs/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id){
    fournisseurService.delete(id);
    return "redirect:/fournisseurs";
    }
}
