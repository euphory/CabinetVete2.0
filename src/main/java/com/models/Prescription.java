/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
public class Prescription implements Serializable{
    @Id
    @GeneratedValue
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
    private List<Posologie> posologies = new ArrayList<>();
/**
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable( name = "Posologie",
        joinColumns = @JoinColumn( name = "idPrescription" ),
        inverseJoinColumns = @JoinColumn( name = "idPosologie" ) )
    private List<Posologie> posologies = new ArrayList<>();
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
 */
    public Prescription() {
    }

    public Prescription(Prestation prestation) {
        this.prestation = prestation;
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

    public List<Posologie> getPosologies() {
        return posologies;
    }

    public void setPosologies(List<Posologie> posologies) {
        this.posologies = posologies;
    }


    

    
}
