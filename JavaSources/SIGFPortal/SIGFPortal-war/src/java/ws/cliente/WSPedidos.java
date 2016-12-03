/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.cliente;

import org.datacontract.schemas._2004._07.upc.Pedido;

/**
 *
 * @author w8
 */
public class WSPedidos {
    
     public Pedido obtenerPedido(Integer codigo) {

        System.out.println("ws.cliente.WSPedidos.obtenerPedido()");
       
        org.tempuri.WsPedido service = new org.tempuri.WsPedido();
        org.tempuri.IWsPedido port = service.getBasicHttpBindingIWsPedido();
        return port.obtener(codigo);
    }

}
