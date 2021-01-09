/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.models.Consultation;
import com.repositories.ConsultationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class ConsultationService {

        @Autowired
    private ConsultationRepository consultationRepository;
    //retourne une liste d'Consultations
    public List<Consultation> getConsultations(){
        return consultationRepository.findAll();
    }
    
    public void save(Consultation consultation){
        consultationRepository.save(consultation);
    }
    
    //Get by Id
    public Optional<Consultation> findById(Long id){
        return consultationRepository.findById(id);
    }
    
    public void delete(Long id){
        consultationRepository.deleteById(id);
    }



}