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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}