/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.Consultation;
import com.services.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author PC
 */
@Controller
public class HomeController{
    @Autowired
    private ConsultationService consultationService;
    
    @GetMapping("/index")
    public String home() {
        return "index";
    }
    @RequestMapping("/myAccount")
    public String myAccount() {
    return "myAccount";
    }
    
    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("classActiveLogin", true);
        return "myAccount";
    }
     
    @PostMapping("/index/addNew")
    public String addNew(Consultation consultation){
        consultationService.save(consultation);                 
        return "redirect:/index";
    }
    
    
    

}
    