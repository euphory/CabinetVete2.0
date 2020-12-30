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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author PC
 */
@Entity
public class Medicament implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idMedicament;
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
    
    @OneToMany(mappedBy="medicament")
    private Set<Posologie> posologies;
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/

    public Medicament(Long idMedicament, String nom, String dosageMedic, String usageMedic, Set<Posologie> posologies) {
        this.idMedicament = idMedicament;
        this.nom = nom;
        this.dosageMedic = dosageMedic;
        this.usageMedic = usageMedic;
        this.posologies = posologies;
    }

    public Medicament() {
    }

    public Long getIdMedicament() {
        return idMedicament;
    }

    public void setIdMedicament(Long idMedicament) {
        this.idMedicament = idMedicament;
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