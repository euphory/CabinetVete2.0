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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author PC
 */
@Entity
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
  
}
