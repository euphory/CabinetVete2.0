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
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author PC
 */
@Entity
public class Antecedent implements Serializable{ 
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idAntecedent;
    @Temporal(TemporalType.DATE)
    private Date age;
    @Column(length=70)
    private String antece;
    @Column(length=140)
    private String description;
    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/
    @ManyToOne
    @JoinColumn( name="idAnimal", nullable= true)
    private Animal animal;
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/

    public Antecedent() {
    }

    public Antecedent(Long idAntecedent, Date age, String antece, String description, Animal animal) {
        this.idAntecedent = idAntecedent;
        this.age = age;
        this.antece = antece;
        this.description = description;
        this.animal = animal;
    }

    public Long getIdAntecedent() {
        return idAntecedent;
    }

    public void setIdAntecedent(Long idAntecedent) {
        this.idAntecedent = idAntecedent;
    }
    @DateTimeFormat(pattern="dd-mm-yyyy")
    public Date getAge() {
        return age;
    }
    @DateTimeFormat(pattern="yyyy-mm-dd")
    public void setAge(Date age) {
        this.age = age;
    }

    public String getAntece() {
        return antece;
    }

    public void setAntece(String antece) {
        this.antece = antece;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    

}   
