/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.models.FactureConsult;
import com.repositories.FactureConsultRepository;
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
public class FactureConsultService {
    
  @Autowired
    private FactureConsultRepository factureConsultRepository;
    //retourne une liste d'Factures
    public List<FactureConsult> getFactureConsults(){
        return factureConsultRepository.findAll();
    }
    
    public void save(FactureConsult factureConsult){
        factureConsultRepository.save(factureConsult);
    }
    
    //Get by Id
    public Optional<FactureConsult> findById(Long id){
        return factureConsultRepository.findById(id);
    }
    
    public void delete(Long id){
        factureConsultRepository.deleteById(id);
    }
}
