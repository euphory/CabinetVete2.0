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
public class Fournisseur implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long fournisseurId;
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
    private Set<FAP> fap = new HashSet<>();
    
    @OneToMany(mappedBy="articleMedical")
    private Set<Prix> prix = new HashSet<>();
    
    @OneToMany(mappedBy = "fournisseur")
    Set<Commande> commandes;
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    public Fournisseur() {
    }

    public Fournisseur(Long fournisseurId, String nom, String adresse, int numTVA, String telephone, String adresseMail, String numCompte, Set<Commande> commandes) {
        this.fournisseurId = fournisseurId;
        this.nom = nom;
        this.adresse = adresse;
        this.numTVA = numTVA;
        this.telephone = telephone;
        this.adresseMail = adresseMail;
        this.numCompte = numCompte;
        this.commandes = commandes;
    }

    public Long getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(Long fournisseurId) {
        this.fournisseurId = fournisseurId;
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

    public Set<FAP> getFap() {
        return fap;
    }

    public void setFap(Set<FAP> fap) {
        this.fap = fap;
    }

    public Set<Prix> getPrix() {
        return prix;
    }

    public void setPrix(Set<Prix> prix) {
        this.prix = prix;
    }

    public Set<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }



}
