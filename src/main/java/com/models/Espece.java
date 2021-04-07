/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

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
    private Long idEspece;
    @Column(length=70)
    private String nom;
    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
 */  
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Animal> animaux ;
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    public Espece(Long idEspece, String nom, Set<Animal> animaux) {
        this.idEspece = idEspece;
        this.nom = nom;
        this.animaux = animaux;
    }

    public Espece() {
    }

    public Long getIdEspece() {
        return idEspece;
    }

    public void setIdEspece(Long idEspece) {
        this.idEspece = idEspece;
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
