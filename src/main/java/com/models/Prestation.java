/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author PC
 */
@Entity
public class Prestation{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPrestation")
    private long idPrestation;
    private int quantiteUtilise;
    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/
    @OneToMany(mappedBy = "prestation")
    Set<FournisseurArticlePrestation> FAP;
    
    @ManyToOne
    @JoinColumn( name="idAnimal", nullable=false)
    private Animal animal;
    
    @ManyToOne
    @JoinColumn( name="idConsultation", nullable=false)
    private Consultation consultation;
    
   
    @OneToMany(mappedBy="idPrescription", fetch=FetchType.LAZY)
    private Set<Prescription> prescriptions;   
/**    
    @OneToMany(mappedBy="Prestation")
    private Set<PrixVet> prixVet ;  
    
 
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
}