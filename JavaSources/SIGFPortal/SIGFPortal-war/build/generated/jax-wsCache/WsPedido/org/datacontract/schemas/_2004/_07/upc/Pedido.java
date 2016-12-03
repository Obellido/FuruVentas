
package org.datacontract.schemas._2004._07.upc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para Pedido complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Pedido">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Codigo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="CodigoCliente" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Detalle" type="{http://schemas.datacontract.org/2004/07/upc.ws}ArrayOfDetallePedido" minOccurs="0"/>
 *         &lt;element name="Fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="IGV" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="NombreCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubTotal" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Total" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Pedido", propOrder = {
    "codigo",
    "codigoCliente",
    "detalle",
    "fecha",
    "igv",
    "nombreCliente",
    "subTotal",
    "total"
})
public class Pedido {

    @XmlElement(name = "Codigo")
    protected Integer codigo;
    @XmlElement(name = "CodigoCliente")
    protected Integer codigoCliente;
    @XmlElementRef(name = "Detalle", namespace = "http://schemas.datacontract.org/2004/07/upc.ws", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfDetallePedido> detalle;
    @XmlElement(name = "Fecha")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    @XmlElement(name = "IGV")
    protected Double igv;
    @XmlElementRef(name = "NombreCliente", namespace = "http://schemas.datacontract.org/2004/07/upc.ws", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nombreCliente;
    @XmlElement(name = "SubTotal")
    protected Double subTotal;
    @XmlElement(name = "Total")
    protected Double total;

    /**
     * Obtiene el valor de la propiedad codigo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * Define el valor de la propiedad codigo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodigo(Integer value) {
        this.codigo = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoCliente.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    /**
     * Define el valor de la propiedad codigoCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodigoCliente(Integer value) {
        this.codigoCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad detalle.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDetallePedido }{@code >}
     *     
     */
    public JAXBElement<ArrayOfDetallePedido> getDetalle() {
        return detalle;
    }

    /**
     * Define el valor de la propiedad detalle.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDetallePedido }{@code >}
     *     
     */
    public void setDetalle(JAXBElement<ArrayOfDetallePedido> value) {
        this.detalle = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad igv.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIGV() {
        return igv;
    }

    /**
     * Define el valor de la propiedad igv.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIGV(Double value) {
        this.igv = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreCliente.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNombreCliente() {
        return nombreCliente;
    }

    /**
     * Define el valor de la propiedad nombreCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNombreCliente(JAXBElement<String> value) {
        this.nombreCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad subTotal.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSubTotal() {
        return subTotal;
    }

    /**
     * Define el valor de la propiedad subTotal.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSubTotal(Double value) {
        this.subTotal = value;
    }

    /**
     * Obtiene el valor de la propiedad total.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotal() {
        return total;
    }

    /**
     * Define el valor de la propiedad total.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotal(Double value) {
        this.total = value;
    }

}
