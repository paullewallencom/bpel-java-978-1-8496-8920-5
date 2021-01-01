package org.packt.ws.jaxws.async.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Future;

import javax.xml.namespace.QName;

import org.packt.ws.jaxws.async.ObjectFactory;
import org.packt.ws.jaxws.async.ReservationConfirmationType;
import org.packt.ws.jaxws.async.ReservationService;
import org.packt.ws.jaxws.async.ReservationType;

public class AsyncClient {

	public AsyncClient()
	{
		
	}
	

	public void callAsyncService() {
		QName serviceName = new QName("http://org.packt.ws.jaxws.async/reservation", "DoReservationAsyncImplService");
		ReservationService svc= null;
		try {
			svc= new ReservationService(new URL("http://localhost:9999/axis2/services/DoReservationAsyncImplService?wsdl"), serviceName);
						
		} catch (MalformedURLException e) {		
			e.printStackTrace();
		}
		
		ReservationServiceCallbackHandler aHandler= new ReservationServiceCallbackHandler();
		ReservationType input= new ObjectFactory().createReservationType();
		input.setName("Jurij");
		input.setLastname("Laznik");
		input.setHotelName("Plaza");
		input.setNoOfNights(2);
		input.setPrice(100);
		
		System.out.println(">> Sending the following input");
		System.out.println("   Name             : Jurij");
		System.out.println("   Lastname         : Laznik");
		System.out.println("   Hotel name       : Plaza");
		System.out.println("   Number of nights : " + 2);
		System.out.println("   Price            : " + 100);
		
		if (svc != null) {			
			try {
				Future<?> resp = svc.getDoReservationAsyncPort().reserveAsync(input, aHandler);
				Thread.sleep(1000);
				
				while (!resp.isDone()) {
	                Thread.sleep(5000);
	                System.out.println("sleeping");
	            }
				
				ReservationConfirmationType response = aHandler.getOutput();
	            
	            if (response != null) {
	                String responseStr = response.getConfirmationId();	                
	                System.out.println(">> Confirmation id is: " + responseStr);
	            }
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		AsyncClient client = new AsyncClient();
		client.callAsyncService();
    }
}
