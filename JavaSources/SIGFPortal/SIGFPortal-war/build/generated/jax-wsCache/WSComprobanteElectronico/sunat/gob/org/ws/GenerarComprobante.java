
package sunat.gob.org.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para generarComprobante complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="generarComprobante">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ruc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contenidoXML" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="nombreXML" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "generarComprobante", propOrder = {
    "ruc",
    "clave",
    "contenidoXML",
    "nombreXML"
})
public class GenerarComprobante {

    protected String ruc;
    protected String clave;
    @XmlElementRef(name = "contenidoXML", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> contenidoXML;
    protected String nombreXML;

    /**
     * Obtiene el valor de la propiedad ruc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuc() {
        return ruc;
    }

    /**
     * Define el valor de la propiedad ruc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuc(String value) {
        this.ruc = value;
    }

    /**
     * Obtiene el valor de la propiedad clave.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClave() {
        return clave;
    }

    /**
     * Define el valor de la propiedad clave.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClave(String value) {
        this.clave = value;
    }

    /**
     * Obtiene el valor de la propiedad contenidoXML.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getContenidoXML() {
        return contenidoXML;
    }

    /**
     * Define el valor de la propiedad contenidoXML.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setContenidoXML(JAXBElement<byte[]> value) {
        this.contenidoXML = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreXML.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreXML() {
        return nombreXML;
    }

    /**
     * Define el valor de la propiedad nombreXML.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreXML(String value) {
        this.nombreXML = value;
    }

}
