/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author camilo
 */
@Entity
@Table(name = "specialty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Specialty.findAll", query = "SELECT s FROM Specialty s"),
    @NamedQuery(name = "Specialty.findBySpecialtyid", query = "SELECT s FROM Specialty s WHERE s.specialtyid = :specialtyid"),
    @NamedQuery(name = "Specialty.findBySpecialtyName", query = "SELECT s FROM Specialty s WHERE s.specialtyName = :specialtyName")})
public class Specialty implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "specialtyid")
    private Integer specialtyid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "specialty_name")
    private String specialtyName;
    @JoinColumn(name = "areaid", referencedColumnName = "areaid")
    @ManyToOne
    private Area areaid;
    @OneToMany(mappedBy = "specialtyid")
    private Collection<Professionals> professionalsCollection;

    public Specialty() {
    }

    public Specialty(Integer specialtyid) {
        this.specialtyid = specialtyid;
    }

    public Specialty(Integer specialtyid, String specialtyName) {
        this.specialtyid = specialtyid;
        this.specialtyName = specialtyName;
    }

    public Integer getSpecialtyid() {
        return specialtyid;
    }

    public void setSpecialtyid(Integer specialtyid) {
        this.specialtyid = specialtyid;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public Area getAreaid() {
        return areaid;
    }

    public void setAreaid(Area areaid) {
        this.areaid = areaid;
    }

    @XmlTransient
    public Collection<Professionals> getProfessionalsCollection() {
        return professionalsCollection;
    }

    public void setProfessionalsCollection(Collection<Professionals> professionalsCollection) {
        this.professionalsCollection = professionalsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specialtyid != null ? specialtyid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specialty)) {
            return false;
        }
        Specialty other = (Specialty) object;
        if ((this.specialtyid == null && other.specialtyid != null) || (this.specialtyid != null && !this.specialtyid.equals(other.specialtyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Specialty[ specialtyid=" + specialtyid + " ]";
    }
    
}
