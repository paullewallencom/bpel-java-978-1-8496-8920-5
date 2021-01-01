

import java.util.Calendar;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;

@WebService(targetNamespace="http://www.packt.org/book/car", name="CarBooking")
public class BookCar {

	@WebMethod(action="urn:availableHotels", operationName="availableHotels")	
	@Action(
	         fault = {
	             @FaultAction(className=InvalidDatesException.class, value="http://www.packt.org/book/car/faultAction")
	         })	
	public @WebResult(partName="car") String getAvailableCar(
			@WebParam(partName="fromDate") Calendar from, 
			@WebParam(partName="toDate") Calendar to) throws InvalidDatesException
	{
		if (from.after(to))
		{
			throw new InvalidDatesException();
		}
		
		String result = "AUDI A8 year 2012; 85.000 km; 60 EUR/day, ref: 4234345223";
		return result;
	}	
}
