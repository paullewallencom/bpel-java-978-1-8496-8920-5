package org.packt.ws.jaxws.async;

import java.util.UUID;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


@WebService(name = "DoReservationAsync", targetNamespace = "http://org.packt.ws.jaxws.async/reservation")
@SOAPBinding(style = javax.jws.soap.SOAPBinding.Style.RPC)
public class DoReservationAsyncImpl  {
	
	/*
	@WebMethod(operationName="reserve")
	public Response<ReservationConfirmationType> reserveAsync(ReservationType payload) {
		// TODO Auto-generated method stub
		return null;
	}
	 */
	/*
	 @WebMethod(operationName="reserve")
	    public Future<?> reserveAsync(
	        @WebParam(name = "ReservationEl", targetNamespace = "http://org.packt.ws.jaxws.async/elts", partName = "payload")
	        ReservationType payload,
	        @WebParam(name = "reserveResponse", targetNamespace = "", partName = "asyncHandler")
	        AsyncHandler<ReservationConfirmationType> asyncHandler) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	
	@WebMethod
	@WebResult(name = "ReservationConfirmationEl", targetNamespace = "http://org.packt.ws.jaxws.async/elts", partName = "payload")  
	public ReservationConfirmationType reserve( ReservationType payload) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ReservationConfirmationType resp= new ReservationConfirmationType();
		resp.setConfirmationId(UUID.randomUUID().toString());
		
		return resp;
	}
	
	
}
