/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author PC
 */
@Entity
public class Veterinaire extends Employe implements Serializable{
    
    private Long numVet; 
    
/**
-- -----------------------------------------------------------------------------
-- - Association                                                          ---
-- -----------------------------------------------------------------------------
*/   

    
    @OneToMany(mappedBy="veterinaire", fetch=FetchType.LAZY)
    private Set<Commande> commandesVet; 
    
    @OneToMany(mappedBy="veterinaire", fetch=FetchType.LAZY)
    private Set<Consultation> consultations;
    
    @OneToMany(mappedBy="veterinaire", fetch=FetchType.LAZY)
    private Set<Formulaire> formulaire; 
 
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
 */
    public Veterinaire(Long numVet, Set<Commande> commandesVet, Set<Consultation> consultations, Set<Formulaire> formulaire, Long idEmploye, String login, String mdp, String nom, String prenom, String adress, String telephone) {
        super(idEmploye, login, mdp, nom, prenom, adress, telephone);
        this.numVet = numVet;
        this.commandesVet = commandesVet;
        this.consultations = consultations;
        this.formulaire = formulaire;
    }

    public Veterinaire(Long numVet, Set<Commande> commandesVet, Set<Consultation> consultations, Set<Formulaire> formulaire) {
        this.numVet = numVet;
        this.commandesVet = commandesVet;
        this.consultations = consultations;
        this.formulaire = formulaire;
    }

    public Veterinaire() {
    }

    public Long getNumVet() {
        return numVet;
    }

    public void setNumVet(Long numVet) {
        this.numVet = numVet;
    }

    public Set<Commande> getCommandesVet() {
        return commandesVet;
    }

    public void setCommandesVet(Set<Commande> commandesVet) {
        this.commandesVet = commandesVet;
    }

    public Set<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(Set<Consultation> consultations) {
        this.consultations = consultations;
    }

    public Set<Formulaire> getFormulaire() {
        return formulaire;
    }

    public void setFormulaire(Set<Formulaire> formulaire) {
        this.formulaire = formulaire;
    }

 
    
}
