/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigf.services;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sigf.beans.Miscelaneos;

/**
 *
 * @author w8
 */
@Stateless
public class MiscelaneosServices implements MiscelaneosServicesLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "sigfem")
    private EntityManager em;

    public List<Miscelaneos> listarTipoComprobante() {
        List<Miscelaneos> resultado = new ArrayList<>();
        Query query = em.createNamedQuery("Miscelaneos.findByCodproceso");
        query.setParameter("codproceso", "TD");
        
        resultado = query.getResultList();

        return resultado;
    }

    public List<Miscelaneos> listarTipoPago() {
        List<Miscelaneos> resultado = new ArrayList<>();
        Query query = em.createNamedQuery("Miscelaneos.findByCodproceso");
        query.setParameter("codproceso", "TP");
        resultado = query.getResultList();
        return resultado;
    }

    public List<Miscelaneos> listarMoneda() {
        List<Miscelaneos> resultado = new ArrayList<>();
        Query query = em.createNamedQuery("Miscelaneos.findByCodproceso");
        query.setParameter("codproceso", "TM");
        resultado = query.getResultList();
        return resultado;
    }

}
