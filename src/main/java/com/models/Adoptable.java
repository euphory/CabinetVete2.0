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
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idAdoptable;
    @Temporal(TemporalType.DATE)
    private Date dateAbandon;
    @Column(length=70)
    private String motifAbandon;
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/
    @OneToOne 
    @JoinColumn(name="idAnimal", nullable=true )
    private Animal animal;
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    public Adoptable(Long idAdoptable, Date dateAbandon, String motifAbandon, Animal animal) {
        this.idAdoptable = idAdoptable;
        this.dateAbandon = dateAbandon;
        this.motifAbandon = motifAbandon;
        this.animal = animal;
    }

    public Adoptable() {
    }

    public Long getIdAdoptable() {
        return idAdoptable;
    }

    public void setIdAdoptable(Long idAdoptable) {
        this.idAdoptable = idAdoptable;
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