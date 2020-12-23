/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author PC
 */
@Entity
public class Commande implements Serializable{
    @Id
    @GeneratedValue
    private Long idCommande;
    private int reference;
    private Calendar dateCoammande;
    private double total;
    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/
    @ManyToOne
    @JoinColumn(name="idEmploye")
    private Employe employe;
/**       
    @ManyToMany(mappedBy = "commandes")
    private List<LigneCommande> Lignecomande = new ArrayList<>();
   */ 
    @ManyToOne
    @JoinColumn(name="idFournisseur", nullable=true)
    private Fournisseur fournisseur;
    
    @OneToOne
    @JoinColumn( name="commande", nullable=true )
    private Facture facture ;
    
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/ 
    public Commande(int reference, Calendar dateCoammande, double total) {
        this.reference = reference;
        this.dateCoammande = dateCoammande;
        this.total = total;
    }

    public Commande() {
    }

    public Commande(int reference, Calendar dateCoammande, double total, Fournisseur fournisseur) {
        this.reference = reference;
        this.dateCoammande = dateCoammande;
        this.total = total;
        this.fournisseur = fournisseur;
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

    public Calendar getDateCoammande() {
        return dateCoammande;
    }

    public void setDateCoammande(Calendar dateCoammande) {
        this.dateCoammande = dateCoammande;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
/**
    public List<LigneCommande> getLignecomande() {
        return Lignecomande;
    }

    public void setLignecomande(List<LigneCommande> Lignecomande) {
        this.Lignecomande = Lignecomande;
    }
*/
    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    
    
}