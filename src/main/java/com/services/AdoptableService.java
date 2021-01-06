/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.models.Adoptable;
import com.repositories.AdoptableRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class AdoptableService {
       @Autowired
    private AdoptableRepository adoptionRepository;
    //retourne une liste d'Adoptables
    public List<Adoptable> getAdoptables(){
        return adoptionRepository.findAll();
    }
    
    public void save(Adoptable adoption){
        adoptionRepository.save(adoption);
    }
    
    //Get by Id
    public Optional<Adoptable> findById(Long id){
        return adoptionRepository.findById(id);
    }
    
    public void delete(Long id){
        adoptionRepository.deleteById(id);
    }
} 

