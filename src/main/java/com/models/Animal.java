/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author PC
 */
@Entity
public class Animal implements Serializable{
    @Id
    @GeneratedValue
    private Long idAnimal;
    @Column(length=70)
    private String surnom;
    private double poid;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------   
 */
    @ManyToMany(mappedBy = "animaux")
    private List<Consultation> consultations = new ArrayList<>();
   
    @ManyToOne
    @JoinColumn(name="idEspece")
    private Espece espece;
    
    @ManyToOne
    @JoinColumn(name="idPersonne")
    private Personne personne;
        
    @OneToOne(mappedBy="animal")  
     private Adoptable adoptable ;
        
    @OneToMany(mappedBy="animal", fetch=FetchType.LAZY)
    private List<Formulaire> formulaires = new ArrayList<>(); 
    
    @OneToMany(mappedBy="animal", fetch=FetchType.LAZY)
    private List<Prestation> prestations = new ArrayList<>();
    
    @OneToMany(mappedBy="animal", fetch=FetchType.LAZY,cascade={CascadeType.REMOVE})
    private List<Antecedent> antecedents = new ArrayList<>();

/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    
    public Animal(Long idAnimal, String surnom, double poid, Date dateNaissance){
        this.idAnimal = idAnimal;
        this.surnom = surnom;
        this.poid = poid;
        this.dateNaissance = dateNaissance;
}

    public Animal() {
    }

    public Animal(String surnom, double poid, Date dateNaissance, Personne personne, Adoptable adoptable, List<Formulaire> formulaires) {
        this.surnom = surnom;
        this.poid = poid;
        this.dateNaissance = dateNaissance;
        this.personne = personne;
        this.adoptable = adoptable;
        this.formulaires = formulaires;
    }

    public Animal(String surnom, double poid, Date dateNaissance, Personne personne, List<Prestation> prestations, List<Antecedent> antecedents) {
        this.surnom = surnom;
        this.poid = poid;
        this.dateNaissance = dateNaissance;
        this.personne = personne;
        this.prestations = prestations;
        this.antecedents = antecedents;
    }

    public List<Prestation> getPrestations() {
        return prestations;
    }

    public void setPrestations(List<Prestation> prestations) {
        this.prestations = prestations;
    }

    public List<Antecedent> getAntcedents() {
        return antecedents;
    }

    public void setAntcedents(List<Antecedent> antcedents) {
        this.antecedents = antcedents;
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

    public Collection<Formulaire> getFormulaires() {
        return formulaires;
    }

    public void setFormulaires(List<Formulaire> formulaires) {
        this.formulaires = formulaires;
    }
    
    


}