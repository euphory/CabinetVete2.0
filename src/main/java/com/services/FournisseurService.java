/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.models.Fournisseur;
import com.repositories.FournisseurRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class FournisseurService {
    
    @Autowired
    private FournisseurRepository fournisseurRepository;
    //retourne une liste d'Fournisseurs
    public List<Fournisseur> getFournisseurs(){
        return fournisseurRepository.findAll();
    }
    
    public void save(Fournisseur fournisseur){
        fournisseurRepository.save(fournisseur);
    }
    
    //Get by Id
    public Optional<Fournisseur> findById(Long id){
        return fournisseurRepository.findById(id);
    }
    
    public void delete(Long id){
        fournisseurRepository.deleteById(id);
    }
    
}
