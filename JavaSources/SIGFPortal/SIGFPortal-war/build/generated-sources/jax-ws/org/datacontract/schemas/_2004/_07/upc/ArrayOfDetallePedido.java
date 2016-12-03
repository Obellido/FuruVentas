
package org.datacontract.schemas._2004._07.upc;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfDetallePedido complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDetallePedido">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DetallePedido" type="{http://schemas.datacontract.org/2004/07/upc.ws}DetallePedido" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDetallePedido", propOrder = {
    "detallePedido"
})
public class ArrayOfDetallePedido {

    @XmlElement(name = "DetallePedido", nillable = true)
    protected List<DetallePedido> detallePedido;

    /**
     * Gets the value of the detallePedido property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detallePedido property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetallePedido().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetallePedido }
     * 
     * 
     */
    public List<DetallePedido> getDetallePedido() {
        if (detallePedido == null) {
            detallePedido = new ArrayList<DetallePedido>();
        }
        return this.detallePedido;
    }

}
