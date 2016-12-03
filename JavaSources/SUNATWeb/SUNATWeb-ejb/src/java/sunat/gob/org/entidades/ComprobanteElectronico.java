/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sunat.gob.org.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author w8
 */
@Entity
@Table(name = "comprobante_electronico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComprobanteElectronico.findAll", query = "SELECT c FROM ComprobanteElectronico c")
    , @NamedQuery(name = "ComprobanteElectronico.findByNrocomprobante", query = "SELECT c FROM ComprobanteElectronico c WHERE c.nrocomprobante = :nrocomprobante")
    , @NamedQuery(name = "ComprobanteElectronico.findByTipo", query = "SELECT c FROM ComprobanteElectronico c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "ComprobanteElectronico.findByFechavencimiento", query = "SELECT c FROM ComprobanteElectronico c WHERE c.fechavencimiento = :fechavencimiento")
    , @NamedQuery(name = "ComprobanteElectronico.findByFechaemision", query = "SELECT c FROM ComprobanteElectronico c WHERE c.fechaemision = :fechaemision")
    , @NamedQuery(name = "ComprobanteElectronico.findByTipomoneda", query = "SELECT c FROM ComprobanteElectronico c WHERE c.tipomoneda = :tipomoneda")
    , @NamedQuery(name = "ComprobanteElectronico.findByObservacion", query = "SELECT c FROM ComprobanteElectronico c WHERE c.observacion = :observacion")
    , @NamedQuery(name = "ComprobanteElectronico.findBySubtotalventa", query = "SELECT c FROM ComprobanteElectronico c WHERE c.subtotalventa = :subtotalventa")
    , @NamedQuery(name = "ComprobanteElectronico.findByAnticipos", query = "SELECT c FROM ComprobanteElectronico c WHERE c.anticipos = :anticipos")
    , @NamedQuery(name = "ComprobanteElectronico.findByDescuentos", query = "SELECT c FROM ComprobanteElectronico c WHERE c.descuentos = :descuentos")
    , @NamedQuery(name = "ComprobanteElectronico.findByValorventa", query = "SELECT c FROM ComprobanteElectronico c WHERE c.valorventa = :valorventa")})
public class ComprobanteElectronico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "nrocomprobante")
    private String nrocomprobante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "fechavencimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechavencimiento;
    @Column(name = "fechaemision")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaemision;
    @Size(max = 2)
    @Column(name = "tipomoneda")
    private String tipomoneda;
    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "subtotalventa")
    private BigDecimal subtotalventa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anticipos")
    private BigDecimal anticipos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuentos")
    private BigDecimal descuentos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorventa")
    private BigDecimal valorventa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comprobanteElectronico")
    private Collection<ComprobanteElectronicoDetalle> comprobanteElectronicoDetalleCollection;
    @JoinColumn(name = "rucempresa", referencedColumnName = "ruc")
    @ManyToOne
    private Empresa rucempresa;
    @JoinColumn(name = "ruccliente", referencedColumnName = "ruc")
    @ManyToOne
    private Empresa ruccliente;

    public ComprobanteElectronico() {
    }

    public ComprobanteElectronico(String nrocomprobante) {
        this.nrocomprobante = nrocomprobante;
    }

    public ComprobanteElectronico(String nrocomprobante, String tipo, BigDecimal subtotalventa, BigDecimal anticipos, BigDecimal descuentos, BigDecimal valorventa) {
        this.nrocomprobante = nrocomprobante;
        this.tipo = tipo;
        this.subtotalventa = subtotalventa;
        this.anticipos = anticipos;
        this.descuentos = descuentos;
        this.valorventa = valorventa;
    }

    public String getNrocomprobante() {
        return nrocomprobante;
    }

    public void setNrocomprobante(String nrocomprobante) {
        this.nrocomprobante = nrocomprobante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public Date getFechaemision() {
        return fechaemision;
    }

    public void setFechaemision(Date fechaemision) {
        this.fechaemision = fechaemision;
    }

    public String getTipomoneda() {
        return tipomoneda;
    }

    public void setTipomoneda(String tipomoneda) {
        this.tipomoneda = tipomoneda;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public BigDecimal getSubtotalventa() {
        return subtotalventa;
    }

    public void setSubtotalventa(BigDecimal subtotalventa) {
        this.subtotalventa = subtotalventa;
    }

    public BigDecimal getAnticipos() {
        return anticipos;
    }

    public void setAnticipos(BigDecimal anticipos) {
        this.anticipos = anticipos;
    }

    public BigDecimal getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(BigDecimal descuentos) {
        this.descuentos = descuentos;
    }

    public BigDecimal getValorventa() {
        return valorventa;
    }

    public void setValorventa(BigDecimal valorventa) {
        this.valorventa = valorventa;
    }

    @XmlTransient
    public Collection<ComprobanteElectronicoDetalle> getComprobanteElectronicoDetalleCollection() {
        return comprobanteElectronicoDetalleCollection;
    }

    public void setComprobanteElectronicoDetalleCollection(Collection<ComprobanteElectronicoDetalle> comprobanteElectronicoDetalleCollection) {
        this.comprobanteElectronicoDetalleCollection = comprobanteElectronicoDetalleCollection;
    }

    public Empresa getRucempresa() {
        return rucempresa;
    }

    public void setRucempresa(Empresa rucempresa) {
        this.rucempresa = rucempresa;
    }

    public Empresa getRuccliente() {
        return ruccliente;
    }

    public void setRuccliente(Empresa ruccliente) {
        this.ruccliente = ruccliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nrocomprobante != null ? nrocomprobante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobanteElectronico)) {
            return false;
        }
        ComprobanteElectronico other = (ComprobanteElectronico) object;
        if ((this.nrocomprobante == null && other.nrocomprobante != null) || (this.nrocomprobante != null && !this.nrocomprobante.equals(other.nrocomprobante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sunat.gob.org.entidades.ComprobanteElectronico[ nrocomprobante=" + nrocomprobante + " ]";
    }
    
}
