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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author PC
 */
@Entity
public class LigneCommande {

    @EmbeddedId
    private LigneCommandeId id = new LigneCommandeId();
    private int quantiteCommande;
    private double prixHTarticle;
    private double prixHTLigne;
    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/ 
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "commandeId",insertable = false, updatable = false, nullable = true)
    private Commande commande;

    @ManyToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name="articleMedicalId", insertable = false, updatable = false)
    private ArticleMedical articleMedical;
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
 

    public LigneCommande() {
    }

    public LigneCommande(int quantiteCommande, double prixHTarticle, double prixHTLigne, Commande commande, ArticleMedical articleMedical) {
        this.quantiteCommande = quantiteCommande;
        this.prixHTarticle = prixHTarticle;
        this.prixHTLigne = prixHTLigne;
        this.commande = commande;
        this.articleMedical = articleMedical;
    }

    public ArticleMedical getArticleMedical() {
        return articleMedical;
    }

    public void setArticleMedical(ArticleMedical articleMedical) {
        this.articleMedical = articleMedical;
    }

    public int getQuantiteCommande() {
        return quantiteCommande;
    }

    public void setQuantiteCommande(int quantiteCommande) {
        this.quantiteCommande = quantiteCommande;
    }

    public double getPrixHTarticle() {
        return prixHTarticle;
    }

    public void setPrixHTarticle(double prixHTarticle) {
        this.prixHTarticle = prixHTarticle;
    }

    public double getPrixHTLigne() {
        return prixHTLigne;
    }

    public void setPrixHTLigne(double prixHTLigne) {
        this.prixHTLigne = prixHTLigne;
    }


    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }


 
    
}