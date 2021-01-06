/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author PC
 */
@Embeddable
public class PosologieId implements Serializable{
    private Long prescriptionId;
    private Long medicamentId;           

    public PosologieId() {
    }

    public PosologieId(Long prescriptionId, Long medicamentId) {
        super();
        this.prescriptionId = prescriptionId;
        this.medicamentId = medicamentId;
    }

    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Long getMedicamentId() {
        return medicamentId;
    }

    public void setMedicamentId(Long medicamentId) {
        this.medicamentId = medicamentId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.prescriptionId);
        hash = 59 * hash + Objects.hashCode(this.medicamentId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PosologieId other = (PosologieId) obj;
        if (!Objects.equals(this.prescriptionId, other.prescriptionId)) {
            return false;
        }
        if (!Objects.equals(this.medicamentId, other.medicamentId)) {
            return false;
        }
        return true;
    }
    



}
