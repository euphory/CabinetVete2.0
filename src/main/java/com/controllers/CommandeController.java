/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.Animal;
import com.models.Commande;
import com.services.AnimalService;
import com.services.CommandeService;
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
public class CommandeController {
    
    @Autowired
    private CommandeService commandeService;

    //retourne les commandes
    @GetMapping("/commandes")
    public String getCommandes(Model model){
        
        List<Commande> commandeList = commandeService.getCommandes();
        model.addAttribute("commandes", commandeList);
        return "commande";
    }
    
    @PostMapping("/commandes/addNew")
    public String addNew(Commande commande){
        commandeService.save(commande);
        return "redirect:/commandes";
    }
    
    @RequestMapping("commandes/findById")
    @ResponseBody
    public Optional<Commande> findById(Long id){
        return commandeService.findById(id);
    }
    @RequestMapping(value="/commandes/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Commande commande){
    commandeService.save(commande);
    return "redirect:/commandes";
    }
    
    @RequestMapping(value="/commandes/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id){
    commandeService.delete(id);
    return "redirect:/commandes";
    }
    
}
