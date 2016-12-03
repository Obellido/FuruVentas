/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigf.services;

import java.util.List;
import javax.ejb.Local;
import sigf.beans.Comprobantepago;
import sigf.beans.Miscelaneos;

/**
 *
 * @author w8
 */
@Local
public interface ComprobantePagoServicesLocal {
 
    public List<Comprobantepago> listarComprobantes();
    
    public String registrarComprobante(Comprobantepago comprobante);

    public Comprobantepago obtenerPorNroPedido(String nropedido, Comprobantepago comprobante);

    public Comprobantepago obtenerPorId(String nroComprobante);

    public String obtenerCorrelativo(Miscelaneos tipoDocumento);
    
    public String validarregistrarComprobante(Comprobantepago comprobante);
    
}
