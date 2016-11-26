/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigf.faces;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import sigf.beans.Comprobantepago;
import sigf.beans.Miscelaneos;
import sigf.services.ComprobantePagoServicesLocal;
import sigf.services.MiscelaneosServicesLocal;

/**
 *
 * @author w8
 */
@Named(value = "comprobantePagoFaces")
@RequestScoped
public class ComprobantePagoFaces {

    @EJB
    private ComprobantePagoServicesLocal comprobanteService;

    @EJB
    private MiscelaneosServicesLocal miscelaneoService;

    private List<Comprobantepago> comprobantes;
    private Comprobantepago selectedComprobante;
    private Comprobantepago comprobante;
    private List<Miscelaneos> tipodocumentos;
    private List<Miscelaneos> monedas;
    private List<Miscelaneos> tipopagos;

    private String sinregisstros;

    public String listarComprobantes() {
        System.out.println("sigf.faces.ComprobantePagoFaces.obtenerComprobantes()");
       
        comprobantes = comprobanteService.listarComprobantes();
        return "comprobantepagolistado.xhtml";
    }

    public String nuevoComprobante() {
        System.out.println("sigf.faces.ComprobantePagoFaces.nuevoComprobante()");

        Miscelaneos tipomoneda = new Miscelaneos();
        tipomoneda.setCodproceso("TM");
        tipomoneda.setCodelemento("SO");

        Miscelaneos tipopago = new Miscelaneos();
        tipomoneda.setCodproceso("TP");
        tipomoneda.setCodelemento("CO");

        comprobante = new Comprobantepago();
        comprobante.setCodmoneda(tipomoneda);
        comprobante.setCodtipopago(tipopago);

        comprobante.setEstado("P");
        comprobante.setFechahora(new Date());
        comprobante.setImportepagado(BigDecimal.ZERO);
        comprobante.setImporteporpagar(BigDecimal.ZERO);
        comprobante.setImportetotal(BigDecimal.ZERO);
        
        listarTipoPago();
        listarTipoComprobante();
        ListarMoneda();

        return "comprobantepagonuevo.xhtml";
    }

    /**
     * Creates a new instance of ComprobantePagoFaces
     */
    public ComprobantePagoFaces() {
    }

    public List<Comprobantepago> getComprobantes() {
        return comprobantes;
    }

    public void setComprobantes(List<Comprobantepago> comprobantes) {
        this.comprobantes = comprobantes;
    }

    public Comprobantepago getSelectedComprobante() {
        return selectedComprobante;
    }

    public void setSelectedComprobante(Comprobantepago selectedComprobante) {
        this.selectedComprobante = selectedComprobante;
    }

    public Comprobantepago getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobantepago comprobante) {
        this.comprobante = comprobante;
    }

    public List<Miscelaneos> getTipodocumentos() {
        return tipodocumentos;
    }

    public void setTipodocumentos(List<Miscelaneos> tipodocumentos) {
        this.tipodocumentos = tipodocumentos;
    }

    public List<Miscelaneos> getMonedas() {
        return monedas;
    }

    public void setMonedas(List<Miscelaneos> monedas) {
        this.monedas = monedas;
    }

    public List<Miscelaneos> getTipopagos() {
        return tipopagos;
    }

    public void setTipopagos(List<Miscelaneos> tipopagos) {
        this.tipopagos = tipopagos;
    }

    public String getSinregisstros() {
        sinregisstros = "No existen registros.";
        return sinregisstros;
    }

    public void setSinregisstros(String sinregisstros) {
        this.sinregisstros = sinregisstros;
    }

    private void listarTipoPago() {
        tipopagos = miscelaneoService.listarTipoPago();
    }

    private void listarTipoComprobante() {
        tipodocumentos = miscelaneoService.listarTipoComprobante();
    }

    private void ListarMoneda() {
        monedas =  miscelaneoService.listarMoneda();
    }

}
