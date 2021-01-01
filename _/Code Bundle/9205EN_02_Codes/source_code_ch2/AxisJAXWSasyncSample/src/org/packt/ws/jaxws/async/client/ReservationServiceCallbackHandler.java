package org.packt.ws.jaxws.async.client;

import java.util.concurrent.ExecutionException;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import org.packt.ws.jaxws.async.ReservationConfirmationType;
import org.packt.ws.jaxws.async.jaxws.ReserveAsyncResponse;

public class ReservationServiceCallbackHandler implements AsyncHandler<ReservationConfirmationType> {
	private ReservationConfirmationType output;
	
	public ReservationConfirmationType getOutput() {
		return output;
	}

	@Override
	public void handleResponse(Response<ReservationConfirmationType> res) {
		// TODO Auto-generated method stub
		
		try {
			output= res.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
