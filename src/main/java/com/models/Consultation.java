/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    @JoinColumn(name="idEmployeVeterinaire")
    private Employe veterinaire;
    
    @ManyToOne
    @JoinColumn(name="idEmployeSecretaireMedical")
    private Employe secretaireMedical;
        
    @OneToOne
    @JoinColumn( name="factureConsult", nullable=false )
    private FactureConsult factureConsult;
        
    @ManyToMany(fetch=FetchType.LAZY)
    private Set<Animal> animaux;
    
    @ManyToOne
    @JoinColumn(name="idPersonne")
    private Personne personne;

/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    
}