/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sunat.gob.org.ejbs;

import javax.ejb.Remote;

/**
 *
 * @author w8
 */
@Remote
public interface ServiceSeguridadRemoto {

    public boolean isautenticado(String ruc, String clave);
    
}
