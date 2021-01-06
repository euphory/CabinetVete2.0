package com.services;


import com.models.Personne;
import com.repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonneService {

    @Autowired
    private PersonneRepository personneRepository;
    //retourne une liste d'Personnes
    public List<Personne> getPersonnes(){
        return personneRepository.findAll();
    }
    
    public void save(Personne personne){
        personneRepository.save(personne);
    }
    
    //Get by Id
    public Optional<Personne> findById(Long id){
        return personneRepository.findById(id);
    }
    
    public void delete(Long id){
        personneRepository.deleteById(id);
    }
    

}
