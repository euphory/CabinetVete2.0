/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.models.Commande;
import com.repositories.CommandeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class CommandeService {
    
    @Autowired
    private CommandeRepository commandeRepository;
    //retourne une liste d'Commandes
    public List<Commande> getCommandes(){
        return commandeRepository.findAll();
    }
    
    public void save(Commande commande){
        commandeRepository.save(commande);
    }
    
    //Get by Id
    public Optional<Commande> findById(Long id){
        return commandeRepository.findById(id);
    }
    
    public void delete(Long id){
        commandeRepository.deleteById(id);
    }
    
}
