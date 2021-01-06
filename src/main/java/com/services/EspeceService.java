/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.models.Espece;
import com.repositories.EspeceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class EspeceService {
        @Autowired
    private EspeceRepository adoptionRepository;
    //retourne une liste d'Especes
    public List<Espece> getEspeces(){
        return adoptionRepository.findAll();
    }
    
    public void save(Espece adoption){
        adoptionRepository.save(adoption);
    }
    
    //Get by Id
    public Optional<Espece> findById(Long id){
        return adoptionRepository.findById(id);
    }
    
    public void delete(Long id){
        adoptionRepository.deleteById(id);
    }
}
