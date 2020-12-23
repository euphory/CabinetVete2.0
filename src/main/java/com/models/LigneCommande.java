/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
    @GeneratedValue
    private Long idLigneCommande;
    private int quantiteCommande;
    private double prixHTarticle;
    private double prixHTLigne;
    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
  
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable( name = "LigneCommande",
            joinColumns = @JoinColumn( name = "idLigneCommandee" ),
            inverseJoinColumns = @JoinColumn( name = "idCommande" ) )
    private ArrayList<Commande> commandes = new ArrayList<>();
/**    
    @ManyToOne
    @JoinColumn(name="idArticleMedical")
    private ArticleMedical articleMedical;
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    public LigneCommande(int quantiteCommande, double prixHTarticle, double prixHTLigne) {
        this.quantiteCommande = quantiteCommande;
        this.prixHTarticle = prixHTarticle;
        this.prixHTLigne = prixHTLigne;
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
/**
    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(ArrayList<Commande> commandes) {
        this.commandes = commandes;
    }
*/
    
    
}