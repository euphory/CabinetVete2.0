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
import java.util.List;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author PC
 */
@Entity
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=70)
    private String nom;
    @Column(length=70)
    private String prenom;
    
    private String username;
    
    private String password;
    @Column(length=140)
    private String adresse;
    @Column(length=70)
    private String adresseMail;
    @Column(length=70)
    private String numAssurance;
    @Column(length=70)
    private String telephone;
    private boolean enabled=true;
    

/**
-- -----------------------------------------------------------------------------
-- - Associations                                                            ---
-- -----------------------------------------------------------------------------
 */    
    @OneToMany(mappedBy="personne", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Formulaire> formulaires;
  
    @OneToMany(mappedBy="personne", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Animal> animaux;
    
    @OneToMany(mappedBy="personne", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Consultation> consultations;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<UserRole> userRoles = new HashSet<>();
    
/**
-- -----------------------------------------------------------------------------
-- - Constructor                                                             ---
-- -----------------------------------------------------------------------------
*/
    

    public User() {
    }

    public User(Long id, String nom, String prenom, String username, String password, String adresse, String adresseMail, String numAssurance, String telephone, List<Formulaire> formulaires, List<Animal> animaux, List<Consultation> consultations ) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
        this.adresse = adresse;
        this.adresseMail = adresseMail;
        this.numAssurance = numAssurance;
        this.telephone = telephone;
        this.formulaires = formulaires;
        this.animaux = animaux;
        this.consultations = consultations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public String getNumAssurance() {
        return numAssurance;
    }

    public void setNumAssurance(String numAssurance) {
        this.numAssurance = numAssurance;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Formulaire> getFormulaires() {
        return formulaires;
    }

    public void setFormulaires(List<Formulaire> formulaires) {
        this.formulaires = formulaires;
    }

    public List<Animal> getAnimaux() {
        return animaux;
    }

    public void setAnimaux(List<Animal> animaux) {
        this.animaux = animaux;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
        
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet();
        userRoles.forEach(ur -> authorities.add(new Authority(ur.getRole().getName())));
        return authorities;

    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
       return enabled;
    }


}
