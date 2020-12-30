/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author PC
 */
@Entity
public class Prescription implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idPrescription;
    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------

*/ 
    @ManyToOne
    @JoinColumn(name="idPrestation")
    private Prestation prestation;
    
    @ManyToMany(mappedBy = "prescriptions")
    private Set<Posologie> posologies;
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    public Prescription(Long idPrescription, Prestation prestation, Set<Posologie> posologies) {
        this.idPrescription = idPrescription;
        this.prestation = prestation;
        this.posologies = posologies;
    }

    public Prescription() {
    }

    public Long getIdPrescription() {
        return idPrescription;
    }

    public void setIdPrescription(Long idPrescription) {
        this.idPrescription = idPrescription;
    }

    public Prestation getPrestation() {
        return prestation;
    }

    public void setPrestation(Prestation prestation) {
        this.prestation = prestation;
    }

    public Set<Posologie> getPosologies() {
        return posologies;
    }

    public void setPosologies(Set<Posologie> posologies) {
        this.posologies = posologies;
    }




    
}
