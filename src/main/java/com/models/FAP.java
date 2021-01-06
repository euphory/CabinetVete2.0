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
public class FAP {

    @EmbeddedId
    private FAPId id = new FAPId();
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fournisseurId",insertable = false, updatable = false)
    private Fournisseur fournisseur;

    @ManyToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name="articleMedicalId", insertable = false, updatable = false)
    private ArticleMedical articleMedical;    
    
    @ManyToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name="prestationId", insertable = false, updatable = false)
    private Prestation prestation;


    public FAP() {
    }

    public FAP(Fournisseur fournisseur, ArticleMedical articleMedical, Prestation prestation) {
        this.fournisseur = fournisseur;
        this.articleMedical = articleMedical;
        this.prestation = prestation;
    }

    public FAPId getId() {
        return id;
    }

    public void setId(FAPId id) {
        this.id = id;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public ArticleMedical getArticleMedical() {
        return articleMedical;
    }

    public void setArticleMedical(ArticleMedical articleMedical) {
        this.articleMedical = articleMedical;
    }

    public Prestation getPrestation() {
        return prestation;
    }

    public void setPrestation(Prestation prestation) {
        this.prestation = prestation;
    }

 
}
