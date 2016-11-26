/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigf.beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author w8
 */
@Entity
@Table(name = "tb_miscelaneos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Miscelaneos.findAll", query = "SELECT t FROM Miscelaneos t")
    , @NamedQuery(name = "Miscelaneos.findBySecuencia", query = "SELECT t FROM Miscelaneos t WHERE t.secuencia = :secuencia")
    , @NamedQuery(name = "Miscelaneos.findByCodproceso", query = "SELECT t FROM Miscelaneos t WHERE t.codproceso = :codproceso")
    , @NamedQuery(name = "Miscelaneos.findByCodelemento", query = "SELECT t FROM Miscelaneos t WHERE t.codelemento = :codelemento")
    , @NamedQuery(name = "Miscelaneos.findByDescelemento", query = "SELECT t FROM Miscelaneos t WHERE t.descelemento = :descelemento")
    , @NamedQuery(name = "Miscelaneos.findByEstado", query = "SELECT t FROM Miscelaneos t WHERE t.estado = :estado")})
public class Miscelaneos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "secuencia")
    private Integer secuencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codproceso")
    private String codproceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codelemento")
    private String codelemento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descelemento")
    private String descelemento;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmoneda")
    private Collection<Comprobantepago> tbComprobantepagoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codtipodocumento")
    private Collection<Comprobantepago> tbComprobantepagoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codtipopago")
    private Collection<Comprobantepago> tbComprobantepagoCollection2;

    public Miscelaneos() {
    }

    public Miscelaneos(Integer secuencia) {
        this.secuencia = secuencia;
    }

    public Miscelaneos(Integer secuencia, String codproceso, String codelemento, String descelemento) {
        this.secuencia = secuencia;
        this.codproceso = codproceso;
        this.codelemento = codelemento;
        this.descelemento = descelemento;
    }

    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    public String getCodproceso() {
        return codproceso;
    }

    public void setCodproceso(String codproceso) {
        this.codproceso = codproceso;
    }

    public String getCodelemento() {
        return codelemento;
    }

    public void setCodelemento(String codelemento) {
        this.codelemento = codelemento;
    }

    public String getDescelemento() {
        return descelemento;
    }

    public void setDescelemento(String descelemento) {
        this.descelemento = descelemento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Comprobantepago> getTbComprobantepagoCollection() {
        return tbComprobantepagoCollection;
    }

    public void setTbComprobantepagoCollection(Collection<Comprobantepago> tbComprobantepagoCollection) {
        this.tbComprobantepagoCollection = tbComprobantepagoCollection;
    }

    @XmlTransient
    public Collection<Comprobantepago> getTbComprobantepagoCollection1() {
        return tbComprobantepagoCollection1;
    }

    public void setTbComprobantepagoCollection1(Collection<Comprobantepago> tbComprobantepagoCollection1) {
        this.tbComprobantepagoCollection1 = tbComprobantepagoCollection1;
    }

    @XmlTransient
    public Collection<Comprobantepago> getTbComprobantepagoCollection2() {
        return tbComprobantepagoCollection2;
    }

    public void setTbComprobantepagoCollection2(Collection<Comprobantepago> tbComprobantepagoCollection2) {
        this.tbComprobantepagoCollection2 = tbComprobantepagoCollection2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secuencia != null ? secuencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Miscelaneos)) {
            return false;
        }
        Miscelaneos other = (Miscelaneos) object;
        if ((this.secuencia == null && other.secuencia != null) || (this.secuencia != null && !this.secuencia.equals(other.secuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sigf.beans.Miscelaneos[ secuencia=" + secuencia + " ]";
    }
    
}
