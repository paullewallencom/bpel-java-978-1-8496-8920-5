package org.packt.async.client;

import java.util.Iterator;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.soap.SOAPBody;
import org.apache.axiom.soap.SOAPHeader;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.async.AxisCallback;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.databinding.utils.BeanUtil;
import org.apache.axis2.engine.DefaultObjectSupplier;

import org.packt.async.generated.ProcessResponse;


public class BPELCallback implements AxisCallback { 
        public void onMessage(MessageContext messageContext) { 
           SOAPHeader head= messageContext.getEnvelope().getHeader();
           SOAPBody msg = messageContext.getEnvelope().getBody();            
           
           System.out.println(head); 
           System.out.println(msg);         

           Iterator<?> it =msg.getChildrenWithLocalName("fault");
           if (it.hasNext()) {
               System.out.println("Fault occured: " + msg.getFirstElement().
                                getFirstElement().getText());
               return;
           }

            ProcessResponse responseBean;
            try {
                  responseBean =
                        (ProcessResponse)BeanUtil.                    
                   deserialize(ProcessResponse.class, msg.getFirstElement(),  
                               new DefaultObjectSupplier() , null);
                
                
                System.out.println( "result        >"  + responseBean.getResult() );
                System.out.println( "postal code   >"  + responseBean.getPostalcode() );
                System.out.println( "temperature   >"  + responseBean.getTemperature() );
                System.out.println( "      person.name     >"  + responseBean.getPerson().getName() );
                System.out.println( "      person.lastname >"  + responseBean.getPerson().getLastname() );
                
             } catch (AxisFault e) {
                e.printStackTrace();
                onError(e);
            }
    } 
    
       public void onFault(MessageContext messageContext) { 
           messageContext.getFailureReason().printStackTrace(); 
       } 
    
       public void onError(Exception e) { 
           System.err.println(e.getMessage()); 
       } 
    
       public void onComplete() { 
           System.out.println("Transmission finished.");                       
           ClientProxy.isFeedback =true;
       } 
} 