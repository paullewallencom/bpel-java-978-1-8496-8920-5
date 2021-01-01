import javax.xml.bind.JAXBContext;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import oracle.xml.parser.v2.XMLElement;

public class Facade {

    public static Object createFacade(String context, XMLElement doc) throws Exception {
        
        JAXBContext jaxbContext;
        Object zz= null;

        try {
            jaxbContext = JAXBContext.newInstance(context);
            
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            zz = unmarshaller.unmarshal(doc);

            return zz;
        } catch (JAXBException e) {
            throw new Exception("Cannot create facade from the XML content.");
        }        
    }
}
