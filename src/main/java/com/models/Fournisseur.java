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
    private String Adress;
    private int numTVA;
    private String telephone;
    @Column(length=70)
    private String AdressMail;
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

    public Fournisseur(Long fournisseurId, String nom, String Adress, int numTVA, String telephone, String AdressMail, String numCompte, Set<Prix> prix, Set<Commande> commandes) {
        this.fournisseurId = fournisseurId;
        this.nom = nom;
        this.Adress = Adress;
        this.numTVA = numTVA;
        this.telephone = telephone;
        this.AdressMail = AdressMail;
        this.numCompte = numCompte;
        this.prix = prix;
        this.commandes = commandes;
    }

    public Long getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(Long fournisseurId) {
        this.fournisseurId = fournisseurId;
    }

    public Set<FAP> getFap() {
        return fap;
    }

    public void setFap(Set<FAP> fap) {
        this.fap = fap;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
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
