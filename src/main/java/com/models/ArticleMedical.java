/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author PC
 */
@Entity
public class ArticleMedical implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long articleMedicalId;
    private int reference;
    @Column(length=70)
    private String nom;
    private int quantite;
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/
        
    @OneToMany(mappedBy="fournisseur")
    private Set<FAP> fap = new HashSet<>();
    
    @OneToMany(mappedBy = "fournisseur")
    private Set<Prix> prix = new HashSet<>();
    
    @OneToMany(mappedBy = "commande")
    private Set<LigneCommande> ligneCommande = new HashSet<>();


/**
    -- -----------------------------------------------------------------------------
    -- - Constructor                                                             ---
    -- -----------------------------------------------------------------------------
     */
    
    
    public ArticleMedical(Long articleMedicalId, int reference, String nom, int quantite) {
        this.articleMedicalId = articleMedicalId;
        this.reference = reference;
        this.nom = nom;
        this.quantite = quantite;
    }

    public Set<LigneCommande> getLigneCommande() {
        return ligneCommande;
    }

    public void setLigneCommande(Set<LigneCommande> ligneCommande) {
        this.ligneCommande = ligneCommande;
    }

    public void setFap(Set<FAP> fap) {
        this.fap = fap;
    }

    public ArticleMedical() {
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }



    public Set<Prix> getPrix() {
        return prix;
    }

    public void setPrix(Set<Prix> prix) {
        this.prix = prix;
    }

     
    public Long getArticleMedicalId() {
        return articleMedicalId;
    }

    public void setArticleMedicalId(Long articleMedicalId) {
        this.articleMedicalId = articleMedicalId;
    }

    public Set<FAP> getFap() {
        return fap;
    }

 
    
}
