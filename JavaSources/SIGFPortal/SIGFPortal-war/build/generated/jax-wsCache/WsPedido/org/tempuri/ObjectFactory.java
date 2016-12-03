
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.datacontract.schemas._2004._07.upc.ArrayOfPedido;
import org.datacontract.schemas._2004._07.upc.Pedido;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
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

    private final static QName _ObtenerResponseObtenerResult_QNAME = new QName("http://tempuri.org/", "ObtenerResult");
    private final static QName _RegistrarData_QNAME = new QName("http://tempuri.org/", "Data");
    private final static QName _ListarResponseListarResult_QNAME = new QName("http://tempuri.org/", "ListarResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Listar }
     * 
     */
    public Listar createListar() {
        return new Listar();
    }

    /**
     * Create an instance of {@link ListarResponse }
     * 
     */
    public ListarResponse createListarResponse() {
        return new ListarResponse();
    }

    /**
     * Create an instance of {@link ObtenerResponse }
     * 
     */
    public ObtenerResponse createObtenerResponse() {
        return new ObtenerResponse();
    }

    /**
     * Create an instance of {@link Registrar }
     * 
     */
    public Registrar createRegistrar() {
        return new Registrar();
    }

    /**
     * Create an instance of {@link RegistrarResponse }
     * 
     */
    public RegistrarResponse createRegistrarResponse() {
        return new RegistrarResponse();
    }

    /**
     * Create an instance of {@link Obtener }
     * 
     */
    public Obtener createObtener() {
        return new Obtener();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ObtenerResult", scope = ObtenerResponse.class)
    public JAXBElement<Pedido> createObtenerResponseObtenerResult(Pedido value) {
        return new JAXBElement<Pedido>(_ObtenerResponseObtenerResult_QNAME, Pedido.class, ObtenerResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Data", scope = Registrar.class)
    public JAXBElement<Pedido> createRegistrarData(Pedido value) {
        return new JAXBElement<Pedido>(_RegistrarData_QNAME, Pedido.class, Registrar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ListarResult", scope = ListarResponse.class)
    public JAXBElement<ArrayOfPedido> createListarResponseListarResult(ArrayOfPedido value) {
        return new JAXBElement<ArrayOfPedido>(_ListarResponseListarResult_QNAME, ArrayOfPedido.class, ListarResponse.class, value);
    }

}
