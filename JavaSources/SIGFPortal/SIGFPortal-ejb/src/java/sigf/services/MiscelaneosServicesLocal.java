/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigf.services;

import java.util.List;
import javax.ejb.Local;
import sigf.beans.Miscelaneos;

/**
 *
 * @author w8
 */
@Local
public interface MiscelaneosServicesLocal {

    public List<Miscelaneos> listarTipoComprobante();

    public List<Miscelaneos> listarTipoPago();

    public List<Miscelaneos> listarMoneda();

}
