
package org.packt.ws.jaxws.async;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.packt.ws.jaxws.async package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ReservationEl_QNAME = new QName("http://org.packt.ws.jaxws.async/elts", "ReservationEl");
    private final static QName _ReservationConfirmationEl_QNAME = new QName("http://org.packt.ws.jaxws.async/elts", "ReservationConfirmationEl");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.packt.ws.jaxws.async
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReservationConfirmationType }
     * 
     */
    public ReservationConfirmationType createReservationConfirmationType() {
        return new ReservationConfirmationType();
    }

    /**
     * Create an instance of {@link ReservationType }
     * 
     */
    public ReservationType createReservationType() {
        return new ReservationType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://org.packt.ws.jaxws.async/elts", name = "ReservationEl")
    public JAXBElement<ReservationType> createReservationEl(ReservationType value) {
        return new JAXBElement<ReservationType>(_ReservationEl_QNAME, ReservationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservationConfirmationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://org.packt.ws.jaxws.async/elts", name = "ReservationConfirmationEl")
    public JAXBElement<ReservationConfirmationType> createReservationConfirmationEl(ReservationConfirmationType value) {
        return new JAXBElement<ReservationConfirmationType>(_ReservationConfirmationEl_QNAME, ReservationConfirmationType.class, null, value);
    }

}
