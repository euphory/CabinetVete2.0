/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author PC
 */

@Entity
public class Fournisseur implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @ManyToMany
    @JoinTable( name = "ArticleMedical_Fournisseur_Prestation",
        joinColumns = @JoinColumn( name = "idFournisseur" ),
        inverseJoinColumns = @JoinColumn( name = "idArticleMedical" ) )
    private List<ArticleMedical> articleMedicals = new ArrayList<>();
    
    @ManyToMany
    @JoinTable( name = "ArticleMedical_Fournisseur_Prestation",
        joinColumns = @JoinColumn( name = "idFournisseur" ),
        inverseJoinColumns = @JoinColumn( name = "idPrestation" ) )
    private List<Prestation> prestations = new ArrayList<>();
    
    @OneToMany(mappedBy="fournisseur", fetch=FetchType.LAZY)
    private List<Prix> prix = new ArrayList<>();
    
    
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
 */ 

}
