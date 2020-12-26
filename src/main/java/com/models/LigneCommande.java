/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author PC
 */
@Entity
public class LigneCommande implements Serializable{
    @Id
    @GeneratedValue
    private Long idLigneCommande;
    private int quantiteCommande;
    private double prixHTarticle;
    private double prixHTLigne;
    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
  
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable( name = "LigneCommande",
            joinColumns = @JoinColumn( name = "idLigneCommandee" ),
            inverseJoinColumns = @JoinColumn( name = "idCommande" ) )
    private ArrayList<Commande> commandes = new ArrayList<>();
    */ 
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable( name = "T_LigneCommande")
    private Set<ArticleMedical> articleMedical;
    
    @ManyToOne
    @JoinColumn(name="idCommande")
    private Commande commande;
/**    
    @ManyToOne
    @JoinColumn(name="idArticleMedical")
    private ArticleMedical articleMedical;
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
 
    
}