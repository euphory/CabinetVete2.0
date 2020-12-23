/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author PC
 */
@Entity
public class Formulaire implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFormulaire;
    private Date dateFormulaire;
    @Column(length=140)
    private String raison;
    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/ 
    @ManyToOne
    @JoinColumn(name="idPersonne")
    private Personne personne;

    @OneToOne
    @JoinColumn( name="idAdoption", nullable=false)
    private Adoption adoption;
  
    @ManyToOne
    @JoinColumn(name="idAnimal")
    private Animal animal;
 
    @ManyToOne
    @JoinColumn(name="idEmploye", nullable=true)
    private Veterinaire veterinaire;
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/

    public Formulaire( Date dateFormulaire, String raison) {
        this.dateFormulaire = dateFormulaire;
        this.raison = raison;
    }

    public Formulaire() {
    }

    public Formulaire(Date dateFormulaire, String raison, Personne personne, Animal animal) {
        this.dateFormulaire = dateFormulaire;
        this.raison = raison;
        this.personne = personne;
        this.animal = animal;
    }
   
    public Adoption getAdoption() {
        return adoption;
    }

    public void setAdoption(Adoption adoption) {
        this.adoption = adoption;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    

    public Long getIdFormulaire() {
        return idFormulaire;
    }

    public void setIdFormulaire(Long idFormulaire) {
        this.idFormulaire = idFormulaire;
    }

    public Date getDateFormulaire() {
        return dateFormulaire;
    }

    public void setDateFormulaire(Date dateFormulaire) {
        this.dateFormulaire = dateFormulaire;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
    
}
