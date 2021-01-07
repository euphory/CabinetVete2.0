/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.models.Facture;
import com.repositories.FactureRepository;
import com.repositories.FactureRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class FactureService {
    
    @Autowired
    private FactureRepository factureRepository;
    //retourne une liste d'Factures
    public List<Facture> getFactures(){
        return factureRepository.findAll();
    }
    
    public void save(Facture facture){
        factureRepository.save(facture);
    }
    
    //Get by Id
    public Optional<Facture> findById(Long id){
        return factureRepository.findById(id);
    }
    
    public void delete(Long id){
        factureRepository.deleteById(id);
    }
    
}
