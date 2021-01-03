/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.models.Adoption;
import com.repositories.AdoptionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class AdoptionService {
    
    @Autowired
    private AdoptionRepository adoptionRepository;
    //retourne une liste d'Adoptions
    public List<Adoption> getAdoptions(){
        return adoptionRepository.findAll();
    }
    
        public void save(Adoption adoption){
        adoptionRepository.save(adoption);
    }
    
    //Get by Id
    public Optional<Adoption> findById(int id){
        return adoptionRepository.findById(id);
    }
    
    public void delete(Integer id){
        adoptionRepository.deleteById(id);
    }
    
}
