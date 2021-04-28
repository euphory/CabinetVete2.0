package com.services;


import com.models.Animal;
import com.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;
    //retourne une liste d'Animaux
    public List<Animal> getAnimaux(){
        return animalRepository.findAll();
    }
    
    public void save(Animal animal){
        animalRepository.save(animal);
    }
 
    
    //Get by Id
    public Optional<Animal> findById(Long id){
        return animalRepository.findById(id);
    }
    
    public void delete(Long id){
        animalRepository.deleteById(id);
    }
}
