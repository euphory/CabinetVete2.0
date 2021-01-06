/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.models.Antecedent;
import com.repositories.AntecedentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class AntecedentService {
        @Autowired
    private AntecedentRepository adoptionRepository;
    //retourne une liste d'Antecedents
    public List<Antecedent> getAntecedents(){
        return adoptionRepository.findAll();
    }
    
    public void save(Antecedent adoption){
        adoptionRepository.save(adoption);
    }
    
    //Get by Id
    public Optional<Antecedent> findById(Long id){
        return adoptionRepository.findById(id);
    }
    
    public void delete(Long id){
        adoptionRepository.deleteById(id);
    }
}

