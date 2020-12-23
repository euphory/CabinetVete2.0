/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author PC
 */
@Entity
public class Personne implements Serializable {
    @Id
    @GeneratedValue
    private Long idPersonne;
    @Column(length=70)
    private String nom;
    @Column(length=70)
    private String prenom;
    @Column(length=140)
    private String adress;
    private int numAssurence;
    @Column(length=70)
    private String adressMail;
    private int telephone;
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
 */    
    @OneToMany(mappedBy="personne", fetch=FetchType.LAZY)
    private Set<Formulaire> formulaires;
  
    @OneToMany(mappedBy="personne", fetch=FetchType.LAZY)
    private Set<Animal> animaux;
    
    @OneToMany(mappedBy="personne", fetch = FetchType.LAZY)
    private Set<Consultation> consultations;
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
   

}
