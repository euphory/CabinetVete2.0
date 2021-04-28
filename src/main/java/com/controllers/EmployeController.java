/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.Employe;
import com.models.SecretaireMedical;
import com.models.Veterinaire;
import com.services.EmployeService;
import com.services.FormulaireService;
import com.services.SecretaireMedicalService;
import com.services.VeterinaireService;
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
public class EmployeController {
    
    @Autowired
    private EmployeService employeService;
    @Autowired
    private VeterinaireService veterinaireService;
    @Autowired
    private SecretaireMedicalService secretaireMedicalService;
    
    //retourne les employes
    @GetMapping("/employes")
    public String getEmployes(Model model){
        
        
        List<Employe> employeList = employeService.getEmployes( );   
        List<Veterinaire> veterinaireList = veterinaireService.getVeterinaires();
        List<SecretaireMedical> SecretaireMedicalList = secretaireMedicalService.getSecretaireMedicals();

        
        model.addAttribute("employes", employeList);
        return "employe";
    }
    
    @PostMapping("/employes/addNew")
    public String addNew(SecretaireMedical secretaire){
        employeService.save(secretaire);    
        return "redirect:/employes";
    }
    
    @RequestMapping("employes/findById")
    @ResponseBody
    public Optional<Employe> findById(Long id){
        return employeService.findById(id);
    }
    @RequestMapping(value="/employes/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employe employe){
        employeService.save(employe);
        return "redirect:/employes";
    }
    
    @RequestMapping(value="/employes/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id){
    employeService.delete(id);
    return "redirect:/employes";
    }
}