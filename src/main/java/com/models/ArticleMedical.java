/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
public class ArticleMedical implements Serializable{
    @Id
    @GeneratedValue
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
    @ManyToMany
    @JoinTable( name = "ArticleMedical_Fournisseur_Prestation",
            joinColumns = @JoinColumn( name = "idArticleMedical" ),
            inverseJoinColumns = @JoinColumn( name = "idPrestation" ) )
    private List<Prestation> prestations = new ArrayList<>();
    
    @ManyToMany
    @JoinTable( name = "ArticleMedical_Fournisseur_Prestation",
            joinColumns = @JoinColumn( name = "idArticleMedical" ),
            inverseJoinColumns = @JoinColumn( name = "idFournisseur" ) )
    private List<Fournisseur> fournisseurs = new ArrayList<>(); 
/**    
    @ManyToMany(mappedBy = "articleMedicals")
    private ArrayList<Prix> prix = new ArrayList<>(); 
 /**   
    @OneToMany(mappedBy="articleMedical", fetch=FetchType.LAZY)
    private ArrayList<LigneCommande> ligneCommandes;
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
 */ 
    public ArticleMedical(int reference, String nom, int quantite) {
        this.reference = reference;
        this.nom = nom;
        this.quantite = quantite;
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

    public List<Prestation> getPrestations() {
        return prestations;
    }

    public void setPrestations(List<Prestation> prestations) {
        this.prestations = prestations;
    }

    public List<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }

    public void setFournisseurs(List<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }
    
    
}
