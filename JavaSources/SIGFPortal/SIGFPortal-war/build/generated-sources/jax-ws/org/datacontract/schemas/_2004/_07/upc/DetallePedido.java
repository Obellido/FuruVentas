
package org.datacontract.schemas._2004._07.upc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DetallePedido complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DetallePedido">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Cantidad" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="CodigoProducto" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="NombreProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PedidoId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PrecioU" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="SubTotal" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetallePedido", propOrder = {
    "cantidad",
    "codigoProducto",
    "nombreProducto",
    "pedidoId",
    "precioU",
    "subTotal"
})
public class DetallePedido {

    @XmlElement(name = "Cantidad")
    protected Double cantidad;
    @XmlElement(name = "CodigoProducto")
    protected Integer codigoProducto;
    @XmlElementRef(name = "NombreProducto", namespace = "http://schemas.datacontract.org/2004/07/upc.ws", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nombreProducto;
    @XmlElement(name = "PedidoId")
    protected Integer pedidoId;
    @XmlElement(name = "PrecioU")
    protected Double precioU;
    @XmlElement(name = "SubTotal")
    protected Double subTotal;

    /**
     * Obtiene el valor de la propiedad cantidad.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCantidad() {
        return cantidad;
    }

    /**
     * Define el valor de la propiedad cantidad.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCantidad(Double value) {
        this.cantidad = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoProducto.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    /**
     * Define el valor de la propiedad codigoProducto.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodigoProducto(Integer value) {
        this.codigoProducto = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreProducto.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNombreProducto() {
        return nombreProducto;
    }

    /**
     * Define el valor de la propiedad nombreProducto.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNombreProducto(JAXBElement<String> value) {
        this.nombreProducto = value;
    }

    /**
     * Obtiene el valor de la propiedad pedidoId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPedidoId() {
        return pedidoId;
    }

    /**
     * Define el valor de la propiedad pedidoId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPedidoId(Integer value) {
        this.pedidoId = value;
    }

    /**
     * Obtiene el valor de la propiedad precioU.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPrecioU() {
        return precioU;
    }

    /**
     * Define el valor de la propiedad precioU.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPrecioU(Double value) {
        this.precioU = value;
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

}
