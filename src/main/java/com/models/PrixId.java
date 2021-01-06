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
public class PrixId implements Serializable{
    
    private Long fournisseurId;
    private Long articleMedicalId;

    public PrixId(Long fournisseurId, Long articleMedicalId) {
        this.fournisseurId = fournisseurId;
        this.articleMedicalId = articleMedicalId;
    }

    public PrixId() {
    }

    public Long getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(Long fournisseurId) {
        this.fournisseurId = fournisseurId;
    }

    public Long getArticleMedicalId() {
        return articleMedicalId;
    }

    public void setArticleMedicalId(Long articleMedicalId) {
        this.articleMedicalId = articleMedicalId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.fournisseurId);
        hash = 97 * hash + Objects.hashCode(this.articleMedicalId);
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
        final PrixId other = (PrixId) obj;
        if (!Objects.equals(this.fournisseurId, other.fournisseurId)) {
            return false;
        }
        if (!Objects.equals(this.articleMedicalId, other.articleMedicalId)) {
            return false;
        }
        return true;
    }
    
    
}
