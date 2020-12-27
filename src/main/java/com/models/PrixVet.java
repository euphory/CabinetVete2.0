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
public class PrixVet implements Serializable{
    
    @Id
    @GeneratedValue
    private Long idPosologie; 
    private double prixDuService;
    
    
        
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/  
    @ManyToMany(fetch=FetchType.LAZY)
    private Set<Service> services;

    @ManyToOne
    @JoinColumn(name="idPrestation")
    private Prestation prestation;
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    public PrixVet(Long idPosologie, double prixDuService, Set<Service> services, Prestation prestation) {
        this.idPosologie = idPosologie;
        this.prixDuService = prixDuService;
        this.services = services;
        this.prestation = prestation;
    }

    public PrixVet() {
    }

    public Long getIdPosologie() {
        return idPosologie;
    }

    public void setIdPosologie(Long idPosologie) {
        this.idPosologie = idPosologie;
    }

    public double getPrixDuService() {
        return prixDuService;
    }

    public void setPrixDuService(double prixDuService) {
        this.prixDuService = prixDuService;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    public Prestation getPrestation() {
        return prestation;
    }

    public void setPrestation(Prestation prestation) {
        this.prestation = prestation;
    }

}
