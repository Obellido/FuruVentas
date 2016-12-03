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
@Table(name = "tb_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByRuc", query = "SELECT c FROM Cliente c WHERE c.ruc = :ruc")
    , @NamedQuery(name = "Cliente.findByRazonsocial", query = "SELECT c FROM Cliente c WHERE c.razonsocial = :razonsocial")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "RUC")
    private String ruc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "razonsocial")
    private String razonsocial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codcliente")
    private Collection<Comprobantepago> comprobantepagoCollection;

    public Cliente() {
    }

    public Cliente(String ruc) {
        this.ruc = ruc;
    }

    public Cliente(String ruc, String razonsocial) {
        this.ruc = ruc;
        this.razonsocial = razonsocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    @XmlTransient
    public Collection<Comprobantepago> getComprobantepagoCollection() {
        return comprobantepagoCollection;
    }

    public void setComprobantepagoCollection(Collection<Comprobantepago> comprobantepagoCollection) {
        this.comprobantepagoCollection = comprobantepagoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruc != null ? ruc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.ruc == null && other.ruc != null) || (this.ruc != null && !this.ruc.equals(other.ruc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sigf.beans.Cliente[ ruc=" + ruc + " ]";
    }
    
}
