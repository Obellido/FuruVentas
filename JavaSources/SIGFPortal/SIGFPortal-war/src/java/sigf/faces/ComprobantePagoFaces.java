/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigf.faces;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.bind.JAXBElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.WebServiceRef;
import org.datacontract.schemas._2004._07.upc.ArrayOfDetallePedido;
import org.datacontract.schemas._2004._07.upc.DetallePedido;
import org.datacontract.schemas._2004._07.upc.Pedido;
import org.tempuri.WsPedido;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import sigf.beans.Cliente;
import sigf.beans.Comprobantepago;
import sigf.beans.Miscelaneos;
import sigf.dtos.DtoComprobanteDetalle;
import sigf.services.ComprobantePagoServicesLocal;
import sigf.services.MiscelaneosServicesLocal;
import ws.cliente.WSPedidos;
import ws.cliente.WSSunat;

/**
 *
 * @author w8
 */
@ManagedBean
@SessionScoped
public class ComprobantePagoFaces {
    
    @EJB
    private ComprobantePagoServicesLocal comprobanteService;
    
    @EJB
    private MiscelaneosServicesLocal miscelaneoService;
    
    private List<Comprobantepago> comprobantes;
    private Comprobantepago selectedComprobante;
    private Comprobantepago comprobante;
    private List<Miscelaneos> tipodocumentos;
    private List<Miscelaneos> monedas;
    private List<Miscelaneos> tipopagos;
    
    private String sinregisstros;
    private String nropedido;
    
    public String listarComprobantes() {
        System.out.println("sigf.faces.ComprobantePagoFaces.obtenerComprobantes()");
        
        comprobantes = comprobanteService.listarComprobantes();
        return "comprobantepagolistado.xhtml";
    }
    
    public String nuevoComprobante() {
        System.out.println("sigf.faces.ComprobantePagoFaces.nuevoComprobante()");
        
        comprobante = new Comprobantepago();
        comprobante.setCodmoneda(new Miscelaneos("TM", "SO"));
        comprobante.setCodcliente(new Cliente());
        comprobante.setCodtipodocumento(new Miscelaneos("TD", "F"));
        comprobante.setCodtipopago(new Miscelaneos("TP", "CO"));
        
        comprobante.setEstado("P");
        comprobante.setFechahora(new Date());
        comprobante.setFechavencimiento(new Date());
        comprobante.setImportepagado(BigDecimal.ZERO);
        comprobante.setImporteporpagar(BigDecimal.ZERO);
        comprobante.setImportetotal(BigDecimal.ZERO);
        
        listarTipoPago();
        listarTipoComprobante();
        ListarMoneda();
        
        return "comprobantepagonuevo.xhtml";
    }
    
    public String grabarComprobante() throws ParserConfigurationException, TransformerException {
        
        String respuesta = comprobanteService.registrarComprobante(comprobante);
        if (respuesta == null) {
            
        } else {
            // enviamos el archivo

            //Generamos el comporbante electronico
            byte[] xmlFile = generarXmlToSunat("comprobante", comprobante);
            respuesta = new WSSunat().generarComprobanteElectronico("10466683227", "ABCDEFG", xmlFile, "comprobante");
            
        }
        
        return listarComprobantes();
    }
    
