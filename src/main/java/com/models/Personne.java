/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
    private List<Formulaire> formulaires;
  
    @OneToMany(mappedBy="personne", fetch=FetchType.LAZY)
    private List<Animal> animaux;
/**    
    @OneToMany( targetEntity=Consultation.class, mappedBy="idConsultation")
    private List<Consultation> consultations = new ArrayList<>();
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    public Personne(String nom, String prenom, String adress, int numAssurence, String adressMail, int telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.adress = adress;
        this.numAssurence = numAssurence;
        this.adressMail = adressMail;
        this.telephone = telephone;
    }

    public Personne() {
    }

    public Personne(String nom, String prenom, String adress, int numAssurence, String adressMail, int telephone, List<Formulaire> formulaires) {
        this.nom = nom;
        this.prenom = prenom;
        this.adress = adress;
        this.numAssurence = numAssurence;
        this.adressMail = adressMail;
        this.telephone = telephone;
        this.formulaires = formulaires;
    }

    public Personne(Long idPersonne, String nom, String prenom, String adress, int numAssurence, String adressMail, int telephone, List<Formulaire> formulaires, List<Animal> animaux) {
        this.idPersonne = idPersonne;
        this.nom = nom;
        this.prenom = prenom;
        this.adress = adress;
        this.numAssurence = numAssurence;
        this.adressMail = adressMail;
        this.telephone = telephone;
        this.formulaires = formulaires;
        this.animaux = animaux;
    }

    public List<Animal> getAnimaux() {
        return animaux;
    }

    public void setAnimaux(List<Animal> animaux) {
        this.animaux = animaux;
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

    public Collection<Formulaire> getFormulaires() {
        return formulaires;
    }

    public void setFormulaires(List<Formulaire> formulaires) {
        this.formulaires = formulaires;
    }



}
