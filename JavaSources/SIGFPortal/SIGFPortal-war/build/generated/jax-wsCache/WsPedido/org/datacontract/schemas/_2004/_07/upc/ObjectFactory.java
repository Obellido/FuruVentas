
package org.datacontract.schemas._2004._07.upc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.upc package. 
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

    private final static QName _ArrayOfPedido_QNAME = new QName("http://schemas.datacontract.org/2004/07/upc.ws", "ArrayOfPedido");
    private final static QName _ArrayOfDetallePedido_QNAME = new QName("http://schemas.datacontract.org/2004/07/upc.ws", "ArrayOfDetallePedido");
    private final static QName _Pedido_QNAME = new QName("http://schemas.datacontract.org/2004/07/upc.ws", "Pedido");
    private final static QName _DetallePedido_QNAME = new QName("http://schemas.datacontract.org/2004/07/upc.ws", "DetallePedido");
    private final static QName _PedidoNombreCliente_QNAME = new QName("http://schemas.datacontract.org/2004/07/upc.ws", "NombreCliente");
    private final static QName _PedidoDetalle_QNAME = new QName("http://schemas.datacontract.org/2004/07/upc.ws", "Detalle");
    private final static QName _DetallePedidoNombreProducto_QNAME = new QName("http://schemas.datacontract.org/2004/07/upc.ws", "NombreProducto");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.upc
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ArrayOfPedido }
     * 
     */
    public ArrayOfPedido createArrayOfPedido() {
        return new ArrayOfPedido();
    }

    /**
     * Create an instance of {@link Pedido }
     * 
     */
    public Pedido createPedido() {
        return new Pedido();
    }

    /**
     * Create an instance of {@link DetallePedido }
     * 
     */
    public DetallePedido createDetallePedido() {
        return new DetallePedido();
    }

    /**
     * Create an instance of {@link ArrayOfDetallePedido }
     * 
     */
    public ArrayOfDetallePedido createArrayOfDetallePedido() {
        return new ArrayOfDetallePedido();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/upc.ws", name = "ArrayOfPedido")
    public JAXBElement<ArrayOfPedido> createArrayOfPedido(ArrayOfPedido value) {
        return new JAXBElement<ArrayOfPedido>(_ArrayOfPedido_QNAME, ArrayOfPedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfDetallePedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/upc.ws", name = "ArrayOfDetallePedido")
    public JAXBElement<ArrayOfDetallePedido> createArrayOfDetallePedido(ArrayOfDetallePedido value) {
        return new JAXBElement<ArrayOfDetallePedido>(_ArrayOfDetallePedido_QNAME, ArrayOfDetallePedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/upc.ws", name = "Pedido")
    public JAXBElement<Pedido> createPedido(Pedido value) {
        return new JAXBElement<Pedido>(_Pedido_QNAME, Pedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetallePedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/upc.ws", name = "DetallePedido")
    public JAXBElement<DetallePedido> createDetallePedido(DetallePedido value) {
        return new JAXBElement<DetallePedido>(_DetallePedido_QNAME, DetallePedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/upc.ws", name = "NombreCliente", scope = Pedido.class)
    public JAXBElement<String> createPedidoNombreCliente(String value) {
        return new JAXBElement<String>(_PedidoNombreCliente_QNAME, String.class, Pedido.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfDetallePedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/upc.ws", name = "Detalle", scope = Pedido.class)
    public JAXBElement<ArrayOfDetallePedido> createPedidoDetalle(ArrayOfDetallePedido value) {
        return new JAXBElement<ArrayOfDetallePedido>(_PedidoDetalle_QNAME, ArrayOfDetallePedido.class, Pedido.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/upc.ws", name = "NombreProducto", scope = DetallePedido.class)
    public JAXBElement<String> createDetallePedidoNombreProducto(String value) {
        return new JAXBElement<String>(_DetallePedidoNombreProducto_QNAME, String.class, DetallePedido.class, value);
    }

}
