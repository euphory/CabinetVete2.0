/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

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
public class Fournisseur implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=70)
    private String nom;
    @Column(length=140)
    private String adresse;
    private int numTVA;
    private String telephone;
    @Column(length=70)
    private String adresseMail;
    @Column(length=70)
    private String numCompte;

/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/
    @OneToMany(mappedBy="prestation")
    private List<FAP> fap;
    
    @OneToMany(mappedBy="articleMedical")
    private List<Prix> prix;
    
    @OneToMany(mappedBy = "fournisseur")
    private List<Commande> commandes;
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    public Fournisseur() {
    }

    public Fournisseur(Long id, String nom, String adresse, int numTVA, String telephone, String adresseMail, String numCompte, List<Commande> commandes) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.numTVA = numTVA;
        this.telephone = telephone;
        this.adresseMail = adresseMail;
        this.numCompte = numCompte;
        this.commandes = commandes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNumTVA() {
        return numTVA;
    }

    public void setNumTVA(int numTVA) {
        this.numTVA = numTVA;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public List<FAP> getFap() {
        return fap;
    }

    public void setFap(List<FAP> fap) {
        this.fap = fap;
    }

    public List<Prix> getPrix() {
        return prix;
    }

    public void setPrix(List<Prix> prix) {
        this.prix = prix;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }



}
