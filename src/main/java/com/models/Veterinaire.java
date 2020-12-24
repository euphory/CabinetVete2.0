/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.util.ArrayList;
import java.util.Set;
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
public class Veterinaire extends Employe{
    
    @Column(name = "numVet")
    private Long numVet; 
    
/**
-- -----------------------------------------------------------------------------
-- - Association                                                          ---
-- -----------------------------------------------------------------------------
*/   

    
    @OneToMany(mappedBy="employe", fetch=FetchType.LAZY)
    private Set<Commande> commandes ; 
    
    @OneToMany(mappedBy="employe", fetch=FetchType.LAZY)
    private Set<Consultation> consultation ; 

/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
 
    
}
