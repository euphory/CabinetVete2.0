/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
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
    private Long idArticleMedical;
    private int reference;
    @Column(length=70)
    private String nom;
    private int quantite;
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/
        
    @OneToMany(mappedBy = "articleMedical")
    Set<FournisseurArticlePrestation> FAP;
    
    @OneToMany(mappedBy="articleMedical")
    private Set<Prix> prix;
    
    @ManyToMany(mappedBy = "articleMedical")
    private Set<LigneCommande> ligneCommandes;
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
 */ 
    public ArticleMedical(Long idArticleMedical, int reference, String nom, int quantite, Set<FournisseurArticlePrestation> FAP, Set<Prix> prix, Set<LigneCommande> ligneCommandes) {
        this.idArticleMedical = idArticleMedical;
        this.reference = reference;
        this.nom = nom;
        this.quantite = quantite;
        this.FAP = FAP;
        this.prix = prix;
        this.ligneCommandes = ligneCommandes;
    }

    public ArticleMedical() {
    }

    public Long getIdArticleMedical() {
        return idArticleMedical;
    }

    public void setIdArticleMedical(Long idArticleMedical) {
        this.idArticleMedical = idArticleMedical;
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

    public Set<FournisseurArticlePrestation> getFAP() {
        return FAP;
    }

    public void setFAP(Set<FournisseurArticlePrestation> FAP) {
        this.FAP = FAP;
    }

    public Set<Prix> getPrix() {
        return prix;
    }

    public void setPrix(Set<Prix> prix) {
        this.prix = prix;
    }

    public Set<LigneCommande> getLigneCommandes() {
        return ligneCommandes;
    }

    public void setLigneCommandes(Set<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }
    

 
    
}
