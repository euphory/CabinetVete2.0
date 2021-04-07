/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.models.Medicament;
import com.repositories.MedicamentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class MedicamentService {
    @Autowired
    private MedicamentRepository medicamentRepository;
    //retourne une liste d'ArticleMedicaux
    public List<Medicament> getMedicaments(){
        return medicamentRepository.findAll();
    }
    
    public void save(Medicament medicament){
        medicamentRepository.save(medicament);
    }
    
    //Get by Id
    public Optional<Medicament> findById(Long id){
        return medicamentRepository.findById(id);
    }
    
    public void delete(Long id){
        medicamentRepository.deleteById(id);
    }
}

