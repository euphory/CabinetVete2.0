/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author PC
 */
@Entity
public class Animal implements Serializable{
    @Id
    @GeneratedValue
    private Long idAnimal;
    @Column(length=70)
    private String surnom;
    private double poid;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------   
 */
    @ManyToMany(mappedBy = "animaux")
    private Set<Consultation> consultations;
   
    @ManyToOne
    @JoinColumn(name="idEspece")
    private Espece espece;
    
    @ManyToOne
    @JoinColumn(name="idPersonne")
    private Personne personne;
        
    @OneToOne(mappedBy="animal")  
     private Adoptable adoptable ;
        
    @OneToMany(mappedBy="animal", fetch=FetchType.LAZY)
    private Set<Formulaire> formulaires; 
    
    @OneToMany(mappedBy="animal", fetch=FetchType.LAZY)
    private Set<Prestation> prestations;
    
    @OneToMany(mappedBy="animal", fetch=FetchType.LAZY,cascade={CascadeType.REMOVE})
    private Set<Antecedent> antecedents;

/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
 

}