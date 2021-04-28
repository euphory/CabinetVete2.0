/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author PC
 */
@Entity
public class FactureConsult implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactureConsult;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String modeReglement;
    @Temporal(TemporalType.DATE)
    private Date dateReglement;
    private double total;
    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/
    @OneToOne 
    @JoinColumn( name="id", nullable= true )
    private Consultation id;
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/


    public FactureConsult() {
    }

    public FactureConsult(Long idFactureConsult, Date date, String modeReglement, Date dateReglement, double total, Consultation id) {
        this.idFactureConsult = idFactureConsult;
        this.date = date;
        this.modeReglement = modeReglement;
        this.dateReglement = dateReglement;
        this.total = total;
        this.id = id;
    }

    public Long getIdFactureConsult() {
        return idFactureConsult;
    }

    public void setIdFactureConsult(Long idFactureConsult) {
        this.idFactureConsult = idFactureConsult;
    }
    @DateTimeFormat(pattern="yyyy-mm-dd")
    public Date getDate() {
        return date;
    }
    @DateTimeFormat(pattern="dd-mm-yyyy")
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
    @DateTimeFormat(pattern="yyyy-mm-dd")
    public void setDateReglement(Date dateReglement) {
        this.dateReglement = dateReglement;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Consultation getIdConsultation() {
        return id;
    }

    public void setIdConsultation(Consultation id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.idFactureConsult);
        hash = 37 * hash + Objects.hashCode(this.date);
        hash = 37 * hash + Objects.hashCode(this.modeReglement);
        hash = 37 * hash + Objects.hashCode(this.dateReglement);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.total) ^ (Double.doubleToLongBits(this.total) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final FactureConsult other = (FactureConsult) obj;
        if (Double.doubleToLongBits(this.total) != Double.doubleToLongBits(other.total)) {
            return false;
        }
        if (!Objects.equals(this.modeReglement, other.modeReglement)) {
            return false;
        }
        if (!Objects.equals(this.idFactureConsult, other.idFactureConsult)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.dateReglement, other.dateReglement)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    

  
    
}