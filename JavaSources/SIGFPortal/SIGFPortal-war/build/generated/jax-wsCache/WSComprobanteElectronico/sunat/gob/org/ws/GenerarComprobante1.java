
package sunat.gob.org.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para generarComprobante_1 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="generarComprobante_1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://ws.org.gob.sunat/}comprobanteElectronico" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "generarComprobante_1", propOrder = {
    "comprobanteElectronico"
})
public class GenerarComprobante1 {

    @XmlElement(namespace = "http://ws.org.gob.sunat/")
    protected ComprobanteElectronico comprobanteElectronico;

    /**
     * Obtiene el valor de la propiedad comprobanteElectronico.
     * 
     * @return
     *     possible object is
     *     {@link ComprobanteElectronico }
     *     
     */
    public ComprobanteElectronico getComprobanteElectronico() {
        return comprobanteElectronico;
    }

    /**
     * Define el valor de la propiedad comprobanteElectronico.
     * 
     * @param value
     *     allowed object is
     *     {@link ComprobanteElectronico }
     *     
     */
    public void setComprobanteElectronico(ComprobanteElectronico value) {
        this.comprobanteElectronico = value;
    }

}
