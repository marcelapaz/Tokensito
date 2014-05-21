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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author camilo
 */
@Entity
@Table(name = "clinicalrecords")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clinicalrecords.findAll", query = "SELECT c FROM Clinicalrecords c"),
    @NamedQuery(name = "Clinicalrecords.findByRut", query = "SELECT c FROM Clinicalrecords c WHERE c.rut = :rut"),
    @NamedQuery(name = "Clinicalrecords.findByCrecid", query = "SELECT c FROM Clinicalrecords c WHERE c.crecid = :crecid")})

public class Clinicalrecords implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "crecid")
    private Integer crecid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crecid")
    private Collection<Citacion> citacionCollection;
    @JoinColumn(name = "rut", referencedColumnName = "rut")
    @ManyToOne(optional = false)
    private Patients rut;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crecid")
    private Collection<Diagnoses> diagnosesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crecid")
    private Collection<Prescription> prescriptionCollection;

    public Clinicalrecords() {
    }

    public Clinicalrecords(Integer crecid) {
        this.crecid = crecid;
    }

    public Integer getCrecid() {
        return crecid;
    }

    public void setCrecid(Integer crecid) {
        this.crecid = crecid;
    }

    @XmlTransient
    public Collection<Citacion> getCitacionCollection() {
        return citacionCollection;
    }

    public void setCitacionCollection(Collection<Citacion> citacionCollection) {
        this.citacionCollection = citacionCollection;
    }

    public Patients getRut() {
        return rut;
    }

    public void setRut(Patients rut) {
        this.rut = rut;
    }

    @XmlTransient
    public Collection<Diagnoses> getDiagnosesCollection() {
        return diagnosesCollection;
    }

    public void setDiagnosesCollection(Collection<Diagnoses> diagnosesCollection) {
        this.diagnosesCollection = diagnosesCollection;
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
        hash += (crecid != null ? crecid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clinicalrecords)) {
            return false;
        }
        Clinicalrecords other = (Clinicalrecords) object;
        if ((this.crecid == null && other.crecid != null) || (this.crecid != null && !this.crecid.equals(other.crecid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Clinicalrecords[ crecid=" + crecid + " ]";
    }
    
}
