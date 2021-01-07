/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    private Date dateReglement;
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
    public Facture(Long idFacture, Date date, String modeReglement, Date dateReglement, double total, double totalTTC, Commande commande) {
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
    public Date getDateReglement() {
        return dateReglement;
    }
    @DateTimeFormat(pattern="dd-mm-yyyy")
    public void setDateReglement(Date dateReglement) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idFacture);
        hash = 97 * hash + Objects.hashCode(this.date);
        hash = 97 * hash + Objects.hashCode(this.modeReglement);
        hash = 97 * hash + Objects.hashCode(this.dateReglement);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.total) ^ (Double.doubleToLongBits(this.total) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.totalTTC) ^ (Double.doubleToLongBits(this.totalTTC) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.commande);
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
        final Facture other = (Facture) obj;
        if (Double.doubleToLongBits(this.total) != Double.doubleToLongBits(other.total)) {
            return false;
        }
        if (Double.doubleToLongBits(this.totalTTC) != Double.doubleToLongBits(other.totalTTC)) {
            return false;
        }
        if (!Objects.equals(this.modeReglement, other.modeReglement)) {
            return false;
        }
        if (!Objects.equals(this.idFacture, other.idFacture)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.dateReglement, other.dateReglement)) {
            return false;
        }
        if (!Objects.equals(this.commande, other.commande)) {
            return false;
        }
        return true;
    }

    
  
}
