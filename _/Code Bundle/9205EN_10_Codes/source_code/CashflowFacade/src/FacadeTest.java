import facade.Facade;

import java.io.File;
import java.io.FileReader;

import java.io.IOException;

import java.util.List;


import javax.xml.bind.JAXBElement;

import oracle.xml.parser.v2.DOMParser;

import oracle.xml.parser.v2.XMLDocument;
import oracle.xml.parser.v2.XMLParseException;

/*import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
*/

import org.packt.cashflow.facade.CashflowsType;

import org.packt.cashflow.facade.PrincipalExchange;

import org.xml.sax.SAXException;

public class FacadeTest {
    
    XMLDocument document;
    
    public FacadeTest() {
    }

    public static void main(String[] args) {
        String[] args2 = { FacadeTest.class.getName() };
//        org.junit.runner.JUnitCore.main(args2);
    }

//    @Before
    public void setUp() throws Exception {
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
        document=domParser.getDocument();  
            
    }

//    @After
    public void tearDown() throws Exception {
    }

    /**
     * @see Facade#createFacade(String,XMLElement)
     */
//    @Test
    public void testCreateFacade() {
        Object zz;

        try {
            zz = Facade.createFacade("org.packt.cashflow.facade", document.getSrcRoot());
            JAXBElement<CashflowsType>  cf = (JAXBElement<CashflowsType>)zz;
            CashflowsType cfs= cf.getValue();
            
            List<PrincipalExchange> lcf= cfs.getPrincipalExchange();
            
            for (PrincipalExchange pe: lcf) {
                System.out.println(pe.getId()); 
            }                    
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
