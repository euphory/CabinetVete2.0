/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Calendar;
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

/**
 *
 * @author PC
 */
@Entity
public class FactureConsult implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idFactureConsult;
    @Temporal(TemporalType.DATE)
    private Calendar date;
    private String modeReglement;
    @Temporal(TemporalType.DATE)
    private Calendar dateReglement;
    private double total;
    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/
    @OneToOne 
    @JoinColumn( name="idConsultation", nullable= true )
    private Consultation idConsultation;
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    public FactureConsult(Long idFactureConsult, Calendar date, String modeReglement, Calendar dateReglement, double total, Consultation idConsultation) {
        this.idFactureConsult = idFactureConsult;
        this.date = date;
        this.modeReglement = modeReglement;
        this.dateReglement = dateReglement;
        this.total = total;
        this.idConsultation = idConsultation;
    }

    public FactureConsult() {
    }

    public Long getIdFactureConsult() {
        return idFactureConsult;
    }

    public void setIdFactureConsult(Long idFactureConsult) {
        this.idFactureConsult = idFactureConsult;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
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

    public Consultation getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(Consultation idConsultation) {
        this.idConsultation = idConsultation;
    }
    

  
    
}