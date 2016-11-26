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

/**
 *
 * @author w8
 */
@Named(value = "guiaRemisionFaces")
@RequestScoped
public class GuiaRemisionFaces {
    

    private String sinregisstros;
    
    
    public String listar(){
        System.out.println("sigf.faces.GuiaRemisionFaces.listar()");
        
        return "guiaremisionlistado.xhtml";
    }
    
    public String nuevo(){
        System.out.println("sigf.faces.GuiaRemisionFaces.nuevo()");
        
       
        
        return "guiaremisionnuevo.xhtml";
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
    
}
