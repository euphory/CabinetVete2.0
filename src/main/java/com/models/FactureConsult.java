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
    @GeneratedValue
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
  
    
}