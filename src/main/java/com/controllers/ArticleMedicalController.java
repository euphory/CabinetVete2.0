/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.ArticleMedical;
import com.services.ArticleMedicalService;
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
public class ArticleMedicalController {
    
    @Autowired
    private ArticleMedicalService articleMedicalService;
    
    //retourne les articleMedicaux
    @GetMapping("/articleMedicaux")
    public String getArticleMedicaux(Model model){
          
    List<ArticleMedical> articleMedicalList = articleMedicalService.getArticleMedicaux();
    model.addAttribute("articleMedicaux", articleMedicalList);
    
    return "articleMedical";
    }
    
    @PostMapping("/articleMedicaux/addNew")
    public String addNew(ArticleMedical articleMedical){
        articleMedicalService.save(articleMedical);
        return "redirect:/articleMedicaux";
    }
    
    @RequestMapping("articleMedicaux/findById")
    @ResponseBody
    public Optional<ArticleMedical> findById(Long id){
        return articleMedicalService.findById(id);
    }
    @RequestMapping(value="/articleMedicaux/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(ArticleMedical articleMedical){
    articleMedicalService.save(articleMedical);
    return "redirect:/articleMedicaux";
    }
    
    @RequestMapping(value="/articleMedicaux/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id){
    articleMedicalService.delete(id);
    return "redirect:/articleMedicaux";
    }
    
}
