/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.models.SecretaireMedical;
import com.repositories.SecretaireMedicalRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class SecretaireMedicalService {
    
    @Autowired
    private SecretaireMedicalRepository secretaireMedicalRepository;
    //retourne une liste d'SecretaireMedicals
    public List<SecretaireMedical> getSecretaireMedicals(){
        return secretaireMedicalRepository.findAll();
    }
    
    public void save(SecretaireMedical secretaireMedical){
        secretaireMedicalRepository.save(secretaireMedical);
    }
    
    //Get by Id
    public Optional<SecretaireMedical> findById(Long id){
        return secretaireMedicalRepository.findById(id);
    }
    
    public void delete(Long id){
        secretaireMedicalRepository.deleteById(id);
    }
    
}
