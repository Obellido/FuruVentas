
package org.tempuri;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import org.datacontract.schemas._2004._07.upc.ArrayOfPedido;
import org.datacontract.schemas._2004._07.upc.Pedido;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IWsPedido", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    com.microsoft.schemas._2003._10.serialization.ObjectFactory.class,
    org.datacontract.schemas._2004._07.upc.ObjectFactory.class,
    org.tempuri.ObjectFactory.class
})
public interface IWsPedido {


    /**
     * 
     * @param codigo
     * @return
     *     returns org.datacontract.schemas._2004._07.upc.Pedido
     */
    @WebMethod(operationName = "Obtener", action = "http://tempuri.org/IWsPedido/Obtener")
    @WebResult(name = "ObtenerResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "Obtener", targetNamespace = "http://tempuri.org/", className = "org.tempuri.Obtener")
    @ResponseWrapper(localName = "ObtenerResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ObtenerResponse")
    public Pedido obtener(
        @WebParam(name = "Codigo", targetNamespace = "http://tempuri.org/")
        Integer codigo);

    /**
     * 
     * @param data
     * @return
     *     returns java.lang.Integer
     */
    @WebMethod(operationName = "Registrar", action = "http://tempuri.org/IWsPedido/Registrar")
    @WebResult(name = "RegistrarResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "Registrar", targetNamespace = "http://tempuri.org/", className = "org.tempuri.Registrar")
    @ResponseWrapper(localName = "RegistrarResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.RegistrarResponse")
    public Integer registrar(
        @WebParam(name = "Data", targetNamespace = "http://tempuri.org/")
        Pedido data);

    /**
     * 
     * @return
     *     returns org.datacontract.schemas._2004._07.upc.ArrayOfPedido
     */
    @WebMethod(operationName = "Listar", action = "http://tempuri.org/IWsPedido/Listar")
    @WebResult(name = "ListarResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "Listar", targetNamespace = "http://tempuri.org/", className = "org.tempuri.Listar")
    @ResponseWrapper(localName = "ListarResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ListarResponse")
    public ArrayOfPedido listar();

}