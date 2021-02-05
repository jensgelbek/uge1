/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tirsdaguge1;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "person")
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByIdperson", query = "SELECT p FROM Person p WHERE p.personPK.idperson = :idperson"),
    @NamedQuery(name = "Person.findByNavn", query = "SELECT p FROM Person p WHERE p.navn = :navn"),
    @NamedQuery(name = "Person.findByAlder", query = "SELECT p FROM Person p WHERE p.alder = :alder"),
    @NamedQuery(name = "Person.findByAdresseIdadresse", query = "SELECT p FROM Person p WHERE p.personPK.adresseIdadresse = :adresseIdadresse")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonPK personPK;
    @Column(name = "navn")
    private String navn;
    @Column(name = "alder")
    private Integer alder;
    @JoinColumn(name = "adresse_idadresse", referencedColumnName = "idadresse", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Adresse adresse;

    public Person() {
    }

    public Person(PersonPK personPK) {
        this.personPK = personPK;
    }

    public Person(int idperson, int adresseIdadresse) {
        this.personPK = new PersonPK(idperson, adresseIdadresse);
    }

    public PersonPK getPersonPK() {
        return personPK;
    }

    public void setPersonPK(PersonPK personPK) {
        this.personPK = personPK;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Integer getAlder() {
        return alder;
    }

    public void setAlder(Integer alder) {
        this.alder = alder;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personPK != null ? personPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personPK == null && other.personPK != null) || (this.personPK != null && !this.personPK.equals(other.personPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tirsdaguge1.Person[ personPK=" + personPK + " ]";
    }
    
}
