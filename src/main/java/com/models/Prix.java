/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author PC
 */
@Entity
public class Prix {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Prix")
    private Long idPrix;
    private double prixHT;
    private double prixTTC;    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------

    @ManyToMany
    @JoinTable( name = "T_Prix",
            joinColumns = @JoinColumn( name = "idPrix" ),
            inverseJoinColumns = @JoinColumn( name = "idArticleMedical" ) )
    private ArrayList<ArticleMedical> articleMedicals = new ArrayList<>();
*/    
    @ManyToOne
    @JoinColumn( name="idFourniseur", nullable=false)
    private Fournisseur fournisseur;
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
}