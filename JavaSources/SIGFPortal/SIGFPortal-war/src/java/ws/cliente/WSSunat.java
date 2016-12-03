/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.cliente;

/**
 *
 * @author w8
 */
public class WSSunat {

    public WSSunat() {

    }

    public String generarComprobanteElectronico(String ruc, String clave, byte[] fileXml, String nombreXml) {

        System.out.println("ws.cliente.WSSunat.generarComprobanteElectronico()");
        try {
            sunat.gob.org.ws.WSComprobanteElectronico_Service service = new sunat.gob.org.ws.WSComprobanteElectronico_Service();
            sunat.gob.org.ws.WSComprobanteElectronico port = service.getWSComprobanteElectronicoPort();
            return port.generarComprobante(ruc, clave, fileXml, nombreXml);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
