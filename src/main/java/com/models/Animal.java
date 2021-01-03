/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author PC
 */
@Entity
public class Animal implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idAnimal;
    @Column(length=70)
    private String surnom;
    private double poid;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date dateNaissance;
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------   
 */
    @ManyToMany(mappedBy = "animaux")
    private Set<Consultation> consultations;
   
    @ManyToOne
    @JoinColumn(name="idEspece")
    private Espece espece;
    
    @ManyToOne
    @JoinColumn(name="idPersonne")
    private Personne personne;
        
    @OneToOne(mappedBy="animal")  
     private Adoptable adoptable ;
        
    @OneToMany(mappedBy="animal", fetch=FetchType.LAZY)
    private Set<Formulaire> formulaires; 
    
    @OneToMany(mappedBy="animal", fetch=FetchType.LAZY)
    private Set<Prestation> prestations;
    
    @OneToMany(mappedBy="animal", fetch=FetchType.LAZY,cascade={CascadeType.REMOVE})
    private Set<Antecedent> antecedents;
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    public Animal(Long idAnimal, String surnom, double poid, Date dateNaissance, Set<Consultation> consultations, Espece espece, Personne personne, Adoptable adoptable, Set<Formulaire> formulaires, Set<Prestation> prestations, Set<Antecedent> antecedents) {
        this.idAnimal = idAnimal;
        this.surnom = surnom;
        this.poid = poid;
        this.dateNaissance = dateNaissance;
        this.consultations = consultations;
        this.espece = espece;
        this.personne = personne;
        this.adoptable = adoptable;
        this.formulaires = formulaires;
        this.prestations = prestations;
        this.antecedents = antecedents;
    }
    public Animal(){
        
    }

    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getSurnom() {
        return surnom;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    public double getPoid() {
        return poid;
    }

    public void setPoid(double poid) {
        this.poid = poid;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Set<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(Set<Consultation> consultations) {
        this.consultations = consultations;
    }

    public Espece getEspece() {
        return espece;
    }

    public void setEspece(Espece espece) {
        this.espece = espece;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Adoptable getAdoptable() {
        return adoptable;
    }

    public void setAdoptable(Adoptable adoptable) {
        this.adoptable = adoptable;
    }

    public Set<Formulaire> getFormulaires() {
        return formulaires;
    }

    public void setFormulaires(Set<Formulaire> formulaires) {
        this.formulaires = formulaires;
    }

    public Set<Prestation> getPrestations() {
        return prestations;
    }

    public void setPrestations(Set<Prestation> prestations) {
        this.prestations = prestations;
    }

    public Set<Antecedent> getAntecedents() {
        return antecedents;
    }

    public void setAntecedents(Set<Antecedent> antecedents) {
        this.antecedents = antecedents;
    }
    


 

}