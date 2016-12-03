/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sunat.gob.org.ws;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import sunat.gob.org.ejbs.ServiceComprobanteElectronicoLocal;
import sunat.gob.org.entidades.ComprobanteElectronico;

/**
 *
 * @author w8
 */
@WebService(serviceName = "WSComprobanteElectronico")
@Stateless()
public class WSComprobanteElectronico {

    @EJB
    private ServiceComprobanteElectronicoLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "generarComprobante")
    public String generarComprobante(@WebParam(name = "ruc") String ruc, @WebParam(name = "clave") String clave, @WebParam(name = "contenidoXML") byte[] contenidoXML, @WebParam(name = "nombreXML") String nombreXML) {
        return ejbRef.generarComprobante(ruc, clave, contenidoXML, nombreXML);
    }

    @WebMethod(operationName = "generarComprobante_1")
    @RequestWrapper(className = "generarComprobante_1")
    @ResponseWrapper(className = "generarComprobante_1Response")
    public ComprobanteElectronico generarComprobante(@WebParam(name = "comprobanteElectronico") ComprobanteElectronico comprobanteElectronico) {
        return ejbRef.generarComprobante(comprobanteElectronico);
    }

    @WebMethod(operationName = "convetirXMLaComprobante")
    public ComprobanteElectronico convetirXMLaComprobante(@WebParam(name = "contenidoXML") byte[] contenidoXML, @WebParam(name = "nombreXML") String nombreXML) {
        return ejbRef.convetirXMLaComprobante(contenidoXML, nombreXML);
    }
    
}
