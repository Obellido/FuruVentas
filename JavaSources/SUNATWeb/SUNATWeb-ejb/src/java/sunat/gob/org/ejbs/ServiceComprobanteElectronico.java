/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sunat.gob.org.ejbs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import sunat.gob.org.entidades.ComprobanteElectronico;
import sunat.gob.org.entidades.Empresa;

/**
 *
 * @author w8
 */
@Stateless
public class ServiceComprobanteElectronico implements ServiceComprobanteElectronicoLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "sunatepm")
    private EntityManager em;

    @EJB
    ServiceSeguridadLocal seguridadLocal;

    @Override
    public String generarComprobante(String ruc, String clave, byte[] contenidoXML, String nombreXML) {
        String retorno = null;
        ComprobanteElectronico comprobanteElectronico = null;
        if (seguridadLocal.obtenerPorAutenticidad(ruc, clave)==null) {
            retorno = "El ruc o la clave son incorrectos.";
            return retorno;
        }

        comprobanteElectronico = convetirXMLaComprobante(contenidoXML, nombreXML);
        if (comprobanteElectronico == null) {
            retorno = "Se encontró un error al obtener los datos del XML. Verifique su archivo.";
            return retorno;
        }

        comprobanteElectronico = generarComprobante(comprobanteElectronico);
        if (comprobanteElectronico == null) {
            retorno = "Se encontró un error al grabar el comprobante. Comuniquese con SUNAT.";
            return retorno;
        }

        retorno = "OK";

        return retorno;
    }

    @Override
    public ComprobanteElectronico generarComprobante(ComprobanteElectronico comprobanteElectronico) {

        try {
            em.persist(comprobanteElectronico);
        } catch (Exception ex) {
            Logger.getLogger(ServiceComprobanteElectronico.class.getName()).log(Level.SEVERE, null, ex);
            comprobanteElectronico = null;
        }
        return comprobanteElectronico;
    }

    @Override
    public ComprobanteElectronico convetirXMLaComprobante(byte[] contenidoXML, String nombreXML) {

        ComprobanteElectronico resultado = new ComprobanteElectronico();
        resultado.setRuccliente(new Empresa());
        resultado.setRucempresa(new Empresa());

        ByteArrayInputStream bais = new ByteArrayInputStream(contenidoXML);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        try {
            db = dbf.newDocumentBuilder();

            Document xmlDocument = db.parse(bais);
            xmlDocument.getDocumentElement().normalize();

            NodeList listaNodos = xmlDocument.getDocumentElement().getElementsByTagName("COMPROBANTEELECTRONICO").item(0).getChildNodes();
            resultado.setNrocomprobante(listaNodos.item(0).getChildNodes().item(0).getNodeValue());
            resultado.setTipo(listaNodos.item(1).getChildNodes().item(0).getNodeValue());
            resultado.setFechavencimiento(format.parse(listaNodos.item(2).getChildNodes().item(0).getNodeValue()));
            resultado.setFechaemision(format.parse(listaNodos.item(3).getChildNodes().item(0).getNodeValue()));
            resultado.getRucempresa().setRuc(listaNodos.item(4).getChildNodes().item(0).getNodeValue());
            resultado.getRuccliente().setRuc(listaNodos.item(5).getChildNodes().item(0).getNodeValue());
            resultado.setTipomoneda(listaNodos.item(6).getChildNodes().item(0).getNodeValue());
            resultado.setObservacion(listaNodos.item(7).getChildNodes().item(0).getNodeValue());
            resultado.setSubtotalventa(new BigDecimal(listaNodos.item(8).getChildNodes().item(0).getNodeValue().replaceAll(",", "")));
            resultado.setAnticipos(new BigDecimal(listaNodos.item(9).getChildNodes().item(0).getNodeValue().replaceAll(",", "")));
            resultado.setDescuentos(new BigDecimal(listaNodos.item(10).getChildNodes().item(0).getNodeValue().replaceAll(",", "")));
            resultado.setValorventa(new BigDecimal(listaNodos.item(11).getChildNodes().item(0).getNodeValue().replaceAll(",", "")));

        } catch (SAXException | IOException | ParserConfigurationException | ParseException ex) {
            Logger.getLogger(ServiceComprobanteElectronico.class.getName()).log(Level.SEVERE, null, ex);
            resultado = null;
        }

        return resultado;
    }
}
