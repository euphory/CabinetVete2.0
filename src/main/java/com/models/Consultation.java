/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Date;
import java.util.List;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    @JoinColumn(name="employeVeterinaire_id")
    private Employe veterinaire;
    
    @ManyToOne
    @JoinColumn(name="employeSecretaireMedical_id")
    private Employe secretaireMedical;
        
    @OneToOne
    private FactureConsult factureConsult;
        
    @ManyToMany(fetch=FetchType.LAZY)
    private List<Animal> animaux;
    
    @ManyToOne
    @JoinColumn(name="personne_id")
    private User personne;

/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    
    public Consultation(Long id, Date date, Date heureDebut, Date heureFin, String Motif, double tarifGroupe, Employe veterinaire, Employe secretaireMedical, FactureConsult factureConsult, List<Animal> animaux, User personne) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Animal> getAnimaux() {
        return animaux;
    }

    public void setAnimaux(List<Animal> animaux) {
        this.animaux = animaux;
    }

    public User getPersonne() {
        return personne;
    }

    public void setPersonne(User personne) {
        this.personne = personne;
    }


    
}