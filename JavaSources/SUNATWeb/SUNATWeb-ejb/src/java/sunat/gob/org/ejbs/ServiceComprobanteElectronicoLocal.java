/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sunat.gob.org.ejbs;

import javax.ejb.Local;
import sunat.gob.org.entidades.ComprobanteElectronico;

/**
 *
 * @author w8
 */
@Local
public interface ServiceComprobanteElectronicoLocal {
    
    public String generarComprobante(String ruc, String clave, byte[] contenidoXML, String nombreXML);

    public ComprobanteElectronico generarComprobante(ComprobanteElectronico comprobanteElectronico);

    public ComprobanteElectronico convetirXMLaComprobante(byte[] contenidoXML, String nombreXML);
    
}
