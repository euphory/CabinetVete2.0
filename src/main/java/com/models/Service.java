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

/**
 *
 * @author PC
 */
@Entity
public class Service implements Serializable{
    @Id
    @GeneratedValue
    private Long idService;
    @Column(length=70)
    private String type;
    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
  */
    
    @ManyToMany(mappedBy = "services")
    private Set<PrixVet> prixVet;

/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
 */
    public Service(Long idService, String type, Set<PrixVet> prixVet) {
        this.idService = idService;
        this.type = type;
        this.prixVet = prixVet;
    }

    public Service() {
    }

    public Long getIdService() {
        return idService;
    }

    public void setIdService(Long idService) {
        this.idService = idService;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<PrixVet> getPrixVet() {
        return prixVet;
    }

    public void setPrixVet(Set<PrixVet> prixVet) {
        this.prixVet = prixVet;
    }

    

}
