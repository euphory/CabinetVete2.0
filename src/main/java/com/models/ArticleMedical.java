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
public class ArticleMedical implements Serializable{
    @Id
    @GeneratedValue
    private Long idArticleMedical;
    private int reference;
    @Column(length=70)
    private String nom;
    private int quantite;
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/
    @ManyToMany
    @JoinTable( name = "ArticleMedical_Fournisseur_Prestation",
            joinColumns = @JoinColumn( name = "idArticleMedical" ),
            inverseJoinColumns = @JoinColumn( name = "idPrestation" ) )
    private List<Prestation> prestations = new ArrayList<>();
    
    @ManyToMany
    @JoinTable( name = "ArticleMedical_Fournisseur_Prestation",
            joinColumns = @JoinColumn( name = "idArticleMedical" ),
            inverseJoinColumns = @JoinColumn( name = "idFournisseur" ) )
    private List<Fournisseur> fournisseurs = new ArrayList<>(); 
/**    
    @ManyToMany(mappedBy = "articleMedicals")
    private ArrayList<Prix> prix = new ArrayList<>(); 
 /**   
    @OneToMany(mappedBy="articleMedical", fetch=FetchType.LAZY)
    private ArrayList<LigneCommande> ligneCommandes;
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
 */ 
 
    
}
