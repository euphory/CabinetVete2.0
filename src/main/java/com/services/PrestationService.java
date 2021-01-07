/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.models.Prestation;
import com.repositories.PrestationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class PrestationService {
        @Autowired
    private PrestationRepository prestationRepository;
    //retourne une liste d'Prestations
    public List<Prestation> getPrestations(){
        return prestationRepository.findAll();
    }
    
    public void save(Prestation prestation){
        prestationRepository.save(prestation);
    }
    
    //Get by Id
    public Optional<Prestation> findById(Long id){
        return prestationRepository.findById(id);
    }
    
    public void delete(Long id){
        prestationRepository.deleteById(id);
    }
}
