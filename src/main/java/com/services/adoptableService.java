/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.models.Consultation;
import com.repositories.ConsultationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class AdoptableService {

    @Autowired
    private ConsultationRepository consultationRepository;
    //retourne une liste d'animaux
    public List<Consultation> getConsultation(){
        return consultationRepository.findAll();
    }
    
    public void save(Consultation consultation){
        consultationRepository.save(consultation);
    }
    



}