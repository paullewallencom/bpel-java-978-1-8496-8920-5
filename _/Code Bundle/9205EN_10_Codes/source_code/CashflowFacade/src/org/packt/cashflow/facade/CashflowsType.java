
package org.packt.cashflow.facade;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 *
 *     This class defines the data for the events, when principal exchange occurs.
 *
 *
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CashflowsType", propOrder = { "principalExchange" })
public class CashflowsType {

    protected List<PrincipalExchange> principalExchange;

    /**
     * TEST prop Gets the value of the principalExchange property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the principalExchange property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrincipalExchange().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PrincipalExchange }
     *
     *
     */
    public List<PrincipalExchange> getPrincipalExchange() {
        if (principalExchange == null) {
            principalExchange = new ArrayList<PrincipalExchange>();
        }
        return this.principalExchange;
    }

}
