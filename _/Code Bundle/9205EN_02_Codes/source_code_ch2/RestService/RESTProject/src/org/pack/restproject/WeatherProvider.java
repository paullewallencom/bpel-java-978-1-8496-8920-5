package org.pack.restproject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("RESTWeatherService")
public class WeatherProvider {
    
    @GET
    //@Path("{name}/{zip}")    
    @Path("/query")    
    @Produces("text/xml")  
    //public String getWeatherInfo(@PathParam("name") String name,@PathParam("zip") String zip) {
    public String getWeatherInfo(@QueryParam("name") String name,@QueryParam("zip") String zip) {
        return "<weatherRes>Hello " + name + ". The weather in " + zip + " city cloudy. \n" + 
            "Temperature is 24 degress celzius. \n" +
            "Humidity is 74%</weatherRes>";
    }
}
