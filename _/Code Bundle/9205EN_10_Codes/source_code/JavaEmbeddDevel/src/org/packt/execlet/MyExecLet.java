package org.packt.execlet;


import com.collaxa.cube.engine.ext.bpel.v1.nodes.BPELXExecLet;
import com.oracle.bpel.client.BPELFault;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import oracle.xml.parser.v2.DOMParser;
import oracle.xml.parser.v2.XMLDocument;
import oracle.xml.parser.v2.XMLParseException;

import org.xml.sax.SAXException;


public class MyExecLet extends BPELXExecLet {
    public MyExecLet() {
        super();
    }


    @Override
    public void addAuditTrailEntry(String string) {
        System.out.println(string);            
    }

    @Override
    public void addAuditTrailEntry(String string, Object object) {
        System.out.println("String value: " + string);
        if (object != null)
            System.out.println("Object value: " + object.toString());
        else
            System.out.println("Object value: NULL");
    }

    @Override
    public void addAuditTrailEntry(Throwable throwable) {
        throwable.printStackTrace();
    }
    
    
    
    
    @Override
    public void execute() throws BPELFault {
        super.execute();

/**
 * Below is the code we use in the BPEL_and_Java_2_0 BPEL process
 * Java_Embedding1 activity
 */         
try {
    oracle.xml.parser.v2.XMLElement input_cf= (oracle.xml.parser.v2.XMLElement)getVariableData("inputVariable","payload","/client:Cashflows");
    
    Object obj_cf = facade.Facade.createFacade("org.packt.cashflow.facade", input_cf);
    javax.xml.bind.JAXBElement<org.packt.cashflow.facade.CashflowsType>  cfs = (javax.xml.bind.JAXBElement<org.packt.cashflow.facade.CashflowsType>)obj_cf;
    org.packt.cashflow.facade.CashflowsType cf= cfs.getValue();
    
    java.util.List<org.packt.cashflow.facade.PrincipalExchange> princEx= cf.getPrincipalExchange();
    
    for (org.packt.cashflow.facade.PrincipalExchange pe: princEx) {
        addAuditTrailEntry("Received cashflow with id: " + pe.getId() + "\n" +
                           "   Unadj. Principal Exch. Date ...: " + pe.getUnadjustedPrincipalExchangeDate() + "\n" +
                           "   Adj. Principal Exch. Date .....: " + pe.getAdjustedPrincipalExchangeDate() + "\n" +                            
                           "   Discount factor ...............: " + pe.getDiscountFactor() + "\n" +
                           "   Principal Exch. Amount ........: " + pe.getPrincipalExchangeAmount() + "\n"                            
                           ); 
    }                    
    
} catch (Exception e) {
    e.printStackTrace();
    addAuditTrailEntry("Error in XML facade occured: " + e.getMessage()); 
}    
    
    
    }
  
    
    public static void main(String[] args) {
        MyExecLet test= new MyExecLet();
        test.execute();
        
        
    }

    @Override
    public Object getVariableData(String string, String string2,
                                  String string3) throws BPELFault {
        
        DOMParser domParser=new DOMParser();
        try {
            domParser.parse(new FileReader(new File("XmlTestDoc.xml")));
        } catch (XMLParseException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        XMLDocument document=domParser.getDocument();              
        
        return document.getSrcRoot();
    }
}
