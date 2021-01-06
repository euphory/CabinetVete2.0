/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.models.Formulaire;
import com.repositories.FormulaireRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class FormulaireService {
    
    @Autowired
    private FormulaireRepository formulaireRepository;
    //retourne une liste d'Formulaires
    public List<Formulaire> getFormulaires(){
        return formulaireRepository.findAll();
    }
    
    public void save(Formulaire formulaire){
        formulaireRepository.save(formulaire);
    }
    
    //Get by Id
    public Optional<Formulaire> findById(Long id){
        return formulaireRepository.findById(id);
    }
    
    public void delete(Long id){
        formulaireRepository.deleteById(id);
    }
    
}
