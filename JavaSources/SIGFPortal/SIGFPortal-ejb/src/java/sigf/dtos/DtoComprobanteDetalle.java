/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigf.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author w8
 */
public class DtoComprobanteDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nrocomprobante;
    private Integer secuencia;
    private String codigo;
    private Integer cantidadunidad;
    private String unidadmedida;
    private String descripcion;
    private BigDecimal valorunitario;
    private BigDecimal descuento;
    private BigDecimal valorventa;

    public DtoComprobanteDetalle() {
    }

    public DtoComprobanteDetalle(String nrocomprobante, Integer secuencia, String codigo, Integer cantidadunidad, String unidadmedida, String descripcion, BigDecimal valorunitario, BigDecimal descuento, BigDecimal valorventa) {
        this.nrocomprobante = nrocomprobante;
        this.secuencia = secuencia;
        this.codigo = codigo;
        this.cantidadunidad = cantidadunidad;
        this.unidadmedida = unidadmedida;
        this.descripcion = descripcion;
        this.valorunitario = valorunitario;
        this.descuento = descuento;
        this.valorventa = valorventa;
    }

    public String getNrocomprobante() {
        return nrocomprobante;
    }

    public void setNrocomprobante(String nrocomprobante) {
        this.nrocomprobante = nrocomprobante;
    }

    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCantidadunidad() {
        return cantidadunidad;
    }

    public void setCantidadunidad(Integer cantidadunidad) {
        this.cantidadunidad = cantidadunidad;
    }

    public String getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(String unidadmedida) {
        this.unidadmedida = unidadmedida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(BigDecimal valorunitario) {
        this.valorunitario = valorunitario;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getValorventa() {
        return valorventa;
    }

    public void setValorventa(BigDecimal valorventa) {
        this.valorventa = valorventa;
    }

    
}
