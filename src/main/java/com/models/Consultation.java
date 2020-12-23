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
    

/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    public Consultation(Calendar date, Date heureDebut, Date heureFin, String Motif, double tarifGroupe) {
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.Motif = Motif;
        this.tarifGroupe = tarifGroupe;
    }

    public Consultation() {
    }

    public Long getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(Long idConsultation) {
        this.idConsultation = idConsultation;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Date getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Date getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Date heureFin) {
        this.heureFin = heureFin;
    }

    public String getMotif() {
        return Motif;
    }

    public void setMotif(String Motif) {
        this.Motif = Motif;
    }

    public double getTarifGroupe() {
        return tarifGroupe;
    }

    public void setTarifGroupe(double tarifGroupe) {
        this.tarifGroupe = tarifGroupe;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public FactureConsult getFactureConsult() {
        return factureConsult;
    }

    public void setFactureConsult(FactureConsult factureConsult) {
        this.factureConsult = factureConsult;
    }

    public List<Animal> getAnimaux() {
        return animaux;
    }

    public void setAnimaux(List<Animal> animaux) {
        this.animaux = animaux;
    }

    
    
}