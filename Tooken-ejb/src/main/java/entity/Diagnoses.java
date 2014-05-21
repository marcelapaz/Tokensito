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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author camilo
 */
@Entity
@Table(name = "diagnoses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnoses.findAll", query = "SELECT d FROM Diagnoses d"),
    @NamedQuery(name = "Diagnoses.findByDiagnosesId", query = "SELECT d FROM Diagnoses d WHERE d.diagnosesId = :diagnosesId"),
    @NamedQuery(name = "Diagnoses.findByDiagDate", query = "SELECT d FROM Diagnoses d WHERE d.diagDate = :diagDate"),
    @NamedQuery(name = "Diagnoses.findByDiagComment", query = "SELECT d FROM Diagnoses d WHERE d.diagComment = :diagComment")})
public class Diagnoses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "diagnoses_id")
    private Integer diagnosesId;
    @Column(name = "diag_date")
    @Temporal(TemporalType.DATE)
    private Date diagDate;
    @Size(max = 2147483647)
    @Column(name = "diag_comment")
    private String diagComment;
    @JoinColumn(name = "crecid", referencedColumnName = "crecid")
    @ManyToOne(optional = false)
    private Clinicalrecords crecid;
    @JoinColumn(name = "prescriptionid", referencedColumnName = "prescriptionid")
    @ManyToOne
    private Prescription prescriptionid;
    @OneToMany(mappedBy = "diagnosesId")
    private Collection<CitacionDiagnostico> citacionDiagnosticoCollection;

    public Diagnoses() {
    }

    public Diagnoses(Integer diagnosesId) {
        this.diagnosesId = diagnosesId;
    }

    public Integer getDiagnosesId() {
        return diagnosesId;
    }

    public void setDiagnosesId(Integer diagnosesId) {
        this.diagnosesId = diagnosesId;
    }

    public Date getDiagDate() {
        return diagDate;
    }

    public void setDiagDate(Date diagDate) {
        this.diagDate = diagDate;
    }

    public String getDiagComment() {
        return diagComment;
    }

    public void setDiagComment(String diagComment) {
        this.diagComment = diagComment;
    }

    public Clinicalrecords getCrecid() {
        return crecid;
    }

    public void setCrecid(Clinicalrecords crecid) {
        this.crecid = crecid;
    }

    public Prescription getPrescriptionid() {
        return prescriptionid;
    }

    public void setPrescriptionid(Prescription prescriptionid) {
        this.prescriptionid = prescriptionid;
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
        hash += (diagnosesId != null ? diagnosesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnoses)) {
            return false;
        }
        Diagnoses other = (Diagnoses) object;
        if ((this.diagnosesId == null && other.diagnosesId != null) || (this.diagnosesId != null && !this.diagnosesId.equals(other.diagnosesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Diagnoses[ diagnosesId=" + diagnosesId + " ]";
    }
    
}
