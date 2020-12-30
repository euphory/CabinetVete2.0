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
public class Fournisseur implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
    @OneToMany(mappedBy = "fournisseur")
    Set<FournisseurArticlePrestation> FAP;
    
    @ManyToMany(mappedBy = "fournisseurs")
    private Set<Prix> prix;
    
    @OneToMany(mappedBy = "fournisseur")
    Set<Commande> commandes;
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    public Fournisseur() {
    }

    public Fournisseur(Long idFournisseur, String nom, String Adress, int numTVA, int telephone, String AdressMail, String numCompte, Set<FournisseurArticlePrestation> FAP, Set<Prix> prix, Set<Commande> commandes) {
        this.idFournisseur = idFournisseur;
        this.nom = nom;
        this.Adress = Adress;
        this.numTVA = numTVA;
        this.telephone = telephone;
        this.AdressMail = AdressMail;
        this.numCompte = numCompte;
        this.FAP = FAP;
        this.prix = prix;
        this.commandes = commandes;
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

    public Set<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }
    
    


}
