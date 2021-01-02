package com.services;


import com.models.Personne;
import com.repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneService {

    @Autowired
    private PersonneRepository personneRepository;
    //retourne une liste d'animaux
    public List<Personne> getPersonne(){
        return personneRepository.findAll();
    }



}
