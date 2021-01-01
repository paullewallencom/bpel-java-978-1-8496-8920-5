
package org.packt.ws.jaxws.async.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.ws.AsyncHandler;

@XmlRootElement(name = "reserve", namespace = "http://org.packt.ws.jaxws.async/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reserve", namespace = "http://org.packt.ws.jaxws.async/", propOrder = {
    "reservationEl",
    "reserveResponse"
})
public class ReserveAsync {

    @XmlElement(name = "ReservationEl", namespace = "http://org.packt.ws.jaxws.async/elts")
    private org.packt.ws.jaxws.async.ReservationType reservationEl;
    @XmlElement(name = "reserveResponse", namespace = "")
    private AsyncHandler reserveResponse;

    /**
     * 
     * @return
     *     returns ReservationType
     */
    public org.packt.ws.jaxws.async.ReservationType getReservationEl() {
        return this.reservationEl;
    }

    /**
     * 
     * @param reservationEl
     *     the value for the reservationEl property
     */
    public void setReservationEl(org.packt.ws.jaxws.async.ReservationType reservationEl) {
        this.reservationEl = reservationEl;
    }

    /**
     * 
     * @return
     *     returns AsyncHandler
     */
    public AsyncHandler getReserveResponse() {
        return this.reserveResponse;
    }

    /**
     * 
     * @param reserveResponse
     *     the value for the reserveResponse property
     */
    public void setReserveResponse(AsyncHandler reserveResponse) {
        this.reserveResponse = reserveResponse;
    }

}
