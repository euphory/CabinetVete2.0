/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.models.security.Authority;
import com.models.security.UserRole;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author PC
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Employe implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(length=70)
    private String username;
    @Column(length=70)
    private String mdp;
    @Column(length=70)
    private String nom;
    @Column(length=70)
    private String prenom;
    @Column(length=140)
    private String adresse;
    @Column(length=70)
    private String telephone;

    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    
    public Employe(Long id, String username, String mdp, String nom, String prenom, String adresse, String telephone) {
        this.id = id;
        this.username = username;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public Employe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return username;
    }

    public void setLogin(String username) {
        this.username = username;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdress() {
        return adresse;
    }

    public void setAdress(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    

  
}

    
  
