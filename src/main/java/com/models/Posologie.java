/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
/**
 *
 * @author PC
 */
@Entity
public class Posologie {
    
    @EmbeddedId
    private PosologieId id = new PosologieId();
    private String dosage;
    private String usa;

/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
   */

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "prescriptionId",insertable = false, updatable = false, nullable = true)
    private Prescription prescription;

    @ManyToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name="medicamentId", insertable = false, updatable = false)
    private Medicament medicament;

/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/


    public Posologie() {
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
    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

}

