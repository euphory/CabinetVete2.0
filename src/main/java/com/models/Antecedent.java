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

/**
 *
 * @author PC
 */
@Entity
public class Antecedent implements Serializable{ 
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idAntecedents;
    private Date age;
    @Column(length=70)
    private String antecedent;
    @Column(length=140)
    private String Description;
    
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
    public Antecedent(Long idAntecedents, Date age, String antecedent, String Description, Animal animal) {
        this.idAntecedents = idAntecedents;
        this.age = age;
        this.antecedent = antecedent;
        this.Description = Description;
        this.animal = animal;
    }

    public Antecedent() {
    }

    public Long getIdAntecedents() {
        return idAntecedents;
    }

    public void setIdAntecedents(Long idAntecedents) {
        this.idAntecedents = idAntecedents;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public String getAntecedent() {
        return antecedent;
    }

    public void setAntecedent(String antecedent) {
        this.antecedent = antecedent;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    

    

}   
