/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author PC
 */
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Formulaire implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
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
    private User personne;

    @OneToOne
    @JoinColumn( name="idAdoption", nullable=true)
    private Adoption adoption;
  
    @ManyToOne
    @JoinColumn(name="idAnimal")
    private Animal animal;
    
    @ManyToOne
    @JoinColumn(name="idEmployeVeterinaire")
    private Employe veterinaire;
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/

    public Formulaire(Long id, Date dateFormulaire, String raison, User personne, Adoption adoption, Animal animal, Employe veterinaire) {
        this.id = id;
        this.dateFormulaire = dateFormulaire;
        this.raison = raison;
        this.personne = personne;
        this.adoption = adoption;
        this.animal = animal;
        this.veterinaire = veterinaire;
    }

    public Formulaire() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @DateTimeFormat(pattern="dd-mm-yyyy")
    public Date getDateFormulaire() {
        return dateFormulaire;
    }
    @DateTimeFormat(pattern="yyyy-mm-dd")
    public void setDateFormulaire(Date dateFormulaire) {
        this.dateFormulaire = dateFormulaire;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public User getPersonne() {
        return personne;
    }

    public void setPersonne(User personne) {
        this.personne = personne;
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

    public Employe getVeterinaire() {
        return veterinaire;
    }

    public void setVeterinaire(Employe veterinaire) {
        this.veterinaire = veterinaire;
    }
 
    


    
}
