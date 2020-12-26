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
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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
        
    @OneToMany(mappedBy = "articleMedical")
    Set<FournisseurArticlePrestation> FAP;
    
    @OneToMany(mappedBy="articleMedical")
    private Set<Prix> prix;
    
    @ManyToMany(mappedBy = "articleMedical")
    private Set<LigneCommande> ligneCommandes;
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
 */ 
 
    
}
