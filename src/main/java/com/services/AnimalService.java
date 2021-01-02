package com.services;


import com.models.Animal;
import com.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;
    //retourne une liste d'animaux
    public List<Animal> getAnimal(){
        return animalRepository.findAll();
    }



}
