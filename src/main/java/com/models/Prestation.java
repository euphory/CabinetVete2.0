/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "Prestation")
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
    
    @ManyToOne
    @JoinColumn( name="idAnimal", nullable=false)
    private Animal animal;
    
    @ManyToOne
    @JoinColumn( name="idConsultation", nullable=false)
    private Consultation consultation;
    
    @ManyToMany
    @JoinTable( name = "T_ArticleMedicalFournisseur_Prestation",
            joinColumns = @JoinColumn( name = "idPrestation" ),
            inverseJoinColumns = @JoinColumn( name = "idArticleMedical" ) )
    private List<ArticleMedical> articleMedicals = new ArrayList<>();
    
    @ManyToMany
    @JoinTable( name = "T_ArticleMedicalFournisseur_Prestation",
            joinColumns = @JoinColumn( name = "idPrestation" ),
            inverseJoinColumns = @JoinColumn( name = "idFournisseur" ) )
    private List<Fournisseur> fournisseurs = new ArrayList<>();
   
    @OneToMany( targetEntity=Prescription.class, mappedBy="idPrescription" )
    private List<Prescription> prescriptions = new ArrayList<>();
 
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
}