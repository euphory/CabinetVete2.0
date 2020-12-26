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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author PC
 */
@Entity
public class Medicament implements Serializable{
    @Id
    @GeneratedValue
    private Long idMedicament;
    @Column(length=70)
    private String nom;
    @Column(length=70)
    private String dosageMedic;
    @Column(length=140)
    private String usageMedic;
    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/
    
    @OneToMany(mappedBy="medicament")
    private Set<Posologie> posologies;
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------  
*/
  

    
}