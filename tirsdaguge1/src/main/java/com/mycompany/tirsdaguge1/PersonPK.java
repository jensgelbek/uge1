/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tirsdaguge1;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author PC
 */
@Embeddable
public class PersonPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idperson")
    private int idperson;
    @Basic(optional = false)
    @Column(name = "adresse_idadresse")
    private int adresseIdadresse;

    public PersonPK() {
    }

    public PersonPK(int idperson, int adresseIdadresse) {
        this.idperson = idperson;
        this.adresseIdadresse = adresseIdadresse;
    }

    public int getIdperson() {
        return idperson;
    }

    public void setIdperson(int idperson) {
        this.idperson = idperson;
    }

    public int getAdresseIdadresse() {
        return adresseIdadresse;
    }

    public void setAdresseIdadresse(int adresseIdadresse) {
        this.adresseIdadresse = adresseIdadresse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idperson;
        hash += (int) adresseIdadresse;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonPK)) {
            return false;
        }
        PersonPK other = (PersonPK) object;
        if (this.idperson != other.idperson) {
            return false;
        }
        if (this.adresseIdadresse != other.adresseIdadresse) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tirsdaguge1.PersonPK[ idperson=" + idperson + ", adresseIdadresse=" + adresseIdadresse + " ]";
    }
    
}
