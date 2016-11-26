/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigf.beans;

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
@Table(name = "tb_comprobantepago_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComprobantepagoDetalle.findAll", query = "SELECT t FROM ComprobantepagoDetalle t")
    , @NamedQuery(name = "ComprobantepagoDetalle.findByNrocomprobante", query = "SELECT t FROM ComprobantepagoDetalle t WHERE t.tbComprobantepagoDetallePK.nrocomprobante = :nrocomprobante")
    , @NamedQuery(name = "ComprobantepagoDetalle.findByCorrelativo", query = "SELECT t FROM ComprobantepagoDetalle t WHERE t.tbComprobantepagoDetallePK.correlativo = :correlativo")
    , @NamedQuery(name = "ComprobantepagoDetalle.findByCodprod", query = "SELECT t FROM ComprobantepagoDetalle t WHERE t.codprod = :codprod")
    , @NamedQuery(name = "ComprobantepagoDetalle.findByCantidad", query = "SELECT t FROM ComprobantepagoDetalle t WHERE t.cantidad = :cantidad")
    , @NamedQuery(name = "ComprobantepagoDetalle.findByUnidad", query = "SELECT t FROM ComprobantepagoDetalle t WHERE t.unidad = :unidad")
    , @NamedQuery(name = "ComprobantepagoDetalle.findByPreciobase", query = "SELECT t FROM ComprobantepagoDetalle t WHERE t.preciobase = :preciobase")
    , @NamedQuery(name = "ComprobantepagoDetalle.findByImpuesto", query = "SELECT t FROM ComprobantepagoDetalle t WHERE t.impuesto = :impuesto")
    , @NamedQuery(name = "ComprobantepagoDetalle.findByDescuento", query = "SELECT t FROM ComprobantepagoDetalle t WHERE t.descuento = :descuento")
    , @NamedQuery(name = "ComprobantepagoDetalle.findByPrecioneto", query = "SELECT t FROM ComprobantepagoDetalle t WHERE t.precioneto = :precioneto")})
public class ComprobantepagoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComprobantepagoDetallePK tbComprobantepagoDetallePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codprod")
    private String codprod;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Size(max = 2)
    @Column(name = "unidad")
    private String unidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preciobase")
    private BigDecimal preciobase;
    @Column(name = "impuesto")
    private BigDecimal impuesto;
    @Column(name = "descuento")
    private BigDecimal descuento;
    @Column(name = "precioneto")
    private BigDecimal precioneto;
    @JoinColumn(name = "nrocomprobante", referencedColumnName = "nrocomprobante", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Comprobantepago tbComprobantepago;

    public ComprobantepagoDetalle() {
    }

    public ComprobantepagoDetalle(ComprobantepagoDetallePK tbComprobantepagoDetallePK) {
        this.tbComprobantepagoDetallePK = tbComprobantepagoDetallePK;
    }

    public ComprobantepagoDetalle(ComprobantepagoDetallePK tbComprobantepagoDetallePK, String codprod) {
        this.tbComprobantepagoDetallePK = tbComprobantepagoDetallePK;
        this.codprod = codprod;
    }

    public ComprobantepagoDetalle(String nrocomprobante, int correlativo) {
        this.tbComprobantepagoDetallePK = new ComprobantepagoDetallePK(nrocomprobante, correlativo);
    }

    public ComprobantepagoDetallePK getComprobantepagoDetallePK() {
        return tbComprobantepagoDetallePK;
    }

    public void setComprobantepagoDetallePK(ComprobantepagoDetallePK tbComprobantepagoDetallePK) {
        this.tbComprobantepagoDetallePK = tbComprobantepagoDetallePK;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public BigDecimal getPreciobase() {
        return preciobase;
    }

    public void setPreciobase(BigDecimal preciobase) {
        this.preciobase = preciobase;
    }

    public BigDecimal getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(BigDecimal impuesto) {
        this.impuesto = impuesto;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getPrecioneto() {
        return precioneto;
    }

    public void setPrecioneto(BigDecimal precioneto) {
        this.precioneto = precioneto;
    }

    public Comprobantepago getTbComprobantepago() {
        return tbComprobantepago;
    }

    public void setTbComprobantepago(Comprobantepago tbComprobantepago) {
        this.tbComprobantepago = tbComprobantepago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbComprobantepagoDetallePK != null ? tbComprobantepagoDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobantepagoDetalle)) {
            return false;
        }
        ComprobantepagoDetalle other = (ComprobantepagoDetalle) object;
        if ((this.tbComprobantepagoDetallePK == null && other.tbComprobantepagoDetallePK != null) || (this.tbComprobantepagoDetallePK != null && !this.tbComprobantepagoDetallePK.equals(other.tbComprobantepagoDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sigf.beans.ComprobantepagoDetalle[ tbComprobantepagoDetallePK=" + tbComprobantepagoDetallePK + " ]";
    }
    
}
