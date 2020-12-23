/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Table
public class PrixVet {
        @Column(name="prixDuService")
        private double prixDuService;

    public PrixVet(double prixDuService) {
        this.prixDuService = prixDuService;
    }

    public double getPrixDuService() {
        return prixDuService;
    }

    public void setPrixDuService(double prixDuService) {
        this.prixDuService = prixDuService;
    }
        
        
}
