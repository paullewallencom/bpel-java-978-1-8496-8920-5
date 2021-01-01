
package org.packt.cashflow.facade;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the org.packt.cashflow.facade package.
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

    private final static QName _Cashflows_QNAME =
        new QName("http://xmlns.oracle.com/BPELFacade/Banking_BPEL/Derivative_Cashflow",
                  "Cashflows");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.packt.cashflow.facade
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProcessingElement }
     *
     */
    public ProcessingElement createProcessingElement() {
        return new ProcessingElement();
    }

    /**
     * Create an instance of {@link CashflowsType }
     *
     */
    public CashflowsType createCashflowsType() {
        return new CashflowsType();
    }

    /**
     * Create an instance of {@link PrincipalExchange }
     *
     */
    public PrincipalExchange createPrincipalExchange() {
        return new PrincipalExchange();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CashflowsType }{@code >}}
     *
     */
    @XmlElementDecl(namespace =
                    "http://xmlns.oracle.com/BPELFacade/Banking_BPEL/Derivative_Cashflow",
                    name = "Cashflows")
    public JAXBElement<CashflowsType> createCashflows(CashflowsType value) {
        return new JAXBElement<CashflowsType>(_Cashflows_QNAME,
                                              CashflowsType.class, null,
                                              value);
    }

}
