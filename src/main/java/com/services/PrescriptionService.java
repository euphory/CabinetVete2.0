/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.models.Prescription;
import com.repositories.PrescriptionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class PrescriptionService {
    
    @Autowired
    private PrescriptionRepository prescriptionRepository;
    
    //retourne une liste d'Prescriptions
    public List<Prescription> getPrescriptions(){
        return prescriptionRepository.findAll();
    }
    
    public void save(Prescription prescription){
        prescriptionRepository.save(prescription);
    }
    
    //Get by Id
    public Optional<Prescription> findById(Long id){
        return prescriptionRepository.findById(id);
    }
    
    public void delete(Long id){
        prescriptionRepository.deleteById(id);
    }
}
