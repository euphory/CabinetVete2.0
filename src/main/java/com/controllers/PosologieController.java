/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.Posologie;
import com.models.Medicament;
import com.models.Prescription;
import com.services.PosologieService;
import com.services.MedicamentService;
import com.services.MedicamentService;
import com.services.PrescriptionService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author PC
 */
@Controller
public class PosologieController {
    
    @Autowired
    private PosologieService posologieService;
    @Autowired
    private MedicamentService medicamentService;
    @Autowired
    private PrescriptionService prescriptionService;
        
    //retourne les posologies
    @GetMapping("/posologies")
    public String getPosologies(Model model){
        
        List<Medicament> medicamentList = medicamentService.getMedicaments();
        model.addAttribute("medicaments", medicamentList);
        
        List<Posologie> posologieList = posologieService.getPosologies();
        model.addAttribute("posologies", posologieList);
        
        List<Prescription> prescriptionList = prescriptionService.getPrescriptions();
        model.addAttribute("prescriptions", prescriptionList);
        
        
        return "posologie";
    }
    
    @PostMapping("/posologies/addNew")
    public String addNew(Posologie posologie,
                        @RequestParam Long presciptionId,
                        @RequestParam Long medicamentId){
        posologieService.save(posologie);
        return "redirect:/posologies";
    }
    
    @RequestMapping("posologies/findById")
    @ResponseBody
    public Optional<Posologie> findById(Long id){
        return posologieService.findById(id);
    }
    @RequestMapping(value="/posologies/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Posologie posologie){
    posologieService.save(posologie);
    return "redirect:/posologies";
    }
    
    @RequestMapping(value="/posologies/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id){
    posologieService.delete(id);
    return "redirect:/posologies";
    }
    
}
