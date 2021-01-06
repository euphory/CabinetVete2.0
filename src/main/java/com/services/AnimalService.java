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
    private AnimalRepository adoptionRepository;
    //retourne une liste d'Animaux
    public List<Animal> getAnimaux(){
        return adoptionRepository.findAll();
    }
    
    public void save(Animal adoption){
        adoptionRepository.save(adoption);
    }
    
    //Get by Id
    public Optional<Animal> findById(Long id){
        return adoptionRepository.findById(id);
    }
    
    public void delete(Long id){
        adoptionRepository.deleteById(id);
    }
}
