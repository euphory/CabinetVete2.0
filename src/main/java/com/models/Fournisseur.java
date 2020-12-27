/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author PC
 */

@Entity
public class Fournisseur implements Serializable{
    @Id
    @GeneratedValue
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

}
