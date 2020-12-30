/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author PC
 */
@Entity
public class Prestation{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
  
    @OneToMany(mappedBy="prestation")
    private Set<PrixVet> prixVet;
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    public Prestation(long idPrestation, int quantiteUtilise, Set<FournisseurArticlePrestation> FAP, Animal animal, Consultation consultation, Set<Prescription> prescriptions, Set<PrixVet> prixVet) {
        this.idPrestation = idPrestation;
        this.quantiteUtilise = quantiteUtilise;
        this.FAP = FAP;
        this.animal = animal;
        this.consultation = consultation;
        this.prescriptions = prescriptions;
        this.prixVet = prixVet;
    }

    public Prestation() {
    }

    public long getIdPrestation() {
        return idPrestation;
    }

    public void setIdPrestation(long idPrestation) {
        this.idPrestation = idPrestation;
    }

    public int getQuantiteUtilise() {
        return quantiteUtilise;
    }

    public void setQuantiteUtilise(int quantiteUtilise) {
        this.quantiteUtilise = quantiteUtilise;
    }

    public Set<FournisseurArticlePrestation> getFAP() {
        return FAP;
    }

    public void setFAP(Set<FournisseurArticlePrestation> FAP) {
        this.FAP = FAP;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public Set<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(Set<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public Set<PrixVet> getPrixVet() {
        return prixVet;
    }

    public void setPrixVet(Set<PrixVet> prixVet) {
        this.prixVet = prixVet;
    }
    
 

}