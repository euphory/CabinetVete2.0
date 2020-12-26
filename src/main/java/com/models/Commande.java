/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

    @OneToMany(mappedBy="commande")
    private Set<LigneCommande> ligneCommandes; 
        
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
}