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
    
    @Column(name = "numVet")
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
 
    
}
