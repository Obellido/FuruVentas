/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sunat.gob.org.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author w8
 */
@Entity
@Table(name = "comprobante_electronico_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComprobanteElectronicoDetalle.findAll", query = "SELECT c FROM ComprobanteElectronicoDetalle c")
    , @NamedQuery(name = "ComprobanteElectronicoDetalle.findByNrocomprobante", query = "SELECT c FROM ComprobanteElectronicoDetalle c WHERE c.comprobanteElectronicoDetallePK.nrocomprobante = :nrocomprobante")
    , @NamedQuery(name = "ComprobanteElectronicoDetalle.findBySecuencia", query = "SELECT c FROM ComprobanteElectronicoDetalle c WHERE c.comprobanteElectronicoDetallePK.secuencia = :secuencia")
    , @NamedQuery(name = "ComprobanteElectronicoDetalle.findByCodigo", query = "SELECT c FROM ComprobanteElectronicoDetalle c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "ComprobanteElectronicoDetalle.findByCantidadunidad", query = "SELECT c FROM ComprobanteElectronicoDetalle c WHERE c.cantidadunidad = :cantidadunidad")
    , @NamedQuery(name = "ComprobanteElectronicoDetalle.findByMedida", query = "SELECT c FROM ComprobanteElectronicoDetalle c WHERE c.medida = :medida")
    , @NamedQuery(name = "ComprobanteElectronicoDetalle.findByDescripcion", query = "SELECT c FROM ComprobanteElectronicoDetalle c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "ComprobanteElectronicoDetalle.findByValorunitario", query = "SELECT c FROM ComprobanteElectronicoDetalle c WHERE c.valorunitario = :valorunitario")
    , @NamedQuery(name = "ComprobanteElectronicoDetalle.findByDescuento", query = "SELECT c FROM ComprobanteElectronicoDetalle c WHERE c.descuento = :descuento")
    , @NamedQuery(name = "ComprobanteElectronicoDetalle.findByValorventa", query = "SELECT c FROM ComprobanteElectronicoDetalle c WHERE c.valorventa = :valorventa")})
public class ComprobanteElectronicoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComprobanteElectronicoDetallePK comprobanteElectronicoDetallePK;
    @Size(max = 15)
    @Column(name = "codigo")
    private String codigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadunidad")
    private BigDecimal cantidadunidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "medida")
    private String medida;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorunitario")
    private BigDecimal valorunitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento")
    private BigDecimal descuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorventa")
    private BigDecimal valorventa;
    @JoinColumn(name = "nrocomprobante", referencedColumnName = "nrocomprobante", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ComprobanteElectronico comprobanteElectronico;

    public ComprobanteElectronicoDetalle() {
    }

    public ComprobanteElectronicoDetalle(ComprobanteElectronicoDetallePK comprobanteElectronicoDetallePK) {
        this.comprobanteElectronicoDetallePK = comprobanteElectronicoDetallePK;
    }

    public ComprobanteElectronicoDetalle(ComprobanteElectronicoDetallePK comprobanteElectronicoDetallePK, BigDecimal cantidadunidad, String medida, BigDecimal valorunitario, BigDecimal descuento, BigDecimal valorventa) {
        this.comprobanteElectronicoDetallePK = comprobanteElectronicoDetallePK;
        this.cantidadunidad = cantidadunidad;
        this.medida = medida;
        this.valorunitario = valorunitario;
        this.descuento = descuento;
        this.valorventa = valorventa;
    }

    public ComprobanteElectronicoDetalle(String nrocomprobante, int secuencia) {
        this.comprobanteElectronicoDetallePK = new ComprobanteElectronicoDetallePK(nrocomprobante, secuencia);
    }

    public ComprobanteElectronicoDetallePK getComprobanteElectronicoDetallePK() {
        return comprobanteElectronicoDetallePK;
    }

    public void setComprobanteElectronicoDetallePK(ComprobanteElectronicoDetallePK comprobanteElectronicoDetallePK) {
        this.comprobanteElectronicoDetallePK = comprobanteElectronicoDetallePK;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getCantidadunidad() {
        return cantidadunidad;
    }

    public void setCantidadunidad(BigDecimal cantidadunidad) {
        this.cantidadunidad = cantidadunidad;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(BigDecimal valorunitario) {
        this.valorunitario = valorunitario;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getValorventa() {
        return valorventa;
    }

    public void setValorventa(BigDecimal valorventa) {
        this.valorventa = valorventa;
    }

    public ComprobanteElectronico getComprobanteElectronico() {
        return comprobanteElectronico;
    }

    public void setComprobanteElectronico(ComprobanteElectronico comprobanteElectronico) {
        this.comprobanteElectronico = comprobanteElectronico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comprobanteElectronicoDetallePK != null ? comprobanteElectronicoDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobanteElectronicoDetalle)) {
            return false;
        }
        ComprobanteElectronicoDetalle other = (ComprobanteElectronicoDetalle) object;
        if ((this.comprobanteElectronicoDetallePK == null && other.comprobanteElectronicoDetallePK != null) || (this.comprobanteElectronicoDetallePK != null && !this.comprobanteElectronicoDetallePK.equals(other.comprobanteElectronicoDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sunat.gob.org.entidades.ComprobanteElectronicoDetalle[ comprobanteElectronicoDetallePK=" + comprobanteElectronicoDetallePK + " ]";
    }
    
}
