/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table (name = "Service")
public class ServiceV implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idService;
    @Column(length=70)
    private String type;
    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
  */
    
    @OneToMany(mappedBy="prestation")
    private Set<PrixVet> prixVet = new HashSet<>();
    

/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
 */


    public ServiceV(Long idService, String type) {
        this.idService = idService;
        this.type = type;
    }

    public ServiceV() {
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
