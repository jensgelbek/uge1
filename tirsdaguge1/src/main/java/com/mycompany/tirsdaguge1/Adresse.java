/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tirsdaguge1;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "adresse")
@NamedQueries({
    @NamedQuery(name = "Adresse.findAll", query = "SELECT a FROM Adresse a"),
    @NamedQuery(name = "Adresse.findByIdadresse", query = "SELECT a FROM Adresse a WHERE a.idadresse = :idadresse"),
    @NamedQuery(name = "Adresse.findByVej", query = "SELECT a FROM Adresse a WHERE a.vej = :vej")})
public class Adresse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idadresse")
    private Integer idadresse;
    @Column(name = "vej")
    private String vej;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adresse")
    private Collection<Person> personCollection;

    public Adresse() {
    }

    public Adresse(Integer idadresse) {
        this.idadresse = idadresse;
    }

    public Integer getIdadresse() {
        return idadresse;
    }

    public void setIdadresse(Integer idadresse) {
        this.idadresse = idadresse;
    }

    public String getVej() {
        return vej;
    }

    public void setVej(String vej) {
        this.vej = vej;
    }

    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadresse != null ? idadresse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adresse)) {
            return false;
        }
        Adresse other = (Adresse) object;
        if ((this.idadresse == null && other.idadresse != null) || (this.idadresse != null && !this.idadresse.equals(other.idadresse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tirsdaguge1.Adresse[ idadresse=" + idadresse + " ]";
    }
    
}
