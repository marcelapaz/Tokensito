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
@Table(name = "tipo_prevision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPrevision.findAll", query = "SELECT t FROM TipoPrevision t"),
    @NamedQuery(name = "TipoPrevision.findByTipoprevisionid", query = "SELECT t FROM TipoPrevision t WHERE t.tipoprevisionid = :tipoprevisionid"),
    @NamedQuery(name = "TipoPrevision.findByNombretipoprevision", query = "SELECT t FROM TipoPrevision t WHERE t.nombretipoprevision = :nombretipoprevision")})
public class TipoPrevision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipoprevisionid")
    private Integer tipoprevisionid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombretipoprevision")
    private String nombretipoprevision;
    @OneToMany(mappedBy = "tipoprevisionid")
    private Collection<Prevision> previsionCollection;

    public TipoPrevision() {
    }

    public TipoPrevision(Integer tipoprevisionid) {
        this.tipoprevisionid = tipoprevisionid;
    }

    public TipoPrevision(Integer tipoprevisionid, String nombretipoprevision) {
        this.tipoprevisionid = tipoprevisionid;
        this.nombretipoprevision = nombretipoprevision;
    }

    public Integer getTipoprevisionid() {
        return tipoprevisionid;
    }

    public void setTipoprevisionid(Integer tipoprevisionid) {
        this.tipoprevisionid = tipoprevisionid;
    }

    public String getNombretipoprevision() {
        return nombretipoprevision;
    }

    public void setNombretipoprevision(String nombretipoprevision) {
        this.nombretipoprevision = nombretipoprevision;
    }

    @XmlTransient
    public Collection<Prevision> getPrevisionCollection() {
        return previsionCollection;
    }

    public void setPrevisionCollection(Collection<Prevision> previsionCollection) {
        this.previsionCollection = previsionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoprevisionid != null ? tipoprevisionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPrevision)) {
            return false;
        }
        TipoPrevision other = (TipoPrevision) object;
        if ((this.tipoprevisionid == null && other.tipoprevisionid != null) || (this.tipoprevisionid != null && !this.tipoprevisionid.equals(other.tipoprevisionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TipoPrevision[ tipoprevisionid=" + tipoprevisionid + " ]";
    }
    
}
