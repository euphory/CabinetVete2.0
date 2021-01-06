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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity

public class Medicament implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(length=70)
    private String nom;
    @Column(length=70)
    private String dosageMedic;
    @Column(length=140)
    private String usageMedic;
    
/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
*/
    
    @OneToMany(mappedBy="prescription")
    private Set<Posologie> posologies = new HashSet<>();
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/

    public Medicament(Long id, String nom, String dosageMedic, String usageMedic) {
        this.id = id;
        this.nom = nom;
        this.dosageMedic = dosageMedic;
        this.usageMedic = usageMedic;
    }

    public Medicament() {
    }

    public Long getId() {
        return id;
    }

    public void setId(int idMedicament) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDosageMedic() {
        return dosageMedic;
    }

    public void setDosageMedic(String dosageMedic) {
        this.dosageMedic = dosageMedic;
    }

    public String getUsageMedic() {
        return usageMedic;
    }

    public void setUsageMedic(String usageMedic) {
        this.usageMedic = usageMedic;
    }

    public Set<Posologie> getPosologies() {
        return posologies;
    }

    public void setPosologies(Set<Posologie> posologies) {
        this.posologies = posologies;
    }

  
  

    
}