/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sunat.gob.rg.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import sunat.gob.org.ejbs.ServiceComprobanteElectronico;
import sunat.gob.org.ejbs.ServiceComprobanteElectronicoRemoto;

/**
 *
 * @author w8
 */
public class XMLTest {
    
    @EJB
    private ServiceComprobanteElectronicoRemoto serviceComprobanteElectronico;
    
     public static void main(String[] args) {
         System.out.println("sunat.gob.rg.test.XMLTest.main()");
         
        String nombre_archivo = "comprobantexml";
        ArrayList key = new ArrayList();
        ArrayList value = new ArrayList();

        key.add("opcion1");
        value.add("22");

        key.add("opcion2");
        value.add("22");

        key.add("opcion3");
        value.add("22");

        key.add("opcion4");
        value.add("25");
        
         try {
             generate(nombre_archivo, key, value);
         } catch (Exception ex) {
             Logger.getLogger(XMLTest.class.getName()).log(Level.SEVERE, null, ex);
         }
        
     }
    
     public static void generate(String name, ArrayList<String> key,ArrayList<String> value) throws Exception{

        if(key.isEmpty() || value.isEmpty() || key.size()!=value.size()){
            System.out.println("ERROR empty ArrayList");
        }else{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, name, null);
            document.setXmlVersion("1.0");
            
            Element raiz = document.getDocumentElement();
            Element itemNode = document.createElement("COMPROBANTEELECTRONICO");
            
            //Nodo NROCOMPROBANTE
            Element node1 = document.createElement("NROCOMPROBANTE"); 
            Text nodeValue1 = document.createTextNode("F001");
            node1.appendChild(nodeValue1);  
            
            //Nodo TIPO
            Element node2 = document.createElement("TIPO"); 
            Text nodeValue2 = document.createTextNode("F");
            node2.appendChild(nodeValue2);  
            
            //Nodo FECHAVENCIMIENTO
            Element node3 = document.createElement("FECHAVENCIMIENTO"); 
            Text nodeValue3 = document.createTextNode("12/12/2016 10:30:00");
            node3.appendChild(nodeValue3);
            
             //Nodo FECHAEMISION
            Element node4 = document.createElement("FECHAEMISION"); 
            Text nodeValue4 = document.createTextNode("12/12/2016 10:30:00");
            node4.appendChild(nodeValue4);  
            
             //Nodo RUCEMPRESA
            Element node5 = document.createElement("RUCEMPRESA"); 
            Text nodeValue5 = document.createTextNode("11111111111");
            node5.appendChild(nodeValue5);  
            
             //Nodo RUCCLIENTE
            Element node6 = document.createElement("RUCCLIENTE"); 
            Text nodeValue6 = document.createTextNode("222222222222");
            node6.appendChild(nodeValue6);  
            
            //Nodo TIPOMONEDA
            Element node7 = document.createElement("TIPOMONEDA"); 
            Text nodeValue7 = document.createTextNode("SO");
            node7.appendChild(nodeValue7);  
            
            //Nodo OBSERVACION
            Element node8 = document.createElement("OBSERVACION"); 
            Text nodeValue8 = document.createTextNode("Factura sin observacciones");
            node8.appendChild(nodeValue8);  
            
            //Nodo SUBTOTALVENTA
            Element node9 = document.createElement("SUBTOTALVENTA"); 
            Text nodeValue9 = document.createTextNode("2500.50");
            node9.appendChild(nodeValue9);  
            
            //Nodo ANTICIPOS
            Element node10 = document.createElement("ANTICIPOS"); 
            Text nodeValue10 = document.createTextNode("00.00");
            node10.appendChild(nodeValue10);  
            
            //Nodo DESCUENTOS
            Element node11 = document.createElement("DESCUENTOS"); 
            Text nodeValue11 = document.createTextNode("198.00");
            node11.appendChild(nodeValue11); 
            
            //Nodo VALORVENTA
            Element node12 = document.createElement("SUBTOTALVENTA"); 
            Text nodeValue12 = document.createTextNode("2302.50");
            node12.appendChild(nodeValue12);  
    
            itemNode.appendChild(node1);
            itemNode.appendChild(node2);
            itemNode.appendChild(node3);
            itemNode.appendChild(node4);
            itemNode.appendChild(node5);
            itemNode.appendChild(node6);
            itemNode.appendChild(node7);
            itemNode.appendChild(node8);
            itemNode.appendChild(node9);
            itemNode.appendChild(node10);
            itemNode.appendChild(node11);
            itemNode.appendChild(node12);
            
            //append itemNode to raiz
            raiz.appendChild(itemNode);
            
             //Generate XML
            Source source = new DOMSource(document);
            //Indicamos donde lo queremos almacenar
            Result result = new StreamResult(new java.io.File(name+".xml")); //nombre del archivo
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            StreamResult result2 = new StreamResult(bos);
            transformer.transform(source, result2);
            byte []contenido=bos.toByteArray();
            
            new ServiceComprobanteElectronico().generarComprobante("10101010", "123", contenido, name + ".xml");
        }
     }
  
}
