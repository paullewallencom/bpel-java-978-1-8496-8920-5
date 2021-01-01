

import java.util.Calendar;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.FaultAction;

@WebService(targetNamespace="http://www.packt.org/book/hotel", name="HotelBooking")
public class BookHotel {

	@WebMethod(action="urn:availableHotels", operationName="availableHotels")
	
	public @WebResult(partName="hotels") String[] availableHotels(
			@WebParam(partName="fromDate") Calendar from, 
			@WebParam(partName="toDate") Calendar to)
	{
		String[] result = {"Ramada Plaza", "Plaza", "Hilton"};
		return result;
	}
}
