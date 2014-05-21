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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author camilo
 */
@Entity
@Table(name = "prevision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prevision.findAll", query = "SELECT p FROM Prevision p"),
    @NamedQuery(name = "Prevision.findByPrevisionid", query = "SELECT p FROM Prevision p WHERE p.previsionid = :previsionid"),
    @NamedQuery(name = "Prevision.findByType", query = "SELECT p FROM Prevision p WHERE p.type = :type")})
public class Prevision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "previsionid")
    private Integer previsionid;
    @Size(max = 100)
    @Column(name = "type")
    private String type;
    @OneToMany(mappedBy = "previsionid")
    private Collection<Patients> patientsCollection;
    @JoinColumn(name = "tipoprevisionid", referencedColumnName = "tipoprevisionid")
    @ManyToOne
    private TipoPrevision tipoprevisionid;

    public Prevision() {
    }

    public Prevision(Integer previsionid) {
        this.previsionid = previsionid;
    }

    public Integer getPrevisionid() {
        return previsionid;
    }

    public void setPrevisionid(Integer previsionid) {
        this.previsionid = previsionid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public Collection<Patients> getPatientsCollection() {
        return patientsCollection;
    }

    public void setPatientsCollection(Collection<Patients> patientsCollection) {
        this.patientsCollection = patientsCollection;
    }

    public TipoPrevision getTipoprevisionid() {
        return tipoprevisionid;
    }

    public void setTipoprevisionid(TipoPrevision tipoprevisionid) {
        this.tipoprevisionid = tipoprevisionid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (previsionid != null ? previsionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prevision)) {
            return false;
        }
        Prevision other = (Prevision) object;
        if ((this.previsionid == null && other.previsionid != null) || (this.previsionid != null && !this.previsionid.equals(other.previsionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Prevision[ previsionid=" + previsionid + " ]";
    }

    
    
}
