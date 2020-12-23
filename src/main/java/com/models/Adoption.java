/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "Adoption")
public class Adoption implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAdoption")
    private Long idAdoption;
    @Temporal(TemporalType.DATE)
    private Date dateAdoption;
    private double frais;
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/    
    @OneToOne( cascade = CascadeType.ALL ) 
    @JoinColumn( name="idFormulaire" )
    private Formulaire formulaire;
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/


    public Adoption(Date dateAdoption, double frais) {
        this.dateAdoption = dateAdoption;
        this.frais = frais;
    }

    public Adoption(Date dateAdoption, double frais, Formulaire formulaire) {
        this.dateAdoption = dateAdoption;
        this.frais = frais;
        this.formulaire = formulaire;
    }

    public Adoption() {
    }
    
    
    public Long getIdAdoption() {
        return idAdoption;
    }

    public void setIdAdoption(Long idAdoption) {
        this.idAdoption = idAdoption;
    }

    public Date getDateAdoption() {
        return dateAdoption;
    }

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
