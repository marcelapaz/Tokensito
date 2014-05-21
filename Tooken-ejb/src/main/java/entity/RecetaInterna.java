/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author camilo
 */
@Entity
@Table(name = "receta_interna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecetaInterna.findAll", query = "SELECT r FROM RecetaInterna r"),
    @NamedQuery(name = "RecetaInterna.findByPrescriptionid", query = "SELECT r FROM RecetaInterna r WHERE r.prescriptionid = :prescriptionid"),
    @NamedQuery(name = "RecetaInterna.findByCrecid", query = "SELECT r FROM RecetaInterna r WHERE r.crecid = :crecid"),
    @NamedQuery(name = "RecetaInterna.findByDescription", query = "SELECT r FROM RecetaInterna r WHERE r.description = :description"),
    @NamedQuery(name = "RecetaInterna.findByPrescriptionDay", query = "SELECT r FROM RecetaInterna r WHERE r.prescriptionDay = :prescriptionDay")})
public class RecetaInterna implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prescriptionid")
    private Integer prescriptionid;
    @Column(name = "crecid")
    private Integer crecid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prescription_day")
    @Temporal(TemporalType.DATE)
    private Date prescriptionDay;
    @JoinColumn(name = "prescriptionid", referencedColumnName = "prescriptionid", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Prescription prescription;

    public RecetaInterna() {
    }

    public RecetaInterna(Integer prescriptionid) {
        this.prescriptionid = prescriptionid;
    }

    public RecetaInterna(Integer prescriptionid, String description, Date prescriptionDay) {
        this.prescriptionid = prescriptionid;
        this.description = description;
        this.prescriptionDay = prescriptionDay;
    }

    public Integer getPrescriptionid() {
        return prescriptionid;
    }

    public void setPrescriptionid(Integer prescriptionid) {
        this.prescriptionid = prescriptionid;
    }

    public Integer getCrecid() {
        return crecid;
    }

    public void setCrecid(Integer crecid) {
        this.crecid = crecid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPrescriptionDay() {
        return prescriptionDay;
    }

    public void setPrescriptionDay(Date prescriptionDay) {
        this.prescriptionDay = prescriptionDay;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prescriptionid != null ? prescriptionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecetaInterna)) {
            return false;
        }
        RecetaInterna other = (RecetaInterna) object;
        if ((this.prescriptionid == null && other.prescriptionid != null) || (this.prescriptionid != null && !this.prescriptionid.equals(other.prescriptionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RecetaInterna[ prescriptionid=" + prescriptionid + " ]";
    }
    
}
