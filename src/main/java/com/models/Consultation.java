/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author PC
 */
@Entity
public class Consultation implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idConsultation;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Temporal(TemporalType.TIME)
    private Date heureDebut;
    @Temporal(TemporalType.TIME)
    private Date heureFin;
    @Column(length=70)
    private String motif;
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
    @JoinColumn( name="factureConsult")
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
    
    public Consultation(Long idConsultation, Date date, Date heureDebut, Date heureFin, String Motif, double tarifGroupe, Employe veterinaire, Employe secretaireMedical, FactureConsult factureConsult, Set<Animal> animaux, Personne personne) {
        this.idConsultation = idConsultation;
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.motif = Motif;
        this.tarifGroupe = tarifGroupe;
        this.veterinaire = veterinaire;
        this.secretaireMedical = secretaireMedical;
        this.factureConsult = factureConsult;
        this.animaux = animaux;
        this.personne = personne;
    }

    public Consultation() {
    }

    public Long getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(Long idConsultation) {
        this.idConsultation = idConsultation;
    }
    @DateTimeFormat(pattern="yyyy-MM-dd")
    public Date getDate() {
        return date;
    }
    @DateTimeFormat(pattern="yyyy-MM-dd")
    public void setDate(Date date) {
        this.date = date;
    }
    @DateTimeFormat(pattern="hh:mm a")
    public Date getHeureDebut() {
        return heureDebut;
    }
    @DateTimeFormat(pattern="hh:mm a")
    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }
    @DateTimeFormat(pattern="hh:mm a")
    public Date getHeureFin() {
        return heureFin;
    }
    @DateTimeFormat(pattern="hh:mm a")
    public void setHeureFin(Date heureFin) {
        this.heureFin = heureFin;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String Motif) {
        this.motif = Motif;
    }

    public double getTarifGroupe() {
        return tarifGroupe;
    }

    public void setTarifGroupe(double tarifGroupe) {
        this.tarifGroupe = tarifGroupe;
    }

    public Employe getVeterinaire() {
        return veterinaire;
    }

    public void setVeterinaire(Employe veterinaire) {
        this.veterinaire = veterinaire;
    }

    public Employe getSecretaireMedical() {
        return secretaireMedical;
    }

    public void setSecretaireMedical(Employe secretaireMedical) {
        this.secretaireMedical = secretaireMedical;
    }

    public FactureConsult getFactureConsult() {
        return factureConsult;
    }

    public void setFactureConsult(FactureConsult factureConsult) {
        this.factureConsult = factureConsult;
    }

    public Set<Animal> getAnimaux() {
        return animaux;
    }

    public void setAnimaux(Set<Animal> animaux) {
        this.animaux = animaux;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }


    
}