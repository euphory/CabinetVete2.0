/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
      @JoinTable( name = "T_Posologie",
        joinColumns = @JoinColumn( name = "idPosologie" ),
        inverseJoinColumns = @JoinColumn( name = "idPrescription" ) )
    private List<Prescription> prescriptions = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name="idMedicament")
    private Medicament medicament;
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
 */
    public Posologie(String dosage, String usa) {
        this.dosage = dosage;
        this.usa = usa;
    }

    public Posologie() {
    }

    public Posologie(String dosage, String usage, Medicament medicament) {
        this.dosage = dosage;
        this.usa = usage;
        this.medicament = medicament;
    }

    public Long getIdPosologie() {
        return idPosologie;
    }

    public void setIdPosologie(Long idPosologie) {
        this.idPosologie = idPosologie;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getUsage() {
        return usa;
    }

    public void setUsage(String usage) {
        this.usa = usage;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

}

