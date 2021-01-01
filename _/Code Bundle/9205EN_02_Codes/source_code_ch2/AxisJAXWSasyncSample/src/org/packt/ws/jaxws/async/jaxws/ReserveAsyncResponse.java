
package org.packt.ws.jaxws.async.jaxws;

import java.util.concurrent.Future;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "reserveResponse", namespace = "http://org.packt.ws.jaxws.async/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reserveResponse", namespace = "http://org.packt.ws.jaxws.async/")
public class ReserveAsyncResponse {

    @XmlElement(name = "return", namespace = "")
    private Future _return;

    /**
     * 
     * @return
     *     returns Future
     */
    public Future getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Future _return) {
        this._return = _return;
    }

}
