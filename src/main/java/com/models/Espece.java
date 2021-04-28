/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author PC
 */
@Entity
public class Espece implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=70)
    private String nom;
    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
 */  
    @OneToMany( mappedBy = "espece", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Set<Animal> animaux ;
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    public Espece(Long id, String nom, Set<Animal> animaux) {
        this.id = id;
        this.nom = nom;
        this.animaux = animaux;
    }

    public Espece() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Animal> getAnimaux() {
        return animaux;
    }

    public void setAnimaux(Set<Animal> animaux) {
        this.animaux = animaux;
    }
    
    
    

    
}
