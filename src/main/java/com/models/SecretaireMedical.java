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
public abstract class SecretaireMedical extends Employe {
    
    
    /**
-- -----------------------------------------------------------------------------
-- - Association                                                             ---
-- -----------------------------------------------------------------------------
    */ 
    @OneToMany(mappedBy="secretaireMedical", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Commande> commandes;
    
    @OneToMany(mappedBy="secretaireMedical", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Consultation> consultations;
    

    
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                           ---
-- -----------------------------------------------------------------------------
*/

    public SecretaireMedical(List<Commande> commandes, List<Consultation> consultations, Long id, String login, String mdp, String nom, String prenom, String adress, String telephone) {
        super(id, login, mdp, nom, prenom, adress, telephone);
        this.commandes = commandes;
        this.consultations = consultations;
    }

    public SecretaireMedical() {
    }

    public SecretaireMedical(List<Commande> commandes, List<Consultation> consultations) {
        this.commandes = commandes;
        this.consultations = consultations;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

}