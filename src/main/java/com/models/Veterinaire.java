/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.models.security.Authority;
import com.models.security.UserRole;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author PC
 */
@Entity
public abstract class Veterinaire extends Employe {
    
    private Long numVet; 
    
    
/**
-- -----------------------------------------------------------------------------
-- - Association                                                          ---
-- -----------------------------------------------------------------------------
*/  

    
    @OneToMany(mappedBy="veterinaire", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Commande> commandesVet; 
    
    @OneToMany(mappedBy="veterinaire", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Consultation> consultations;
    
    @OneToMany(mappedBy="veterinaire", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Formulaire> formulaire; 
 
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
 */
    public Veterinaire(Long numVet, List<Commande> commandesVet, List<Consultation> consultations, List<Formulaire> formulaire, Long idEmploye, String login, String mdp, String nom, String prenom, String adress, String telephone) {
        super(idEmploye, login, mdp, nom, prenom, adress, telephone);
        this.numVet = numVet;
        this.commandesVet = commandesVet;
        this.consultations = consultations;
        this.formulaire = formulaire;
    }

    public Veterinaire(Long numVet, List<Commande> commandesVet, List<Consultation> consultations, List<Formulaire> formulaire) {
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

    public List<Commande> getCommandesVet() {
        return commandesVet;
    }

    public void setCommandesVet(List<Commande> commandesVet) {
        this.commandesVet = commandesVet;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    public List<Formulaire> getFormulaire() {
        return formulaire;
    }

    public void setFormulaire(List<Formulaire> formulaire) {
        this.formulaire = formulaire;
    }


}
