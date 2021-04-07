/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.models.Posologie;
import com.repositories.PosologieRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class posologie {
    
    @Autowired
    private PosologieRepository posologieRepository;
    //retourne une liste d'Posologies
    public List<Posologie> getPosologies(){
        return posologieRepository.findAll();
    }
    
    public void save(Posologie posologie){
        posologieRepository.save(posologie);
    }
    
    //Get by Id
    public Optional<Posologie> findById(Long id){
        return posologieRepository.findById(id);
    }
    
    public void delete(Long id){
        posologieRepository.deleteById(id);
    }
    
}
