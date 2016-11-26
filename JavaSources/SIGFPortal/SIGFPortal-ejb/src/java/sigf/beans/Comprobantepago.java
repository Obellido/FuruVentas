/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigf.beans;

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
@Table(name = "tb_comprobantepago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comprobantepago.findAll", query = "SELECT t FROM Comprobantepago t")
    , @NamedQuery(name = "Comprobantepago.findByNrocomprobante", query = "SELECT t FROM Comprobantepago t WHERE t.nrocomprobante = :nrocomprobante")
    , @NamedQuery(name = "Comprobantepago.findByCodcliente", query = "SELECT t FROM Comprobantepago t WHERE t.codcliente = :codcliente")
    , @NamedQuery(name = "Comprobantepago.findByFechahora", query = "SELECT t FROM Comprobantepago t WHERE t.fechahora = :fechahora")
    , @NamedQuery(name = "Comprobantepago.findByEstado", query = "SELECT t FROM Comprobantepago t WHERE t.estado = :estado")
    , @NamedQuery(name = "Comprobantepago.findByFechavencimiento", query = "SELECT t FROM Comprobantepago t WHERE t.fechavencimiento = :fechavencimiento")
    , @NamedQuery(name = "Comprobantepago.findByImportepagado", query = "SELECT t FROM Comprobantepago t WHERE t.importepagado = :importepagado")
    , @NamedQuery(name = "Comprobantepago.findByImporteporpagar", query = "SELECT t FROM Comprobantepago t WHERE t.importeporpagar = :importeporpagar")
    , @NamedQuery(name = "Comprobantepago.findByImportetotal", query = "SELECT t FROM Comprobantepago t WHERE t.importetotal = :importetotal")})
public class Comprobantepago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "nrocomprobante")
    private String nrocomprobante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "codcliente")
    private String codcliente;
    @Column(name = "fechahora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahora;
    @Size(max = 2)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fechavencimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechavencimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "importepagado")
    private BigDecimal importepagado;
    @Column(name = "importeporpagar")
    private BigDecimal importeporpagar;
    @Column(name = "importetotal")
    private BigDecimal importetotal;
    @JoinColumn(name = "codmoneda", referencedColumnName = "codelemento")
    @ManyToOne(optional = false)
    private Miscelaneos codmoneda;
    @JoinColumn(name = "codtipodocumento", referencedColumnName = "codelemento")
    @ManyToOne(optional = false)
    private Miscelaneos codtipodocumento;
    @JoinColumn(name = "codtipopago", referencedColumnName = "codelemento")
    @ManyToOne(optional = false)
    private Miscelaneos codtipopago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbComprobantepago")
    private Collection<ComprobantepagoDetalle> tbComprobantepagoDetalleCollection;

    public Comprobantepago() {
    }

    public Comprobantepago(String nrocomprobante) {
        this.nrocomprobante = nrocomprobante;
    }

    public Comprobantepago(String nrocomprobante, String codcliente) {
        this.nrocomprobante = nrocomprobante;
        this.codcliente = codcliente;
    }

    public String getNrocomprobante() {
        return nrocomprobante;
    }

    public void setNrocomprobante(String nrocomprobante) {
        this.nrocomprobante = nrocomprobante;
    }

    public String getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(String codcliente) {
        this.codcliente = codcliente;
    }

    public Date getFechahora() {
        return fechahora;
    }

    public void setFechahora(Date fechahora) {
        this.fechahora = fechahora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public BigDecimal getImportepagado() {
        return importepagado;
    }

    public void setImportepagado(BigDecimal importepagado) {
        this.importepagado = importepagado;
    }

    public BigDecimal getImporteporpagar() {
        return importeporpagar;
    }

    public void setImporteporpagar(BigDecimal importeporpagar) {
        this.importeporpagar = importeporpagar;
    }

    public BigDecimal getImportetotal() {
        return importetotal;
    }

    public void setImportetotal(BigDecimal importetotal) {
        this.importetotal = importetotal;
    }

    public Miscelaneos getCodmoneda() {
        return codmoneda;
    }

    public void setCodmoneda(Miscelaneos codmoneda) {
        this.codmoneda = codmoneda;
    }

    public Miscelaneos getCodtipodocumento() {
        return codtipodocumento;
    }

    public void setCodtipodocumento(Miscelaneos codtipodocumento) {
        this.codtipodocumento = codtipodocumento;
    }

    public Miscelaneos getCodtipopago() {
        return codtipopago;
    }

    public void setCodtipopago(Miscelaneos codtipopago) {
        this.codtipopago = codtipopago;
    }

    @XmlTransient
    public Collection<ComprobantepagoDetalle> getComprobantepagoDetalleCollection() {
        return tbComprobantepagoDetalleCollection;
    }

    public void setComprobantepagoDetalleCollection(Collection<ComprobantepagoDetalle> tbComprobantepagoDetalleCollection) {
        this.tbComprobantepagoDetalleCollection = tbComprobantepagoDetalleCollection;
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
        if (!(object instanceof Comprobantepago)) {
            return false;
        }
        Comprobantepago other = (Comprobantepago) object;
        if ((this.nrocomprobante == null && other.nrocomprobante != null) || (this.nrocomprobante != null && !this.nrocomprobante.equals(other.nrocomprobante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sigf.beans.Comprobantepago[ nrocomprobante=" + nrocomprobante + " ]";
    }
    
}
