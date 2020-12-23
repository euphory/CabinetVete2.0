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
public class Fournisseur implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFournisseur;
    @Column(length=70)
    private String nom;
    @Column(length=140)
    private String Adress;
    private int numTVA;
    private int telephone;
    @Column(length=70)
    private String AdressMail;
    @Column(length=70)
    private String numCompte;

/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/ 
    @ManyToMany
    @JoinTable( name = "ArticleMedical_Fournisseur_Prestation",
        joinColumns = @JoinColumn( name = "idFournisseur" ),
        inverseJoinColumns = @JoinColumn( name = "idArticleMedical" ) )
    private List<ArticleMedical> articleMedicals = new ArrayList<>();
    
    @ManyToMany
    @JoinTable( name = "ArticleMedical_Fournisseur_Prestation",
        joinColumns = @JoinColumn( name = "idFournisseur" ),
        inverseJoinColumns = @JoinColumn( name = "idPrestation" ) )
    private List<Prestation> prestations = new ArrayList<>();
    
    @OneToMany(mappedBy="fournisseur", fetch=FetchType.LAZY)
    private List<Prix> prix = new ArrayList<>();
    
    
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
 */ 

    public Fournisseur(String nom, String Adress, int numTVA, int telephone, String AdressMail, String numCompte) {
        this.nom = nom;
        this.Adress = Adress;
        this.numTVA = numTVA;
        this.telephone = telephone;
        this.AdressMail = AdressMail;
        this.numCompte = numCompte;
    }

    public Fournisseur() {
    }

    public Long getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(Long idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    public int getNumTVA() {
        return numTVA;
    }

    public void setNumTVA(int numTVA) {
        this.numTVA = numTVA;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getAdressMail() {
        return AdressMail;
    }

    public void setAdressMail(String AdressMail) {
        this.AdressMail = AdressMail;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public List<ArticleMedical> getArticleMedicals() {
        return articleMedicals;
    }

    public void setArticleMedicals(List<ArticleMedical> articleMedicals) {
        this.articleMedicals = articleMedicals;
    }

    public List<Prestation> getPrestations() {
        return prestations;
    }

    public void setPrestations(List<Prestation> prestations) {
        this.prestations = prestations;
    }
    

}
