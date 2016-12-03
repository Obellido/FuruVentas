/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sunat.gob.org.ejbs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sunat.gob.org.entidades.Empresa;

/**
 *
 * @author w8
 */
@Stateless
public class ServiceSeguridad implements ServiceSeguridadLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "sunatepm")
    private EntityManager em;

    @Override
    public Empresa obtenerPorAutenticidad(String ruc, String clave){
        
        Empresa resultado = null;
        
        Query query = em.createQuery("select e from Empresa e where e.ruc = :ruc and e.clave = :clave");
        query.setParameter("ruc", ruc);
        query.setParameter("clave", clave);
        
        resultado = (Empresa) query.getSingleResult();
        
        return resultado;
        
    }
}
