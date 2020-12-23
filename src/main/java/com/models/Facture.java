/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author PC
 */
@Entity
public class Facture implements Serializable{
    @Id
    @GeneratedValue
    private Long idFacture;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String modeReglement;
    @Temporal(TemporalType.DATE)
    private Calendar dateReglement;
    private double total;
    private double totalTTC;
    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/
    @OneToOne
    @JoinColumn( name="commande", nullable=true )
    private Commande commande ;
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/  
    public Facture(Date date, String modeReglement, Calendar dateReglement, double total, double totalTTC) {
        this.date = date;
        this.modeReglement = modeReglement;
        this.dateReglement = dateReglement;
        this.total = total;
        this.totalTTC = totalTTC;
    }

    public Facture(Date date, String modeReglement, Calendar dateReglement, double total, double totalTTC, Commande commande) {
        this.date = date;
        this.modeReglement = modeReglement;
        this.dateReglement = dateReglement;
        this.total = total;
        this.totalTTC = totalTTC;
        this.commande = commande;
    }


    public Facture() {
    }

    public Long getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Long idFacture) {
        this.idFacture = idFacture;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getModeReglement() {
        return modeReglement;
    }

    public void setModeReglement(String modeReglement) {
        this.modeReglement = modeReglement;
    }

    public Calendar getDateReglement() {
        return dateReglement;
    }

    public void setDateReglement(Calendar dateReglement) {
        this.dateReglement = dateReglement;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalTTC() {
        return totalTTC;
    }

    public void setTotalTTC(double totalTTC) {
        this.totalTTC = totalTTC;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }


    
}
