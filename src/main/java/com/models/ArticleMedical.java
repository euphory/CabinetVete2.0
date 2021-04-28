/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author PC
 */
@Entity
public class ArticleMedical implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JsonIgnore
    private List<FAP> fap;
    
    @OneToMany(mappedBy = "fournisseur")
    @JsonIgnore
    private List<Prix> prix;
    
    @OneToMany(mappedBy = "commande")
    @JsonIgnore
    private List<LigneCommande> ligneCommande;


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

    public List<LigneCommande> getLigneCommande() {
        return ligneCommande;
    }

    public void setLigneCommande(List<LigneCommande> ligneCommande) {
        this.ligneCommande = ligneCommande;
    }

    public void setFap(List<FAP> fap) {
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



    public List<Prix> getPrix() {
        return prix;
    }

    public void setPrix(List<Prix> prix) {
        this.prix = prix;
    }

     
    public Long getArticleMedicalId() {
        return articleMedicalId;
    }

    public void setArticleMedicalId(Long articleMedicalId) {
        this.articleMedicalId = articleMedicalId;
    }

    public List<FAP> getFap() {
        return fap;
    }

 
    
}
