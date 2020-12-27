/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
    @GeneratedValue
    private Long idPersonne;
    @Column(length=70)
    private String nom;
    @Column(length=70)
    private String prenom;
    @Column(length=140)
    private String adress;
    private int numAssurence;
    @Column(length=70)
    private String adressMail;
    private int telephone;
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
 */    
    @OneToMany(mappedBy="personne", fetch=FetchType.LAZY)
    private Set<Formulaire> formulaires;
  
    @OneToMany(mappedBy="personne", fetch=FetchType.LAZY)
    private Set<Animal> animaux;
    
    @OneToMany(mappedBy="personne", fetch = FetchType.LAZY)
    private Set<Consultation> consultations;
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/

    public Personne(Long idPersonne, String nom, String prenom, String adress, int numAssurence, String adressMail, int telephone, Set<Formulaire> formulaires, Set<Animal> animaux, Set<Consultation> consultations) {
        this.idPersonne = idPersonne;
        this.nom = nom;
        this.prenom = prenom;
        this.adress = adress;
        this.numAssurence = numAssurence;
        this.adressMail = adressMail;
        this.telephone = telephone;
        this.formulaires = formulaires;
        this.animaux = animaux;
        this.consultations = consultations;
    }

    public Personne() {
    }

    public Long getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Long idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getNumAssurence() {
        return numAssurence;
    }

    public void setNumAssurence(int numAssurence) {
        this.numAssurence = numAssurence;
    }

    public String getAdressMail() {
        return adressMail;
    }

    public void setAdressMail(String adressMail) {
        this.adressMail = adressMail;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public Set<Formulaire> getFormulaires() {
        return formulaires;
    }

    public void setFormulaires(Set<Formulaire> formulaires) {
        this.formulaires = formulaires;
    }

    public Set<Animal> getAnimaux() {
        return animaux;
    }

    public void setAnimaux(Set<Animal> animaux) {
        this.animaux = animaux;
    }

    public Set<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(Set<Consultation> consultations) {
        this.consultations = consultations;
    }


}
