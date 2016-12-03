/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigf.services;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import sigf.beans.Cliente;
import sigf.beans.Comprobantepago;
import sigf.beans.Miscelaneos;
import sigf.dtos.DtoComprobanteDetalle;

/**
 *
 * @author w8
 */
@Stateless
public class ComprobantePagoServices implements ComprobantePagoServicesLocal {

    
    @PersistenceContext(unitName = "sigfem")
    private EntityManager em;

    @Override
    public List<Comprobantepago> listarComprobantes() {
        List<Comprobantepago> resultado = null;

        Query query = em.createQuery("FROM Comprobantepago C");
        resultado = query.getResultList();

        return resultado;
    }

    @Override
    @Transactional
    public String registrarComprobante(Comprobantepago comprobante) {
        String resultado = null;

        try {
            resultado = validarregistrarComprobante(comprobante);
            if (resultado == null) {
                String correlativo = obtenerCorrelativo(comprobante.getCodtipodocumento());
                comprobante.setNrocomprobante(correlativo);
                em.persist(comprobante);
                return "OK";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }

    @Override
    public Comprobantepago obtenerPorNroPedido(String nropedido, Comprobantepago comprobante) {
        Comprobantepago retorno = comprobante;

        //Datos del servicio pedido
        retorno.setCodcliente(new Cliente("10466683227", "Operadores SAC"));
        retorno.setDetalle(new ArrayList<DtoComprobanteDetalle>());
        retorno.getDetalle().add(new DtoComprobanteDetalle("00001", 1, "PROD0001", 20, "KG", "Vidrio Templeado de 1/4", new BigDecimal(120.0), new BigDecimal(10.0), new BigDecimal(110.0)));
        retorno.getDetalle().add(new DtoComprobanteDetalle("00001", 2, "PROD0002", 10, "KG", "Vidrio por paquete", new BigDecimal(200.0), new BigDecimal(0.0), new BigDecimal(200.0)));
        retorno.getDetalle().add(new DtoComprobanteDetalle("00001", 3, "PROD0003", 10, "KG", "Silicona para vidrio", new BigDecimal(70.0), new BigDecimal(00.0), new BigDecimal(0.0)));
        retorno.getDetalle().add(new DtoComprobanteDetalle("00001", 4, "PROD0004", 30, "BL", "Bolsa de Adobe", new BigDecimal(40.0), new BigDecimal(0.0), new BigDecimal(40.0)));

        //calculamos las cantidades
        for (DtoComprobanteDetalle det : retorno.getDetalle()) {
            retorno.setImportetotal(retorno.getImportetotal().add(det.getValorventa()));
        }

        retorno.setImporteporpagar(retorno.getImportetotal().subtract(retorno.getImportepagado()));

        return retorno;
    }
    
    @Override
    public Comprobantepago obtenerPorId(String nroComprobante) {
        Comprobantepago retorno = null;

        Query query = em.createNamedQuery("Comprobantepago.findByNrocomprobante");
        query.setParameter("nrocomprobante", nroComprobante);
        
        retorno = (Comprobantepago) query.getSingleResult();
        return retorno;
    }


    @Override
    public String obtenerCorrelativo(Miscelaneos tipoDocumento) {

        String resultado = null;
        String maximo = null;
        Integer secuencia = 0;

        Query query = em.createQuery("select MAX(c.nrocomprobante) FROM Comprobantepago c where c.codtipodocumento = :tipodoc");
        query.setParameter("tipodoc", tipoDocumento);
        maximo = (query.getSingleResult() == null ? "" : query.getSingleResult().toString());

        if (maximo == "") {
            resultado = tipoDocumento.getCodelemento() + "001";
        } else {
            maximo = maximo.replace(tipoDocumento.getCodelemento(), "");
            secuencia = Integer.parseInt(maximo) + 1;
            resultado = tipoDocumento.getCodelemento() + String.format("%03d", secuencia);
        }

        return resultado;
    }

    @Override
    public String validarregistrarComprobante(Comprobantepago comprobante) {
        String resultado = null;

        //validar el monto 
        if ((comprobante.getImporteporpagar().add(comprobante.getImportepagado())).compareTo(comprobante.getImportetotal()) == -1) {
            resultado = "Debe cancelar el total del monto. El saldo es " + comprobante.getImportetotal().subtract(comprobante.getImportepagado());
        }

        return resultado;
    }

}
