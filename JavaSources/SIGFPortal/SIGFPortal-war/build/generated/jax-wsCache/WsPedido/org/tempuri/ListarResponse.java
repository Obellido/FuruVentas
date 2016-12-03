
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.upc.ArrayOfPedido;


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
 *         &lt;element name="ListarResult" type="{http://schemas.datacontract.org/2004/07/upc.ws}ArrayOfPedido" minOccurs="0"/>
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
    "listarResult"
})
@XmlRootElement(name = "ListarResponse")
public class ListarResponse {

    @XmlElementRef(name = "ListarResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfPedido> listarResult;

    /**
     * Obtiene el valor de la propiedad listarResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPedido }{@code >}
     *     
     */
    public JAXBElement<ArrayOfPedido> getListarResult() {
        return listarResult;
    }

    /**
     * Define el valor de la propiedad listarResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPedido }{@code >}
     *     
     */
    public void setListarResult(JAXBElement<ArrayOfPedido> value) {
        this.listarResult = value;
    }

}
