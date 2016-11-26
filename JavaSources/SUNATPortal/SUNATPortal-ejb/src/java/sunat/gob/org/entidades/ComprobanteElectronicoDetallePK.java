/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sunat.gob.org.entidades;

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
public class ComprobanteElectronicoDetallePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "nrocomprobante")
    private String nrocomprobante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "secuencia")
    private int secuencia;

    public ComprobanteElectronicoDetallePK() {
    }

    public ComprobanteElectronicoDetallePK(String nrocomprobante, int secuencia) {
        this.nrocomprobante = nrocomprobante;
        this.secuencia = secuencia;
    }

    public String getNrocomprobante() {
        return nrocomprobante;
    }

    public void setNrocomprobante(String nrocomprobante) {
        this.nrocomprobante = nrocomprobante;
    }

    public int getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nrocomprobante != null ? nrocomprobante.hashCode() : 0);
        hash += (int) secuencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobanteElectronicoDetallePK)) {
            return false;
        }
        ComprobanteElectronicoDetallePK other = (ComprobanteElectronicoDetallePK) object;
        if ((this.nrocomprobante == null && other.nrocomprobante != null) || (this.nrocomprobante != null && !this.nrocomprobante.equals(other.nrocomprobante))) {
            return false;
        }
        if (this.secuencia != other.secuencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sunat.gob.org.entidades.ComprobanteElectronicoDetallePK[ nrocomprobante=" + nrocomprobante + ", secuencia=" + secuencia + " ]";
    }
    
}