    private byte[] generarXmlToSunat(String nombreArchivo, Comprobantepago comprobante) throws ParserConfigurationException, TransformerConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, nombreArchivo, null);
        document.setXmlVersion("1.0");
        
        Element raiz = document.getDocumentElement();
        Element itemNode = document.createElement("COMPROBANTEELECTRONICO");

        //Nodo NROCOMPROBANTE
        Element node1 = document.createElement("NROCOMPROBANTE");
        Text nodeValue1 = document.createTextNode(comprobante.getNrocomprobante());
        node1.appendChild(nodeValue1);

        //Nodo TIPO
        Element node2 = document.createElement("TIPO");
        Text nodeValue2 = document.createTextNode(comprobante.getCodtipopago().getCodelemento());
        node2.appendChild(nodeValue2);

        //Nodo FECHAVENCIMIENTO
        Element node3 = document.createElement("FECHAVENCIMIENTO");
        DateFormat fechaVen = new SimpleDateFormat("dd/MM/yyyy");
        String fechavenc = fechaVen.format(comprobante.getFechavencimiento());
        Text nodeValue3 = document.createTextNode(fechavenc);
        node3.appendChild(nodeValue3);

        //Nodo FECHAEMISION
        Element node4 = document.createElement("FECHAEMISION");
        DateFormat fechaEmi = new SimpleDateFormat("dd/MM/yyyy");
        String fechaemic = fechaEmi.format(comprobante.getFechahora());
        Text nodeValue4 = document.createTextNode(fechaemic);
        node4.appendChild(nodeValue4);

        //Nodo RUCEMPRESA
        Element node5 = document.createElement("RUCEMPRESA");
        Text nodeValue5 = document.createTextNode("10466683227");
        node5.appendChild(nodeValue5);

        //Nodo RUCCLIENTE
        Element node6 = document.createElement("RUCCLIENTE");
        Text nodeValue6 = document.createTextNode(comprobante.getCodcliente().getRuc());
        node6.appendChild(nodeValue6);

        //Nodo TIPOMONEDA
        Element node7 = document.createElement("TIPOMONEDA");
        Text nodeValue7 = document.createTextNode(comprobante.getCodmoneda().getCodelemento());
        node7.appendChild(nodeValue7);

        //Nodo OBSERVACION
        Element node8 = document.createElement("OBSERVACION");
        Text nodeValue8 = document.createTextNode("Factura sin observacciones");
        node8.appendChild(nodeValue8);

        //Nodo SUBTOTALVENTA
        Element node9 = document.createElement("SUBTOTALVENTA");
        Text nodeValue9 = document.createTextNode(comprobante.getImporteporpagar() + "");
        node9.appendChild(nodeValue9);

        //Nodo ANTICIPOS
        Element node10 = document.createElement("ANTICIPOS");
        Text nodeValue10 = document.createTextNode("00.00");
        node10.appendChild(nodeValue10);

        //Nodo DESCUENTOS
        Element node11 = document.createElement("DESCUENTOS");
        Text nodeValue11 = document.createTextNode("00.00");
        node11.appendChild(nodeValue11);

        //Nodo VALORVENTA
        Element node12 = document.createElement("TOTALVENTA");
        Text nodeValue12 = document.createTextNode(comprobante.getImportetotal() + "");
        node12.appendChild(nodeValue12);
        
        itemNode.appendChild(node1);
        itemNode.appendChild(node2);
        itemNode.appendChild(node3);
        itemNode.appendChild(node4);
        itemNode.appendChild(node5);
        itemNode.appendChild(node6);
        itemNode.appendChild(node7);
        itemNode.appendChild(node8);
        itemNode.appendChild(node9);
        itemNode.appendChild(node10);
        itemNode.appendChild(node11);
        itemNode.appendChild(node12);

        //append itemNode to raiz
        raiz.appendChild(itemNode);

        //Generate XML
        Source source = new DOMSource(document);
        //Indicamos donde lo queremos almacenar
        Result result = new StreamResult(new java.io.File(nombreArchivo + ".xml")); //nombre del archivo
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
        
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        StreamResult result2 = new StreamResult(bos);
        transformer.transform(source, result2);
        byte[] contenido = bos.toByteArray();
        return contenido;
    }
    
    public String obtenerPedido() {
        System.out.println("sigf.faces.ComprobantePagoFaces.obtenerPedido()");
        if (nropedido != null) {
            // Obtenemos la informacion del pedido por servicio web
            Pedido pedido = new WSPedidos().obtenerPedido(Integer.parseInt(nropedido));

            //Datos del servicio pedido
            comprobante.setCodcliente(new Cliente("10466683227", "Operadores SAC"));
            comprobante.setDetalle(new ArrayList<DtoComprobanteDetalle>());
            
            for (DetallePedido obj : pedido.getDetalle().getValue().getDetallePedido()) {
                comprobante.getDetalle().add(new DtoComprobanteDetalle("00001", obj.getPedidoId(), obj.getCodigoProducto().toString(), obj.getCantidad().intValue(), "Bolsa", obj.getNombreProducto().getValue().toString(), new BigDecimal(obj.getPrecioU(), MathContext.DECIMAL64), new BigDecimal(   0.0), new BigDecimal(obj.getSubTotal(), MathContext.DECIMAL64)));
            }

            //calculamos las cantidades
            for (DtoComprobanteDetalle det : comprobante.getDetalle()) {
                comprobante.setImportetotal(comprobante.getImportetotal().add(det.getValorventa()));
            }
            comprobante.setImporteporpagar(comprobante.getImportetotal().subtract(comprobante.getImportepagado()));
            
            System.out.println("Pedido " + pedido.getCodigo());
        }
        
        return null;
    }

    /**
     * Creates a new instance of ComprobantePagoFaces
     */
    public ComprobantePagoFaces() {
    }
    
    public List<Comprobantepago> getComprobantes() {
        return comprobantes;
    }
    
    public void setComprobantes(List<Comprobantepago> comprobantes) {
        this.comprobantes = comprobantes;
    }
    
    public Comprobantepago getSelectedComprobante() {
        return selectedComprobante;
    }
    
    public void setSelectedComprobante(Comprobantepago selectedComprobante) {
        this.selectedComprobante = selectedComprobante;
    }
    
    public Comprobantepago getComprobante() {
        return comprobante;
    }
    
    public void setComprobante(Comprobantepago comprobante) {
        this.comprobante = comprobante;
    }
    
    public List<Miscelaneos> getTipodocumentos() {
        return tipodocumentos;
    }
    
    public void setTipodocumentos(List<Miscelaneos> tipodocumentos) {
        this.tipodocumentos = tipodocumentos;
    }
    
    public List<Miscelaneos> getMonedas() {
        return monedas;
    }
    
    public void setMonedas(List<Miscelaneos> monedas) {
        this.monedas = monedas;
    }
    
    public List<Miscelaneos> getTipopagos() {
        return tipopagos;
    }
    
    public void setTipopagos(List<Miscelaneos> tipopagos) {
        this.tipopagos = tipopagos;
    }
    
    public String getSinregisstros() {
        sinregisstros = "No existen registros.";
        return sinregisstros;
    }
    
    public void setSinregisstros(String sinregisstros) {
        this.sinregisstros = sinregisstros;
    }
    
    private void listarTipoPago() {
        tipopagos = miscelaneoService.listarTipoPago();
    }
    
    private void listarTipoComprobante() {
        tipodocumentos = miscelaneoService.listarTipoComprobante();
    }
    
    private void ListarMoneda() {
        monedas = miscelaneoService.listarMoneda();
    }
    
    public String getNropedido() {
        return nropedido;
    }
    
    public void setNropedido(String nropedido) {
        this.nropedido = nropedido;
    }
    
}
