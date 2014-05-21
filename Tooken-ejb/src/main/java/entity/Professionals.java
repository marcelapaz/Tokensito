/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author camilo
 */
@Entity
@Table(name = "professionals")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professionals.findAll", query = "SELECT p FROM Professionals p"),
    @NamedQuery(name = "Professionals.findByRut", query = "SELECT p FROM Professionals p WHERE p.rut = :rut"),
    @NamedQuery(name = "Professionals.findByFirstName", query = "SELECT p FROM Professionals p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "Professionals.findByLastName", query = "SELECT p FROM Professionals p WHERE p.lastName = :lastName")})
public class Professionals implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "rut")
    private String rut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "last_name")
    private String lastName;
    @OneToMany(mappedBy = "rut")
    private Collection<Citacion> citacionCollection;
    @JoinColumn(name = "rut", referencedColumnName = "rut", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persons persons;
    @JoinColumn(name = "specialtyid", referencedColumnName = "specialtyid")
    @ManyToOne
    private Specialty specialtyid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rut")
    private Collection<Prescription> prescriptionCollection;

    public Professionals() {
    }

    public Professionals(String rut) {
        this.rut = rut;
    }

    public Professionals(String rut, String firstName, String lastName) {
        this.rut = rut;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlTransient
    public Collection<Citacion> getCitacionCollection() {
        return citacionCollection;
    }

    public void setCitacionCollection(Collection<Citacion> citacionCollection) {
        this.citacionCollection = citacionCollection;
    }

    public Persons getPersons() {
        return persons;
    }

    public void setPersons(Persons persons) {
        this.persons = persons;
    }

    public Specialty getSpecialtyid() {
        return specialtyid;
    }

    public void setSpecialtyid(Specialty specialtyid) {
        this.specialtyid = specialtyid;
    }

    @XmlTransient
    public Collection<Prescription> getPrescriptionCollection() {
        return prescriptionCollection;
    }

    public void setPrescriptionCollection(Collection<Prescription> prescriptionCollection) {
        this.prescriptionCollection = prescriptionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rut != null ? rut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professionals)) {
            return false;
        }
        Professionals other = (Professionals) object;
        if ((this.rut == null && other.rut != null) || (this.rut != null && !this.rut.equals(other.rut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Professionals[ rut=" + rut + " ]";
    }
    
}
