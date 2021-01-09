/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.models.Employe;
import com.repositories.EmployeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class EmployeService {
    
    @Autowired
    private EmployeRepository employeRepository;
    //retourne une liste d'Employes
    public List<Employe> getEmployes(){
        return employeRepository.findAll();
    }
    
    public void save(Employe employe){
        employeRepository.save(employe);
    }
    
    //Get by Id
    public Optional<Employe> findById(Long id){
        return employeRepository.findById(id);
    }
    
    public void delete(Long id){
        employeRepository.deleteById(id);
    }
    
}
