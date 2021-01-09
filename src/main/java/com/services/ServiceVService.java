/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.models.ServiceV;
import com.repositories.ServiceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class ServiceVService {
    
    @Autowired
    private ServiceRepository serviceRepository;
    //retourne une liste d'Soutiens
    public List<ServiceV> getServiceVs(){
        return serviceRepository.findAll();
    }
    
    public void save(ServiceV service){
        serviceRepository.save(service);
    }
    
    //Get by Id
    public Optional<ServiceV> findById(Long id){
        return serviceRepository.findById(id);
    }
    
    public void delete(Long id){
        serviceRepository.deleteById(id);
    }
    
}
