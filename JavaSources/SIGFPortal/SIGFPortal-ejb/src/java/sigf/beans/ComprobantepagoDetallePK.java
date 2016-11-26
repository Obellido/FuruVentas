/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigf.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author w8
 */
@Embeddable
public class ComprobantepagoDetallePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "nrocomprobante")
    private String nrocomprobante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "correlativo")
    private int correlativo;

    public ComprobantepagoDetallePK() {
    }

    public ComprobantepagoDetallePK(String nrocomprobante, int correlativo) {
        this.nrocomprobante = nrocomprobante;
        this.correlativo = correlativo;
    }

    public String getNrocomprobante() {
        return nrocomprobante;
    }

    public void setNrocomprobante(String nrocomprobante) {
        this.nrocomprobante = nrocomprobante;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nrocomprobante != null ? nrocomprobante.hashCode() : 0);
        hash += (int) correlativo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobantepagoDetallePK)) {
            return false;
        }
        ComprobantepagoDetallePK other = (ComprobantepagoDetallePK) object;
        if ((this.nrocomprobante == null && other.nrocomprobante != null) || (this.nrocomprobante != null && !this.nrocomprobante.equals(other.nrocomprobante))) {
            return false;
        }
        if (this.correlativo != other.correlativo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sigf.beans.ComprobantepagoDetallePK[ nrocomprobante=" + nrocomprobante + ", correlativo=" + correlativo + " ]";
    }
    
}
