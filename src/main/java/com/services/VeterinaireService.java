/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.models.Veterinaire;
import com.repositories.VeterinaireRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class VeterinaireService {
    
    @Autowired
    private VeterinaireRepository veterinaireRepository;
    //retourne une liste d'Veterinaires
    public List<Veterinaire> getVeterinaires(){
        return veterinaireRepository.findAll();
    }
    
    public void save(Veterinaire veterinaire){
        veterinaireRepository.save(veterinaire);
    }
    
    //Get by Id
    public Optional<Veterinaire> findById(Long id){
        return veterinaireRepository.findById(id);
    }
    
    public void delete(Long id){
        veterinaireRepository.deleteById(id);
    }
    
}
