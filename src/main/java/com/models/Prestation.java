/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.List;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long prestationId;
    private int quantiteUtilise;
    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/
    @OneToMany(mappedBy="articleMedical")
    @JsonIgnore
    private List<FAP> fap ;
 
    @ManyToOne
    @JoinColumn( name="idAnimal", nullable=false)
    private Animal animal;
    
    @ManyToOne
    @JoinColumn( name="idConsultation", nullable=false)
    private Consultation consultation;
    
    @OneToMany(mappedBy="prestation", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Prescription> prescriptions;   

    @OneToMany(mappedBy = "service")
    @JsonIgnore
    private List<PrixVet> prixVet;
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

    public List<FAP> getFap() {
        return fap;
    }

    public void setFap(List<FAP> fap) {
        this.fap = fap;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }


    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public Prestation(long prestationId, int quantiteUtilise, Animal animal, Consultation consultation, List<Prescription> prescriptions) {
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

 

    public List<PrixVet> getPrixVet() {
        return prixVet;
    }

    public void setPrixVet(List<PrixVet> prixVet) {
        this.prixVet = prixVet;
    }
    
 

}