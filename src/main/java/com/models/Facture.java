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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author PC
 */
@Entity
public class Facture implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
    @OneToOne(mappedBy ="facture")
    private Commande commande ;
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/  
    public Facture(Long idFacture, Date date, String modeReglement, Calendar dateReglement, double total, double totalTTC, Commande commande) {
        this.idFacture = idFacture;
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
    @DateTimeFormat(pattern="yyyy-mm-dd")
    public Date getDate() {
        return date;
    }
    @DateTimeFormat(pattern="yyyy-mm-dd")
    public void setDate(Date date) {
        this.date = date;
    }

    public String getModeReglement() {
        return modeReglement;
    }

    public void setModeReglement(String modeReglement) {
        this.modeReglement = modeReglement;
    }
    @DateTimeFormat(pattern="yyyy-mm-dd")
    public Calendar getDateReglement() {
        return dateReglement;
    }
    @DateTimeFormat(pattern="yyyy-mm-dd")
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
