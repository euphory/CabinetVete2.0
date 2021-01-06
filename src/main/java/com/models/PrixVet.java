/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author PC
 */
@Entity
public class PrixVet{
    
    @EmbeddedId
    private PrixVetId priVetId = new PrixVetId();
    private double prixDuService;
    
    
        
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/  
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ServiceId",insertable = false, updatable = false, nullable = true)
    private Service service;

    @ManyToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name="prestationId", insertable = false, updatable = false)
    private Prestation prestation;

/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
 
    public PrixVet() {
    }

    public PrixVet(double prixDuService, Service service, Prestation prestation) {
        this.prixDuService = prixDuService;
        this.service = service;
        this.prestation = prestation;
    }

    public PrixVetId getPriVetId() {
        return priVetId;
    }

    public void setPriVetId(PrixVetId priVetId) {
        this.priVetId = priVetId;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }





    public double getPrixDuService() {
        return prixDuService;
    }

    public void setPrixDuService(double prixDuService) {
        this.prixDuService = prixDuService;
    }


    public Prestation getPrestation() {
        return prestation;
    }

    public void setPrestation(Prestation prestation) {
        this.prestation = prestation;
    }

}
