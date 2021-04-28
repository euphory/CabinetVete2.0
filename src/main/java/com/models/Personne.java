/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author PC
 */
@Entity
public class Personne implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=70)
    private String nom;
    @Column(length=70)
    private String prenom;
    
    private String login;
    
    private String mdp;
    @Column(length=140)
    private String adresse;
    @Column(length=70)
    private String adresseMail;
    @Column(length=70)
    private String numAssurance;
    @Column(length=70)
    private String telephone;
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
 */    
    @OneToMany(mappedBy="personne", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Formulaire> formulaires;
  
    @OneToMany(mappedBy="personne", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Animal> animaux;
    
    @OneToMany(mappedBy="personne", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Consultation> consultations;
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    public Personne() {
    }

    public Personne(Long id, String nom, String prenom, String adresse, String adresseMail, String numAssurance, String telephone, List<Formulaire> formulaires, List<Animal> animaux, List<Consultation> consultations) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.adresseMail = adresseMail;
        this.numAssurance = numAssurance;
        this.telephone = telephone;
        this.formulaires = formulaires;
        this.animaux = animaux;
        this.consultations = consultations;
    }



    public Long getIdPersonne() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public String getNumAssurance() {
        return numAssurance;
    }

    public String getTelephone() {
        return telephone;
    }

    public List<Formulaire> getFormulaires() {
        return formulaires;
    }

    public List<Animal> getAnimaux() {
        return animaux;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public void setNumAssurance(String numAssurance) {
        this.numAssurance = numAssurance;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setFormulaires(List<Formulaire> formulaires) {
        this.formulaires = formulaires;
    }

    public void setAnimaux(List<Animal> animaux) {
        this.animaux = animaux;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }
    

  
}
