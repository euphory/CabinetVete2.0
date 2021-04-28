/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author PC
 */
@Entity
public class Adoptable implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateAbandon;
    @Column(length=70)
    private String motifAbandon;
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/
    @OneToOne(fetch = FetchType.LAZY)
    private Animal animal;
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    public Adoptable(Long id, Date dateAbandon, String motifAbandon, Animal animal) {
        this.id = id;
        this.dateAbandon = dateAbandon;
        this.motifAbandon = motifAbandon;
        this.animal = animal;
    }

    public Adoptable() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @DateTimeFormat(pattern="dd-mm-yyyy")
    public Date getDateAbandon() {
        return dateAbandon;
    }
    @DateTimeFormat(pattern="yyyy-mm-dd")
    public void setDateAbandon(Date dateAbandon) {
        this.dateAbandon = dateAbandon;
    }

    public String getMotifAbandon() {
        return motifAbandon;
    }

    public void setMotifAbandon(String motifAbandon) {
        this.motifAbandon = motifAbandon;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    

    
}