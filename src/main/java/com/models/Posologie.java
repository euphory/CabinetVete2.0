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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author PC
 */
@Entity
public class Posologie implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPosologie; 
    @Column(length=70)
    private String dosage;
    private String usa;

/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
   */
    @ManyToMany(fetch=FetchType.LAZY)
      @JoinTable( name = "Posologie",
        joinColumns = @JoinColumn( name = "idMedicament" ),
        inverseJoinColumns = @JoinColumn( name = "idPrescription" ) )
    private Set<Prescription> prescriptions;
    
    @ManyToOne
    @JoinColumn(name="idMedicament")
    private Medicament medicament;
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
 */
   
}

