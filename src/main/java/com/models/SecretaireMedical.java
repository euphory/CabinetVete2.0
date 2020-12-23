/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author PC
 */
@Entity
@DiscriminatorValue("2")
public class SecretaireMedical extends Employe{
    
    /**
-- -----------------------------------------------------------------------------
-- - Association                                                             ---
-- -----------------------------------------------------------------------------
    */ 
    @OneToMany(mappedBy="employe", fetch=FetchType.LAZY)
    private List<Consultation> consultations = new ArrayList<>();
 
    @OneToMany(mappedBy="employe", fetch=FetchType.LAZY)
    private List<Commande> commandes = new ArrayList<>();
  
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                           ---
-- -
*/
    public SecretaireMedical() {
    }
/**
    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
    
   */

    
}
