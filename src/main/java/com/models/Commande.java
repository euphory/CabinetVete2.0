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
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy= GenerationType.AUTO)
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
    @JoinColumn(name="idEmployeVeterinaire")
    private Employe veterinaire;
    
    @ManyToOne
    @JoinColumn(name="idEmployeSecretaireMedical")
    private Employe secretaireMedical;
    
    @ManyToOne
    private Fournisseur fournisseur;

    @OneToMany(mappedBy="commande")
    private Set<LigneCommande> ligneCommandes; 
    
    @OneToOne
    private Facture facture ;
    
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/ 
}