/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigf.beans;

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
 * @author w8
 */
@Entity
@Table(name = "tb_guiaremision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guiaremision.findAll", query = "SELECT g FROM Guiaremision g")
    , @NamedQuery(name = "Guiaremision.findByNroguia", query = "SELECT g FROM Guiaremision g WHERE g.nroguia = :nroguia")
    , @NamedQuery(name = "Guiaremision.findByFlgEntregado", query = "SELECT g FROM Guiaremision g WHERE g.flgEntregado = :flgEntregado")
    , @NamedQuery(name = "Guiaremision.findByFechahora", query = "SELECT g FROM Guiaremision g WHERE g.fechahora = :fechahora")
    , @NamedQuery(name = "Guiaremision.findByCantidadtotal", query = "SELECT g FROM Guiaremision g WHERE g.cantidadtotal = :cantidadtotal")})
public class Guiaremision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "nroguia")
    private String nroguia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "flgEntregado")
    private String flgEntregado;
    @Column(name = "fechahora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahora;
    @Column(name = "cantidadtotal")
    private Integer cantidadtotal;
    @JoinColumn(name = "nrocomprobante", referencedColumnName = "nrocomprobante")
    @OneToOne(optional = false)
    private Comprobantepago nrocomprobante;

    public Guiaremision() {
    }

    public Guiaremision(String nroguia) {
        this.nroguia = nroguia;
    }

    public Guiaremision(String nroguia, String flgEntregado) {
        this.nroguia = nroguia;
        this.flgEntregado = flgEntregado;
    }

    public String getNroguia() {
        return nroguia;
    }

    public void setNroguia(String nroguia) {
        this.nroguia = nroguia;
    }

    public String getFlgEntregado() {
        return flgEntregado;
    }

    public void setFlgEntregado(String flgEntregado) {
        this.flgEntregado = flgEntregado;
    }

    public Date getFechahora() {
        return fechahora;
    }

    public void setFechahora(Date fechahora) {
        this.fechahora = fechahora;
    }

    public Integer getCantidadtotal() {
        return cantidadtotal;
    }

    public void setCantidadtotal(Integer cantidadtotal) {
        this.cantidadtotal = cantidadtotal;
    }

    public Comprobantepago getNrocomprobante() {
        return nrocomprobante;
    }

    public void setNrocomprobante(Comprobantepago nrocomprobante) {
        this.nrocomprobante = nrocomprobante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroguia != null ? nroguia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guiaremision)) {
            return false;
        }
        Guiaremision other = (Guiaremision) object;
        if ((this.nroguia == null && other.nroguia != null) || (this.nroguia != null && !this.nroguia.equals(other.nroguia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sigf.beans.Guiaremision[ nroguia=" + nroguia + " ]";
    }
    
}
