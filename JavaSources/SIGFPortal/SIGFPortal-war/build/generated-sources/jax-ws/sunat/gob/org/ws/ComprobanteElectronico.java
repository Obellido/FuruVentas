
package sunat.gob.org.ws;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para comprobanteElectronico complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="comprobanteElectronico">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anticipos" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="descuentos" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="fechaemision" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechavencimiento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="nrocomprobante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="observacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ruccliente" type="{http://ws.org.gob.sunat/}empresa" minOccurs="0"/>
 *         &lt;element name="rucempresa" type="{http://ws.org.gob.sunat/}empresa" minOccurs="0"/>
 *         &lt;element name="subtotalventa" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipomoneda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valorventa" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "comprobanteElectronico", propOrder = {
    "anticipos",
    "descuentos",
    "fechaemision",
    "fechavencimiento",
    "nrocomprobante",
    "observacion",
    "ruccliente",
    "rucempresa",
    "subtotalventa",
    "tipo",
    "tipomoneda",
    "valorventa"
})
public class ComprobanteElectronico {

    protected BigDecimal anticipos;
    protected BigDecimal descuentos;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaemision;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechavencimiento;
    protected String nrocomprobante;
    protected String observacion;
    protected Empresa ruccliente;
    protected Empresa rucempresa;
    protected BigDecimal subtotalventa;
    protected String tipo;
    protected String tipomoneda;
    protected BigDecimal valorventa;

    /**
     * Obtiene el valor de la propiedad anticipos.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAnticipos() {
        return anticipos;
    }

    /**
     * Define el valor de la propiedad anticipos.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAnticipos(BigDecimal value) {
        this.anticipos = value;
    }

    /**
     * Obtiene el valor de la propiedad descuentos.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDescuentos() {
        return descuentos;
    }

    /**
     * Define el valor de la propiedad descuentos.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDescuentos(BigDecimal value) {
        this.descuentos = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaemision.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaemision() {
        return fechaemision;
    }

    /**
     * Define el valor de la propiedad fechaemision.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaemision(XMLGregorianCalendar value) {
        this.fechaemision = value;
    }

    /**
     * Obtiene el valor de la propiedad fechavencimiento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechavencimiento() {
        return fechavencimiento;
    }

    /**
     * Define el valor de la propiedad fechavencimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechavencimiento(XMLGregorianCalendar value) {
        this.fechavencimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad nrocomprobante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNrocomprobante() {
        return nrocomprobante;
    }

    /**
     * Define el valor de la propiedad nrocomprobante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNrocomprobante(String value) {
        this.nrocomprobante = value;
    }

    /**
     * Obtiene el valor de la propiedad observacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * Define el valor de la propiedad observacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservacion(String value) {
        this.observacion = value;
    }

    /**
     * Obtiene el valor de la propiedad ruccliente.
     * 
     * @return
     *     possible object is
     *     {@link Empresa }
     *     
     */
    public Empresa getRuccliente() {
        return ruccliente;
    }

    /**
     * Define el valor de la propiedad ruccliente.
     * 
     * @param value
     *     allowed object is
     *     {@link Empresa }
     *     
     */
    public void setRuccliente(Empresa value) {
        this.ruccliente = value;
    }

    /**
     * Obtiene el valor de la propiedad rucempresa.
     * 
     * @return
     *     possible object is
     *     {@link Empresa }
     *     
     */
    public Empresa getRucempresa() {
        return rucempresa;
    }

    /**
     * Define el valor de la propiedad rucempresa.
     * 
     * @param value
     *     allowed object is
     *     {@link Empresa }
     *     
     */
    public void setRucempresa(Empresa value) {
        this.rucempresa = value;
    }

    /**
     * Obtiene el valor de la propiedad subtotalventa.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubtotalventa() {
        return subtotalventa;
    }

    /**
     * Define el valor de la propiedad subtotalventa.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubtotalventa(BigDecimal value) {
        this.subtotalventa = value;
    }

    /**
     * Obtiene el valor de la propiedad tipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define el valor de la propiedad tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

    /**
     * Obtiene el valor de la propiedad tipomoneda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipomoneda() {
        return tipomoneda;
    }

    /**
     * Define el valor de la propiedad tipomoneda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipomoneda(String value) {
        this.tipomoneda = value;
    }

    /**
     * Obtiene el valor de la propiedad valorventa.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorventa() {
        return valorventa;
    }

    /**
     * Define el valor de la propiedad valorventa.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorventa(BigDecimal value) {
        this.valorventa = value;
    }

}
