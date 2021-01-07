/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.HashSet;
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
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Prestation{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long prestationId;
    private int quantiteUtilise;
    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/
    @OneToMany(mappedBy="articleMedical")
    private Set<FAP> fap = new HashSet<>();
 
    @ManyToOne
    @JoinColumn( name="idAnimal", nullable=false)
    private Animal animal;
    
    @ManyToOne
    @JoinColumn( name="idConsultation", nullable=false)
    private Consultation consultation;
    
    @OneToMany(mappedBy="prestation", fetch=FetchType.LAZY)
    private Set<Prescription> prescriptions;   

    @OneToMany(mappedBy = "service")
    private Set<PrixVet> prixVet= new HashSet<>();
/**
    -- -----------------------------------------------------------------------------
    -- - Constructor                                                             ---
    -- -----------------------------------------------------------------------------
     */    


    public long getPrestationId() {
        return prestationId;
    }

    public void setPrestationId(long prestationId) {
        this.prestationId = prestationId;
    }

    public Set<FAP> getFap() {
        return fap;
    }

    public void setFap(Set<FAP> fap) {
        this.fap = fap;
    }

    public Set<Prescription> getPrescriptions() {
        return prescriptions;
    }


    public void setPrescriptions(Set<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public Prestation(long prestationId, int quantiteUtilise, Animal animal, Consultation consultation, Set<Prescription> prescriptions) {
        this.prestationId = prestationId;
        this.quantiteUtilise = quantiteUtilise;
        this.animal = animal;
        this.consultation = consultation;
        this.prescriptions = prescriptions;
    }

    public Prestation() {
    }

    public int getQuantiteUtilise() {
        return quantiteUtilise;
    }

    public void setQuantiteUtilise(int quantiteUtilise) {
        this.quantiteUtilise = quantiteUtilise;
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

 

    public Set<PrixVet> getPrixVet() {
        return prixVet;
    }

    public void setPrixVet(Set<PrixVet> prixVet) {
        this.prixVet = prixVet;
    }
    
 

}