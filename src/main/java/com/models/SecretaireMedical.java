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
  
}
