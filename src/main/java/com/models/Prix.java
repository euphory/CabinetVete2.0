/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author PC
 */
@Entity
public class Prix {
    @Id
    @GeneratedValue
    private Long idPrix;
    private double prixHT;
    private double prixTTC;    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/    
    @ManyToMany(fetch=FetchType.LAZY)
    private Set<Fournisseur> fournisseurs;
    
    @ManyToOne
    @JoinColumn( name="idArticleMedical")
    private ArticleMedical articleMedical;
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/

    public Prix(Long idPrix, double prixHT, double prixTTC, Set<Fournisseur> fournisseurs, ArticleMedical articleMedical) {
        this.idPrix = idPrix;
        this.prixHT = prixHT;
        this.prixTTC = prixTTC;
        this.fournisseurs = fournisseurs;
        this.articleMedical = articleMedical;
    }

    public Prix() {
    }

    public Long getIdPrix() {
        return idPrix;
    }

    public void setIdPrix(Long idPrix) {
        this.idPrix = idPrix;
    }

    public double getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(double prixHT) {
        this.prixHT = prixHT;
    }

    public double getPrixTTC() {
        return prixTTC;
    }

    public void setPrixTTC(double prixTTC) {
        this.prixTTC = prixTTC;
    }

    public Set<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }

    public void setFournisseurs(Set<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }

    public ArticleMedical getArticleMedical() {
        return articleMedical;
    }

    public void setArticleMedical(ArticleMedical articleMedical) {
        this.articleMedical = articleMedical;
    }
    

}