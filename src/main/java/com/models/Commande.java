/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author PC
 */
@Entity
public class Commande implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;
    private int reference;
    private Calendar dateCommande;
    private double total;
    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/
    @ManyToOne
    @JoinColumn(name="idEmployeVeterinaire")
    private Employe veterinaire;
    
    @ManyToOne
    @JoinColumn(name="idEmployeSecretaireMedical")
    private Employe secretaireMedical;
    
    @ManyToOne
    private Fournisseur fournisseur;

    @OneToMany(mappedBy="articleMedical")
    @JsonIgnore
    private List<LigneCommande> ligneCommandes;
    
    @OneToOne
    @JoinColumn(name="idFacture", nullable = true)
    private Facture facture ;
/**
-- -----------------------------------------------------------------------------
-- - Constructeur                                                            ---
-- -----------------------------------------------------------------------------
*/
    public Commande(Long idCommande, int reference, Calendar dateCommande, double total, Employe veterinaire, Employe secretaireMedical, Fournisseur fournisseur, Facture facture) {
        this.idCommande = idCommande;
        this.reference = reference;
        this.dateCommande = dateCommande;
        this.total = total;
        this.veterinaire = veterinaire;
        this.secretaireMedical = secretaireMedical;
        this.fournisseur = fournisseur;
        this.facture = facture;
    }

    public Commande() {
    }

    public Long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }
    @DateTimeFormat(pattern="yyyy-mm-dd")
    public Calendar getDateCommande() {
        return dateCommande;
    }
    @DateTimeFormat(pattern="yyyy-mm-dd")
    public void setDateCommande(Calendar dateCommande) {
        this.dateCommande = dateCommande;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Employe getVeterinaire() {
        return veterinaire;
    }

    public void setVeterinaire(Employe veterinaire) {
        this.veterinaire = veterinaire;
    }

    public Employe getSecretaireMedical() {
        return secretaireMedical;
    }

    public void setSecretaireMedical(Employe secretaireMedical) {
        this.secretaireMedical = secretaireMedical;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public List<LigneCommande> getLigneCommandes() {
        return ligneCommandes;
    }

    public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }
    
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/ 
    
    
    
}