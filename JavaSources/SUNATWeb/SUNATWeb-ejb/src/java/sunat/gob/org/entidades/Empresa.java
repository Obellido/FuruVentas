/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sunat.gob.org.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")
    , @NamedQuery(name = "Empresa.findByRuc", query = "SELECT e FROM Empresa e WHERE e.ruc = :ruc")
    , @NamedQuery(name = "Empresa.findByClave", query = "SELECT e FROM Empresa e WHERE e.clave = :clave")
    , @NamedQuery(name = "Empresa.findByTipo", query = "SELECT e FROM Empresa e WHERE e.tipo = :tipo")
    , @NamedQuery(name = "Empresa.findByRazonsocial", query = "SELECT e FROM Empresa e WHERE e.razonsocial = :razonsocial")
    , @NamedQuery(name = "Empresa.findByDireccion", query = "SELECT e FROM Empresa e WHERE e.direccion = :direccion")
    , @NamedQuery(name = "Empresa.findByDepartamento", query = "SELECT e FROM Empresa e WHERE e.departamento = :departamento")
    , @NamedQuery(name = "Empresa.findByProvincia", query = "SELECT e FROM Empresa e WHERE e.provincia = :provincia")
    , @NamedQuery(name = "Empresa.findByDistrito", query = "SELECT e FROM Empresa e WHERE e.distrito = :distrito")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "ruc")
    private String ruc;
    @Size(max = 10)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "razonsocial")
    private String razonsocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "departamento")
    private String departamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "provincia")
    private String provincia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "distrito")
    private String distrito;
    @OneToMany(mappedBy = "rucempresa")
    private Collection<ComprobanteElectronico> comprobanteElectronicoCollection;
    @OneToMany(mappedBy = "ruccliente")
    private Collection<ComprobanteElectronico> comprobanteElectronicoCollection1;

    public Empresa() {
    }

    public Empresa(String ruc) {
        this.ruc = ruc;
    }

    public Empresa(String ruc, String tipo, String razonsocial, String direccion, String departamento, String provincia, String distrito) {
        this.ruc = ruc;
        this.tipo = tipo;
        this.razonsocial = razonsocial;
        this.direccion = direccion;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    @XmlTransient
    public Collection<ComprobanteElectronico> getComprobanteElectronicoCollection() {
        return comprobanteElectronicoCollection;
    }

    public void setComprobanteElectronicoCollection(Collection<ComprobanteElectronico> comprobanteElectronicoCollection) {
        this.comprobanteElectronicoCollection = comprobanteElectronicoCollection;
    }

    @XmlTransient
    public Collection<ComprobanteElectronico> getComprobanteElectronicoCollection1() {
        return comprobanteElectronicoCollection1;
    }

    public void setComprobanteElectronicoCollection1(Collection<ComprobanteElectronico> comprobanteElectronicoCollection1) {
        this.comprobanteElectronicoCollection1 = comprobanteElectronicoCollection1;
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
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.ruc == null && other.ruc != null) || (this.ruc != null && !this.ruc.equals(other.ruc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sunat.gob.org.entidades.Empresa[ ruc=" + ruc + " ]";
    }
    
}
