/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.CascadeType;
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
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Adoption implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateAdoption;
    private double frais;
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/    
    @OneToOne( mappedBy = "adoption")
    private Formulaire formulaire;

/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/


    public Adoption(Long id, Date dateAdoption, double frais, Formulaire formulaire) {
        this.id = id;
        this.dateAdoption = dateAdoption;
        this.frais = frais;
        this.formulaire = formulaire;
    }

    public Adoption() {
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @DateTimeFormat(pattern="dd-mm-yyyy")
    public Date getDateAdoption() {
        return dateAdoption;
    }
    @DateTimeFormat(pattern="yyyy-mm-dd")
    public void setDateAdoption(Date dateAdoption) {
        this.dateAdoption = dateAdoption;
    }


    public double getFrais() {
        return frais;
    }

    public void setFrais(double frais) {
        this.frais = frais;
    }

    public Formulaire getFormulaire() {
        return formulaire;
    }

    public void setFormulaire(Formulaire formulaire) {
        this.formulaire = formulaire;
    }

    


}
