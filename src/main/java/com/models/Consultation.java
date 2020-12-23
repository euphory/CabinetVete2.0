/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
public class Consultation implements Serializable{
    @Id
    @GeneratedValue
    private Long idConsultation;
    @Temporal(TemporalType.DATE)
    private Calendar date;
    @Temporal(TemporalType.TIMESTAMP)
    private Date heureDebut;
    @Temporal(TemporalType.TIMESTAMP)
    private Date heureFin;
    @Column(length=70)
    private String Motif;
    private double tarifGroupe;
    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/
    @ManyToOne
    @JoinColumn(name="idEmploye")
    private Employe employe;
        
    @OneToOne
    @JoinColumn( name="factureConsult", nullable=false )
    private FactureConsult factureConsult;
        
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable( name = "T_Consultation",
        joinColumns = @JoinColumn( name = "idConsultation" ),
        inverseJoinColumns = @JoinColumn( name = "idAnimal" ) )
    private List<Animal> animaux = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name="idPersonne")
    private Personne personne;

/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    
}