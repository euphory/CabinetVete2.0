/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author PC
 */
@Entity
@DiscriminatorValue("1")
public class Veterinaire extends Employe{
    
    @Column(name = "numVet")
    private Long numVet; 
    
/**
-- -----------------------------------------------------------------------------
-- - Association                                                          ---
-- -----------------------------------------------------------------------------
*/   
    @OneToMany(mappedBy="veterinaire", fetch=FetchType.LAZY)
    private List<Formulaire> formulaires = new ArrayList<>();
    
    @OneToMany(mappedBy="employe", fetch=FetchType.LAZY)
    private List<Commande> commandes = new ArrayList<>(); 
    
    @OneToMany(mappedBy="employe", fetch=FetchType.LAZY)
    private List<Consultation> consultation = new ArrayList<>(); 

/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    public Veterinaire(Long numVet) {
        this.numVet = numVet;
    }

    public Veterinaire() {
    }

    public Long getNumVet() {
        return numVet;
    }

    public void setNumVet(Long numVet) {
        this.numVet = numVet;
    }

    public List<Formulaire> getFormulaires() {
        return formulaires;
    }

    public void setFormulaires(List<Formulaire> formulaires) {
        this.formulaires = formulaires;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public List<Consultation> getConsultation() {
        return consultation;
    }

    public void setConsultation(List<Consultation> consultation) {
        this.consultation = consultation;
    }
 
    
}
