
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.upc.Pedido;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ObtenerResult" type="{http://schemas.datacontract.org/2004/07/upc.ws}Pedido" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "obtenerResult"
})
@XmlRootElement(name = "ObtenerResponse")
public class ObtenerResponse {

    @XmlElementRef(name = "ObtenerResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<Pedido> obtenerResult;

    /**
     * Obtiene el valor de la propiedad obtenerResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Pedido }{@code >}
     *     
     */
    public JAXBElement<Pedido> getObtenerResult() {
        return obtenerResult;
    }

    /**
     * Define el valor de la propiedad obtenerResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Pedido }{@code >}
     *     
     */
    public void setObtenerResult(JAXBElement<Pedido> value) {
        this.obtenerResult = value;
    }

}
