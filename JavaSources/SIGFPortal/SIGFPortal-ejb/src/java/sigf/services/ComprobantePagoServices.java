/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigf.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sigf.beans.Comprobantepago;

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
    public String registraComprobantes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
