/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author PC
 */
@Entity
public class LigneCommande implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idLigneCommande;
    private int quantiteCommande;
    private double prixHTarticle;
    private double prixHTLigne;
    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/ 
    @ManyToMany(fetch=FetchType.LAZY)
    private Set<ArticleMedical> articleMedical;
    
    @ManyToOne
    @JoinColumn(name="idCommande")
    private Commande commande;
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    public LigneCommande(Long idLigneCommande, int quantiteCommande, double prixHTarticle, double prixHTLigne, Set<ArticleMedical> articleMedical, Commande commande) {
        this.idLigneCommande = idLigneCommande;
        this.quantiteCommande = quantiteCommande;
        this.prixHTarticle = prixHTarticle;
        this.prixHTLigne = prixHTLigne;
        this.articleMedical = articleMedical;
        this.commande = commande;
    }

    public LigneCommande() {
    }

    public Long getIdLigneCommande() {
        return idLigneCommande;
    }

    public void setIdLigneCommande(Long idLigneCommande) {
        this.idLigneCommande = idLigneCommande;
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

    public Set<ArticleMedical> getArticleMedical() {
        return articleMedical;
    }

    public void setArticleMedical(Set<ArticleMedical> articleMedical) {
        this.articleMedical = articleMedical;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }


 
    
}