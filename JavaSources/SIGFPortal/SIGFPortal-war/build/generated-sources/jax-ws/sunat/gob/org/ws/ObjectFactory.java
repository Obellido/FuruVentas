
package sunat.gob.org.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sunat.gob.org.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ComprobanteElectronico_QNAME = new QName("http://ws.org.gob.sunat/", "comprobanteElectronico");
    private final static QName _ConvetirXMLaComprobante_QNAME = new QName("http://ws.org.gob.sunat/", "convetirXMLaComprobante");
    private final static QName _GenerarComprobante1_QNAME = new QName("http://ws.org.gob.sunat/", "generarComprobante_1");
    private final static QName _GenerarComprobante1Response_QNAME = new QName("http://ws.org.gob.sunat/", "generarComprobante_1Response");
    private final static QName _Empresa_QNAME = new QName("http://ws.org.gob.sunat/", "empresa");
    private final static QName _GenerarComprobante_QNAME = new QName("http://ws.org.gob.sunat/", "generarComprobante");
    private final static QName _GenerarComprobanteResponse_QNAME = new QName("http://ws.org.gob.sunat/", "generarComprobanteResponse");
    private final static QName _ConvetirXMLaComprobanteResponse_QNAME = new QName("http://ws.org.gob.sunat/", "convetirXMLaComprobanteResponse");
    private final static QName _GenerarComprobanteContenidoXML_QNAME = new QName("", "contenidoXML");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sunat.gob.org.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GenerarComprobante }
     * 
     */
    public GenerarComprobante createGenerarComprobante() {
        return new GenerarComprobante();
    }

    /**
     * Create an instance of {@link ConvetirXMLaComprobanteResponse }
     * 
     */
    public ConvetirXMLaComprobanteResponse createConvetirXMLaComprobanteResponse() {
        return new ConvetirXMLaComprobanteResponse();
    }

    /**
     * Create an instance of {@link GenerarComprobanteResponse }
     * 
     */
    public GenerarComprobanteResponse createGenerarComprobanteResponse() {
        return new GenerarComprobanteResponse();
    }

    /**
     * Create an instance of {@link GenerarComprobante1 }
     * 
     */
    public GenerarComprobante1 createGenerarComprobante1() {
        return new GenerarComprobante1();
    }

    /**
     * Create an instance of {@link GenerarComprobante1Response }
     * 
     */
    public GenerarComprobante1Response createGenerarComprobante1Response() {
        return new GenerarComprobante1Response();
    }

    /**
     * Create an instance of {@link ComprobanteElectronico }
     * 
     */
    public ComprobanteElectronico createComprobanteElectronico() {
        return new ComprobanteElectronico();
    }

    /**
     * Create an instance of {@link ConvetirXMLaComprobante }
     * 
     */
    public ConvetirXMLaComprobante createConvetirXMLaComprobante() {
        return new ConvetirXMLaComprobante();
    }

    /**
     * Create an instance of {@link Empresa }
     * 
     */
    public Empresa createEmpresa() {
        return new Empresa();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComprobanteElectronico }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.org.gob.sunat/", name = "comprobanteElectronico")
    public JAXBElement<ComprobanteElectronico> createComprobanteElectronico(ComprobanteElectronico value) {
        return new JAXBElement<ComprobanteElectronico>(_ComprobanteElectronico_QNAME, ComprobanteElectronico.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvetirXMLaComprobante }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.org.gob.sunat/", name = "convetirXMLaComprobante")
    public JAXBElement<ConvetirXMLaComprobante> createConvetirXMLaComprobante(ConvetirXMLaComprobante value) {
        return new JAXBElement<ConvetirXMLaComprobante>(_ConvetirXMLaComprobante_QNAME, ConvetirXMLaComprobante.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarComprobante1 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.org.gob.sunat/", name = "generarComprobante_1")
    public JAXBElement<GenerarComprobante1> createGenerarComprobante1(GenerarComprobante1 value) {
        return new JAXBElement<GenerarComprobante1>(_GenerarComprobante1_QNAME, GenerarComprobante1 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarComprobante1Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.org.gob.sunat/", name = "generarComprobante_1Response")
    public JAXBElement<GenerarComprobante1Response> createGenerarComprobante1Response(GenerarComprobante1Response value) {
        return new JAXBElement<GenerarComprobante1Response>(_GenerarComprobante1Response_QNAME, GenerarComprobante1Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Empresa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.org.gob.sunat/", name = "empresa")
    public JAXBElement<Empresa> createEmpresa(Empresa value) {
        return new JAXBElement<Empresa>(_Empresa_QNAME, Empresa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarComprobante }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.org.gob.sunat/", name = "generarComprobante")
    public JAXBElement<GenerarComprobante> createGenerarComprobante(GenerarComprobante value) {
        return new JAXBElement<GenerarComprobante>(_GenerarComprobante_QNAME, GenerarComprobante.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarComprobanteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.org.gob.sunat/", name = "generarComprobanteResponse")
    public JAXBElement<GenerarComprobanteResponse> createGenerarComprobanteResponse(GenerarComprobanteResponse value) {
        return new JAXBElement<GenerarComprobanteResponse>(_GenerarComprobanteResponse_QNAME, GenerarComprobanteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvetirXMLaComprobanteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.org.gob.sunat/", name = "convetirXMLaComprobanteResponse")
    public JAXBElement<ConvetirXMLaComprobanteResponse> createConvetirXMLaComprobanteResponse(ConvetirXMLaComprobanteResponse value) {
        return new JAXBElement<ConvetirXMLaComprobanteResponse>(_ConvetirXMLaComprobanteResponse_QNAME, ConvetirXMLaComprobanteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "contenidoXML", scope = GenerarComprobante.class)
    public JAXBElement<byte[]> createGenerarComprobanteContenidoXML(byte[] value) {
        return new JAXBElement<byte[]>(_GenerarComprobanteContenidoXML_QNAME, byte[].class, GenerarComprobante.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "contenidoXML", scope = ConvetirXMLaComprobante.class)
    public JAXBElement<byte[]> createConvetirXMLaComprobanteContenidoXML(byte[] value) {
        return new JAXBElement<byte[]>(_GenerarComprobanteContenidoXML_QNAME, byte[].class, ConvetirXMLaComprobante.class, ((byte[]) value));
    }

}
