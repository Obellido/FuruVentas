/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigf.faces;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sigf.beans.Comprobantepago;
import sigf.beans.Guiaremision;
import sigf.services.ComprobantePagoServicesLocal;
import sigf.services.GuiaRemisionServicesLocal;

/**
 *
 * @author w8
 */
@ManagedBean
@SessionScoped
public class GuiaRemisionFaces {
    

    @EJB
    private GuiaRemisionServicesLocal guiaService;
    
    @EJB
    private ComprobantePagoServicesLocal comprobanteService;
    
    private List<Guiaremision> guias;
    private Guiaremision guia;
    private Comprobantepago comprobante;
    
    private String sinregisstros;
    
    public String obtenerComprobante(){
        comprobante = comprobanteService.obtenerPorId(guia.getNrocomprobante().getNrocomprobante());
        return null;
    }
    
    public String listar(){
        System.out.println("sigf.faces.GuiaRemisionFaces.listar()");
        guias = guiaService.listarGuiaRemision();
        return "guiaremisionlistado.xhtml";
    }
    
    public String nuevo(){
        guia = new Guiaremision();
        guia.setNrocomprobante(new Comprobantepago());
        guia.setFlgEntregado("N");
        
        System.out.println("sigf.faces.GuiaRemisionFaces.nuevo()");
        
        return "guiaremisionnuevo.xhtml";
    }
    
     public String guardar(){
       
        System.out.println("sigf.faces.GuiaRemisionFaces.guardar()");
        guiaService.registrarGuiaRemision(guia);
        
        return listar();
    }
    
    /**
     * Creates a new instance of ComprobantePagoFaces
     */
    public GuiaRemisionFaces() {
    }

    public String getSinregisstros() {
        sinregisstros = "No existen registros.";
        return sinregisstros;
    }

    public void setSinregisstros(String sinregisstros) {
        this.sinregisstros = sinregisstros;
    }

    public List<Guiaremision> getGuias() {
        return guias;
    }

    public void setGuias(List<Guiaremision> guias) {
        this.guias = guias;
    }

    public Guiaremision getGuia() {
        return guia;
    }

    public void setGuia(Guiaremision guia) {
        this.guia = guia;
    }

    public Comprobantepago getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobantepago comprobante) {
        this.comprobante = comprobante;
    }
    
    
}
