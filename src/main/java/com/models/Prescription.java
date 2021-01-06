/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
public class Prescription implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------

*/ 
    @OneToMany(mappedBy = "medicament")
    private Set<Posologie> posologies= new HashSet<>();
    
    @ManyToOne
    @JoinColumn( name="idPrestation", nullable=true)
    private Prestation prestation;

    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/


    public Prescription(Long id, Prestation prestation) {
        this.id = id;

    }

    public Prescription() {
    }

    public Long getId() {
        return id;
    }

    public void setIdPrescription(Long id) {
        this.id = id;
    }

    public Set<Posologie> getPosologies() {
        return posologies;
    }

    public void setPosologies(Set<Posologie> posologies) {
        this.posologies = posologies;
    }

    public Prestation getPrestation() {
        return prestation;
    }

    public void setPrestation(Prestation prestation) {
        this.prestation = prestation;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
