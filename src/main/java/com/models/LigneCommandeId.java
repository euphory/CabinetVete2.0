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
public class LigneCommandeId implements Serializable{
    
    private Long articleMedicalId;
    private Long commandeId;

    public LigneCommandeId(Long articleMedicalId, Long commandeId) {
        this.articleMedicalId = articleMedicalId;
        this.commandeId = commandeId;
    }

    public LigneCommandeId() {
    }

    public Long getArticleMedicalId() {
        return articleMedicalId;
    }

    public void setArticleMedicalId(Long articleMedicalId) {
        this.articleMedicalId = articleMedicalId;
    }

    public Long getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(Long commandeId) {
        this.commandeId = commandeId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.articleMedicalId);
        hash = 29 * hash + Objects.hashCode(this.commandeId);
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
        final LigneCommandeId other = (LigneCommandeId) obj;
        if (!Objects.equals(this.articleMedicalId, other.articleMedicalId)) {
            return false;
        }
        if (!Objects.equals(this.commandeId, other.commandeId)) {
            return false;
        }
        return true;
    }
    
    
}
