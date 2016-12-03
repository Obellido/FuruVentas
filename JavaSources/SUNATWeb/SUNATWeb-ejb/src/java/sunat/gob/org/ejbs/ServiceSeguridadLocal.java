/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sunat.gob.org.ejbs;

import javax.ejb.Local;
import javax.ejb.Remote;
import sunat.gob.org.entidades.Empresa;

/**
 *
 * @author w8
 */
@Local
public interface ServiceSeguridadLocal {

    public Empresa obtenerPorAutenticidad(String ruc, String clave);
    
}
