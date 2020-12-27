/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author PC
 */
@Entity
public class SecretaireMedical extends Employe implements Serializable{
    
    /**
-- -----------------------------------------------------------------------------
-- - Association                                                             ---
-- -----------------------------------------------------------------------------
    */ 
    @OneToMany(mappedBy="secretaireMedical", fetch=FetchType.LAZY)
    private Set<Commande> commandes;
    
    @OneToMany(mappedBy="secretaireMedical", fetch=FetchType.LAZY)
    private Set<Consultation> consultations;
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                           ---
-- -
*/

    public SecretaireMedical(Set<Commande> commandes, Set<Consultation> consultations, Long idEmploye, String login, String mdp, String nom, String prenom, String adress, int telephone) {
        super(idEmploye, login, mdp, nom, prenom, adress, telephone);
        this.commandes = commandes;
        this.consultations = consultations;
    }

    public SecretaireMedical(Set<Commande> commandes, Set<Consultation> consultations) {
        this.commandes = commandes;
        this.consultations = consultations;
    }

    public Set<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }

    public Set<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(Set<Consultation> consultations) {
        this.consultations = consultations;
    }


    
  
}
