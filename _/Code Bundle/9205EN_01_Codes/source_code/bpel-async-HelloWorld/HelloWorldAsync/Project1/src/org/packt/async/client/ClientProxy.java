package org.packt.async.client;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamReader;

import org.apache.axiom.om.OMAbstractFactory; 
import org.apache.axiom.om.OMElement; 
import org.apache.axiom.om.OMFactory; 
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.OMXMLBuilderFactory;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axis2.addressing.AddressingConstants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.OperationClient;
import org.apache.axis2.client.Options; 
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.databinding.utils.BeanUtil;
import org.apache.axis2.transport.http.HTTPConstants;


import org.apache.axis2.util.StreamWrapper;

import org.apache.axis2.util.XMLUtils;

import org.packt.async.generated.Process;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class ClientProxy {
    
  public static boolean isFeedback= false;
    
   public static void main(String[] args) throws Exception { 

       ServiceClient client = new ServiceClient();
       Options opts = new Options(); 
       opts.setTo(new EndpointReference("http://medion:7001/soa-infra/services/default/HelloWordlAsync/helloworldasyncprocess_client_ep"));        
       opts.setAction("process"); 
       opts.setUseSeparateListener(true);
       client.engageModule("addressing");       
       client.setOptions(opts); 

       Process req= new Process();
       req.setInput("JURIJ");
       
       //System.out.println(createPayLoad(req));

       //client.sendReceiveNonBlocking(createPayLoad(req), new BPELCallback()); 
       client.sendReceiveNonBlocking(createPayLoad(req), new BPELCallback()); 
       
       System.out.println("send the message"); 
       while (!isFeedback) { 
           Thread.sleep(5000); 
           System.out.println("waiting ...."); 
       }        
       System.exit(0);

       
       
   } 

   public static OMElement createPayLoad(Process req) throws ParserConfigurationException,
                                                                  JAXBException,
                                                                  Exception { 
       
       DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
       dbf.setNamespaceAware(true);
       Document doc = dbf.newDocumentBuilder().newDocument();
              
       JAXBContext jc = JAXBContext.newInstance(Process.class);

       Marshaller marshaller = jc.createMarshaller();
       marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);       
       marshaller.marshal(req, doc);       


/*
       OMFactory fac = OMAbstractFactory.getOMFactory(); 
       OMNamespace omNs = fac.createOMNamespace( 
               "http://xmlns.oracle.com/HelloWorldAsync/HelloWordlAsync/HelloWorldAsyncProcess", ""); 
       OMElement method = fac.createOMElement("process", omNs); 
       OMElement value = fac.createOMElement("input", omNs); 
       method.addChild(value); 
       //value.setText("Jurij"); 
       value.setText("FAULT");
*/       
       return XMLUtils.toOM(doc.getDocumentElement()); 
   } 
}