/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author camilo
 */
@Entity
@Table(name = "citacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Citacion.findAll", query = "SELECT c FROM Citacion c"),
    @NamedQuery(name = "Citacion.findByCitationId", query = "SELECT c FROM Citacion c WHERE c.citationId = :citationId"),
    @NamedQuery(name = "Citacion.findByCitationHour", query = "SELECT c FROM Citacion c WHERE c.citationHour = :citationHour"),
    @NamedQuery(name = "Citacion.findByCitationDay", query = "SELECT c FROM Citacion c WHERE c.citationDay = :citationDay")})
public class Citacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "citation_id")
    private Integer citationId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "citation_hour")
    @Temporal(TemporalType.TIME)
    private Date citationHour;
    @Basic(optional = false)
    @NotNull
    @Column(name = "citation_day")
    @Temporal(TemporalType.DATE)
    private Date citationDay;
    @JoinColumn(name = "crecid", referencedColumnName = "crecid")
    @ManyToOne(optional = false)
    private Clinicalrecords crecid;
    @JoinColumn(name = "rut", referencedColumnName = "rut")
    @ManyToOne
    private Professionals rut;
    @OneToMany(mappedBy = "citationId")
    private Collection<CitacionDiagnostico> citacionDiagnosticoCollection;

    public Citacion() {
    }

    public Citacion(Integer citationId) {
        this.citationId = citationId;
    }

    public Citacion(Integer citationId, Date citationHour, Date citationDay) {
        this.citationId = citationId;
        this.citationHour = citationHour;
        this.citationDay = citationDay;
    }

    public Integer getCitationId() {
        return citationId;
    }

    public void setCitationId(Integer citationId) {
        this.citationId = citationId;
    }

    public Date getCitationHour() {
        return citationHour;
    }

    public void setCitationHour(Date citationHour) {
        this.citationHour = citationHour;
    }

    public Date getCitationDay() {
        return citationDay;
    }

    public void setCitationDay(Date citationDay) {
        this.citationDay = citationDay;
    }

    public Clinicalrecords getCrecid() {
        return crecid;
    }

    public void setCrecid(Clinicalrecords crecid) {
        this.crecid = crecid;
    }

    public Professionals getRut() {
        return rut;
    }

    public void setRut(Professionals rut) {
        this.rut = rut;
    }

    @XmlTransient
    public Collection<CitacionDiagnostico> getCitacionDiagnosticoCollection() {
        return citacionDiagnosticoCollection;
    }

    public void setCitacionDiagnosticoCollection(Collection<CitacionDiagnostico> citacionDiagnosticoCollection) {
        this.citacionDiagnosticoCollection = citacionDiagnosticoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (citationId != null ? citationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citacion)) {
            return false;
        }
        Citacion other = (Citacion) object;
        if ((this.citationId == null && other.citationId != null) || (this.citationId != null && !this.citationId.equals(other.citationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Citacion[ citationId=" + citationId + " ]";
    }
    
}
