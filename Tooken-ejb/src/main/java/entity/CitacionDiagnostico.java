/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author camilo
 */
@Entity
@Table(name = "citacion_diagnostico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CitacionDiagnostico.findAll", query = "SELECT c FROM CitacionDiagnostico c"),
    @NamedQuery(name = "CitacionDiagnostico.findByCitacionDiagnostico", query = "SELECT c FROM CitacionDiagnostico c WHERE c.citacionDiagnostico = :citacionDiagnostico")})
public class CitacionDiagnostico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "citacion_diagnostico")
    private Integer citacionDiagnostico;
    @JoinColumn(name = "citation_id", referencedColumnName = "citation_id")
    @ManyToOne
    private Citacion citationId;
    @JoinColumn(name = "diagnoses_id", referencedColumnName = "diagnoses_id")
    @ManyToOne
    private Diagnoses diagnosesId;

    public CitacionDiagnostico() {
    }

    public CitacionDiagnostico(Integer citacionDiagnostico) {
        this.citacionDiagnostico = citacionDiagnostico;
    }

    public Integer getCitacionDiagnostico() {
        return citacionDiagnostico;
    }

    public void setCitacionDiagnostico(Integer citacionDiagnostico) {
        this.citacionDiagnostico = citacionDiagnostico;
    }

    public Citacion getCitationId() {
        return citationId;
    }

    public void setCitationId(Citacion citationId) {
        this.citationId = citationId;
    }

    public Diagnoses getDiagnosesId() {
        return diagnosesId;
    }

    public void setDiagnosesId(Diagnoses diagnosesId) {
        this.diagnosesId = diagnosesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (citacionDiagnostico != null ? citacionDiagnostico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CitacionDiagnostico)) {
            return false;
        }
        CitacionDiagnostico other = (CitacionDiagnostico) object;
        if ((this.citacionDiagnostico == null && other.citacionDiagnostico != null) || (this.citacionDiagnostico != null && !this.citacionDiagnostico.equals(other.citacionDiagnostico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CitacionDiagnostico[ citacionDiagnostico=" + citacionDiagnostico + " ]";
    }
    
}
