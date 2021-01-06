/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author PC
 */
@Embeddable
public class FAPId implements Serializable{
    
    private Long fournisseurId;
    private Long articleMedicalId;
    private Long prestationId;

    public FAPId(Long fournisseurId, Long ArticleMedicalId, Long PrestationId) {
        this.fournisseurId = fournisseurId;
        this.articleMedicalId = ArticleMedicalId;
        this.prestationId = PrestationId;
    }

    public FAPId() {
    }

    public Long getfournisseurId() {
        return fournisseurId;
    }

    public void setfournisseurId(Long fournisseurId) {
        this.fournisseurId = fournisseurId;
    }

    public Long getArticleMedicalId() {
        return articleMedicalId;
    }

    public void setArticleMedicalId(Long ArticleMedicalId) {
        this.articleMedicalId = ArticleMedicalId;
    }

    public Long getPrestationId() {
        return prestationId;
    }

    public void setPrestationId(Long PrestationId) {
        this.prestationId = PrestationId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.fournisseurId);
        hash = 79 * hash + Objects.hashCode(this.articleMedicalId);
        hash = 79 * hash + Objects.hashCode(this.prestationId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FAPId other = (FAPId) obj;
        if (!Objects.equals(this.fournisseurId, other.fournisseurId)) {
            return false;
        }
        if (!Objects.equals(this.articleMedicalId, other.articleMedicalId)) {
            return false;
        }
        if (!Objects.equals(this.prestationId, other.prestationId)) {
            return false;
        }
        return true;
    }
    
    

}
