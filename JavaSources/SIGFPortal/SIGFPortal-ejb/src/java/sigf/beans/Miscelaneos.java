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
    @NamedQuery(name = "Miscelaneos.findAll", query = "SELECT m FROM Miscelaneos m")
    , @NamedQuery(name = "Miscelaneos.findByCodproceso", query = "SELECT m FROM Miscelaneos m WHERE m.codproceso = :codproceso")
    , @NamedQuery(name = "Miscelaneos.findByCodelemento", query = "SELECT m FROM Miscelaneos m WHERE m.codelemento = :codelemento")
    , @NamedQuery(name = "Miscelaneos.findByDescelemento", query = "SELECT m FROM Miscelaneos m WHERE m.descelemento = :descelemento")
    , @NamedQuery(name = "Miscelaneos.findByEstado", query = "SELECT m FROM Miscelaneos m WHERE m.estado = :estado")})
public class Miscelaneos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codproceso")
    private String codproceso;
    @Id
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
    private Collection<Comprobantepago> comprobantepagoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codtipodocumento")
    private Collection<Comprobantepago> comprobantepagoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codtipopago")
    private Collection<Comprobantepago> comprobantepagoCollection2;

    public Miscelaneos() {
    }

    public Miscelaneos(String codelemento) {
        this.codelemento = codelemento;
    }

    public Miscelaneos(String codproceso, String codelemento) {
        this.codproceso = codproceso;
        this.codelemento = codelemento;
    }
    
    public Miscelaneos(String codelemento, String codproceso, String descelemento) {
        this.codelemento = codelemento;
        this.codproceso = codproceso;
        this.descelemento = descelemento;
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
    public Collection<Comprobantepago> getComprobantepagoCollection() {
        return comprobantepagoCollection;
    }

    public void setComprobantepagoCollection(Collection<Comprobantepago> comprobantepagoCollection) {
        this.comprobantepagoCollection = comprobantepagoCollection;
    }

    @XmlTransient
    public Collection<Comprobantepago> getComprobantepagoCollection1() {
        return comprobantepagoCollection1;
    }

    public void setComprobantepagoCollection1(Collection<Comprobantepago> comprobantepagoCollection1) {
        this.comprobantepagoCollection1 = comprobantepagoCollection1;
    }

    @XmlTransient
    public Collection<Comprobantepago> getComprobantepagoCollection2() {
        return comprobantepagoCollection2;
    }

    public void setComprobantepagoCollection2(Collection<Comprobantepago> comprobantepagoCollection2) {
        this.comprobantepagoCollection2 = comprobantepagoCollection2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codelemento != null ? codelemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Miscelaneos)) {
            return false;
        }
        Miscelaneos other = (Miscelaneos) object;
        if ((this.codelemento == null && other.codelemento != null) || (this.codelemento != null && !this.codelemento.equals(other.codelemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sigf.beans.Miscelaneos[ codelemento=" + codelemento + " ]";
    }
    
}
