/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.ServiceV;
import com.services.ServiceVService;
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
public class ServiceVController {
    
     @Autowired
    private ServiceVService serviceService;
    
    //retourne les services
    @GetMapping("/services")
    public String getServices(Model model){
        
        List<ServiceV> serviceList = serviceService.getServiceVs();
        model.addAttribute("services", serviceList);
        return "service";
    }
    
    @PostMapping("/services/addNew")
    public String addNew(ServiceV service){
        serviceService.save(service);
        return "redirect:/services";
    }
    
    @RequestMapping("services/findById")
    @ResponseBody
    public Optional<ServiceV> findById(Long id){
        return serviceService.findById(id);
    }
    @RequestMapping(value="/services/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(ServiceV serviceV){
    serviceService.save(serviceV);
    return "redirect:/services";
    }
    
    @RequestMapping(value="/services/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id){
    serviceService.delete(id);
    return "redirect:/services";
    }
    
}
