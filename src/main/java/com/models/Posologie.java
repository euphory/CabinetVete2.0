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

/**
 *
 * @author PC
 */
@Entity
public class Posologie implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
    private Set<Prescription> prescriptions;

    @ManyToOne
    @JoinColumn(name="idMedicament")
    private Medicament medicament;

/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    public Posologie(Long idPosologie, String dosage, String usa, Set<Prescription> prescriptions, Medicament medicament) {
        this.idPosologie = idPosologie;
        this.dosage = dosage;
        this.usa = usa;
        this.prescriptions = prescriptions;
        this.medicament = medicament;
    }

    public Posologie() {
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

    public String getUsa() {
        return usa;
    }

    public void setUsa(String usa) {
        this.usa = usa;
    }

    public Set<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(Set<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }
    

}

