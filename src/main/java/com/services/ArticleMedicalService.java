/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.models.ArticleMedical;
import com.repositories.ArticleMedicalRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class ArticleMedicalService {
        @Autowired
    private ArticleMedicalRepository articleMedicalRepository;
    //retourne une liste d'ArticleMedicaux
    public List<ArticleMedical> getArticleMedicaux(){
        return articleMedicalRepository.findAll();
    }
    
    public void save(ArticleMedical articleMedical){
        articleMedicalRepository.save(articleMedical);
    }
    
    //Get by Id
    public Optional<ArticleMedical> findById(Long id){
        return articleMedicalRepository.findById(id);
    }
    
    public void delete(Long id){
        articleMedicalRepository.deleteById(id);
    }
}

