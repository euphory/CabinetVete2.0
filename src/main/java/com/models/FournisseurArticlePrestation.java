/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 *
 * @author PC
 */
@Entity
public class FournisseurArticlePrestation implements Serializable{

    @EmbeddedId
    private Long idFAP;
    
    @ManyToOne
    @MapsId("idFournisseur")
    @JoinColumn(name = "idFournisseur")
    Fournisseur fournisseur;

    @ManyToOne
    @MapsId("idArticleMedical")
    @JoinColumn(name = "idArticleMedical")
    ArticleMedical articleMedical;
    
    @ManyToOne
    @MapsId("idPrestation")
    @JoinColumn(name = "idPrestation")
    Prestation prestation;
    
    
}
