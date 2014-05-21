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
@Table(name = "forma_farmaceutica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormaFarmaceutica.findAll", query = "SELECT f FROM FormaFarmaceutica f"),
    @NamedQuery(name = "FormaFarmaceutica.findByFormafarmaceuticaid", query = "SELECT f FROM FormaFarmaceutica f WHERE f.formafarmaceuticaid = :formafarmaceuticaid"),
    @NamedQuery(name = "FormaFarmaceutica.findByCodigoff", query = "SELECT f FROM FormaFarmaceutica f WHERE f.codigoff = :codigoff"),
    @NamedQuery(name = "FormaFarmaceutica.findByNombreFf", query = "SELECT f FROM FormaFarmaceutica f WHERE f.nombreFf = :nombreFf")})
public class FormaFarmaceutica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "formafarmaceuticaid")
    private Integer formafarmaceuticaid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "codigoff")
    private String codigoff;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_ff")
    private String nombreFf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formafarmaceuticaid")
    private Collection<FfFarmaco> ffFarmacoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formafarmaceuticaid")
    private Collection<DosisFf> dosisFfCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formafarmaceuticaid")
    private Collection<RexternaFarmaco> rexternaFarmacoCollection;

    public FormaFarmaceutica() {
    }

    public FormaFarmaceutica(Integer formafarmaceuticaid) {
        this.formafarmaceuticaid = formafarmaceuticaid;
    }

    public FormaFarmaceutica(Integer formafarmaceuticaid, String codigoff, String nombreFf) {
        this.formafarmaceuticaid = formafarmaceuticaid;
        this.codigoff = codigoff;
        this.nombreFf = nombreFf;
    }

    public Integer getFormafarmaceuticaid() {
        return formafarmaceuticaid;
    }

    public void setFormafarmaceuticaid(Integer formafarmaceuticaid) {
        this.formafarmaceuticaid = formafarmaceuticaid;
    }

    public String getCodigoff() {
        return codigoff;
    }

    public void setCodigoff(String codigoff) {
        this.codigoff = codigoff;
    }

    public String getNombreFf() {
        return nombreFf;
    }

    public void setNombreFf(String nombreFf) {
        this.nombreFf = nombreFf;
    }

    @XmlTransient
    public Collection<FfFarmaco> getFfFarmacoCollection() {
        return ffFarmacoCollection;
    }

    public void setFfFarmacoCollection(Collection<FfFarmaco> ffFarmacoCollection) {
        this.ffFarmacoCollection = ffFarmacoCollection;
    }

    @XmlTransient
    public Collection<DosisFf> getDosisFfCollection() {
        return dosisFfCollection;
    }

    public void setDosisFfCollection(Collection<DosisFf> dosisFfCollection) {
        this.dosisFfCollection = dosisFfCollection;
    }

    @XmlTransient
    public Collection<RexternaFarmaco> getRexternaFarmacoCollection() {
        return rexternaFarmacoCollection;
    }

    public void setRexternaFarmacoCollection(Collection<RexternaFarmaco> rexternaFarmacoCollection) {
        this.rexternaFarmacoCollection = rexternaFarmacoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (formafarmaceuticaid != null ? formafarmaceuticaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaFarmaceutica)) {
            return false;
        }
        FormaFarmaceutica other = (FormaFarmaceutica) object;
        if ((this.formafarmaceuticaid == null && other.formafarmaceuticaid != null) || (this.formafarmaceuticaid != null && !this.formafarmaceuticaid.equals(other.formafarmaceuticaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FormaFarmaceutica[ formafarmaceuticaid=" + formafarmaceuticaid + " ]";
    }
    
}
