/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 *
 * @author PC
 */
@Entity
public class FournisseurArticlePrestation implements Serializable{

    @EmbeddedId
    private Long idFAP;
    
    @ManyToOne
    @MapsId("idFournisseur")
    @JoinColumn(name = "idFournisseur")
    Fournisseur fournisseur;

    @ManyToOne
    @MapsId("idArticleMedical")
    @JoinColumn(name = "idArticleMedical")
    ArticleMedical articleMedical;
    
    @ManyToOne
    @MapsId("idPrestation")
    @JoinColumn(name = "idPrestation")
    Prestation prestation;

    public FournisseurArticlePrestation(Long idFAP, Fournisseur fournisseur, ArticleMedical articleMedical, Prestation prestation) {
        this.idFAP = idFAP;
        this.fournisseur = fournisseur;
        this.articleMedical = articleMedical;
        this.prestation = prestation;
    }

    public FournisseurArticlePrestation() {
    }

    
    public Long getIdFAP() {
        return idFAP;
    }

    public void setIdFAP(Long idFAP) {
        this.idFAP = idFAP;
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
