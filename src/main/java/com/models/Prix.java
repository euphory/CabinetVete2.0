/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author PC
 */
@Entity
public class Prix {
    
    @EmbeddedId
    private PrixId id = new PrixId();
    private double prixHT;
    private double prixTTC;    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "articleMedicalId",insertable = false, updatable = false, nullable = true)
    private ArticleMedical articleMedical;

    @ManyToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name="fournisseurId", insertable = false, updatable = false)
    private Fournisseur fournisseur;


    public PrixId getId() {
        return id;
    }

    public void setId(PrixId id) {
        this.id = id;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

/**
    -- -----------------------------------------------------------------------------
    -- - Constructor                                                             ---
    -- -----------------------------------------------------------------------------
     */
    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Prix() {
    }

    public Prix(double prixHT, double prixTTC, ArticleMedical articleMedical, Fournisseur fournisseur) {
        this.prixHT = prixHT;
        this.prixTTC = prixTTC;
        this.articleMedical = articleMedical;
        this.fournisseur = fournisseur;
    }

    public double getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(double prixHT) {
        this.prixHT = prixHT;
    }

    public double getPrixTTC() {
        return prixTTC;
    }

    public void setPrixTTC(double prixTTC) {
        this.prixTTC = prixTTC;
    }

    public ArticleMedical getArticleMedical() {
        return articleMedical;
    }

    public void setArticleMedical(ArticleMedical articleMedical) {
        this.articleMedical = articleMedical;
    }
    

}