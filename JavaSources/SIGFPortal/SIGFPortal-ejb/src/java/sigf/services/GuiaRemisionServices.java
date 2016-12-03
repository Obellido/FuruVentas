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
import sigf.beans.Guiaremision;

/**
 *
 * @author w8
 */
@Stateless
public class GuiaRemisionServices implements GuiaRemisionServicesLocal {

    @PersistenceContext(unitName = "sigfem")
    private EntityManager em;

    @Override
    public List<Guiaremision> listarGuiaRemision() {
        List<Guiaremision> resultado = null;

        Query query = em.createQuery("FROM Guiaremision G");
        resultado = query.getResultList();

        return resultado;
    }

    @Override
    public String registrarGuiaRemision(Guiaremision guiaremision) {
        String resultado = null;

        try {
                String correlativo = obtenerCorrelativo();
                guiaremision.setNroguia(correlativo);
                em.persist(guiaremision);
                return "OK";
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    private String obtenerCorrelativo() {
        String resultado = null;
        String maximo = null;
        Integer secuencia = 0;

        Query query = em.createQuery("select MAX(g.nroguia) FROM Guiaremision g");
        maximo = (query.getSingleResult() == null ? "" : query.getSingleResult().toString());

        if (maximo == "") {
            resultado = "00000001";
        } else {
            secuencia = Integer.parseInt(maximo) + 1;
            resultado = String.format("%07d", secuencia);
        }

        return resultado;
    }
}
