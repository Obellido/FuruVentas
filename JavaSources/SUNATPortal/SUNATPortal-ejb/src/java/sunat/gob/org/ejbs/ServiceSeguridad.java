/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sunat.gob.org.ejbs;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author w8
 */
@Stateless
public class ServiceSeguridad implements ServiceSeguridadRemoto {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "suntapem")
    private EntityManager em;

    @Override
    public boolean isautenticado(String ruc, String clave){
        
        boolean resultado = false;
        
        Query query = em.createQuery("findByRucClave");
        System.out.println("obtener Usuario");
        
        if(query!=null){
            resultado=true;
        }
        
        return resultado;
        
    }
}
