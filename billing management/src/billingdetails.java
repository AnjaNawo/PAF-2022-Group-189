package com;

import javax.swing.text.html.HTMLEditorKit.Parser;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.google.gson.*;

import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;



@Path("/Billing")
public class billingdetails {
	billing billObj = new billing();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readbilling() {
		return billObj.readBilling();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertBilling(
	 @FormParam("Bill_ID") String Bill_ID,			
	 @FormParam("units") String units,
	 @FormParam("price_per_unit") String price_per_unit,
	 
	{
	 String output = billObj.insertBilling(Bill_ID, units, price_per_unit);
	return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateBilling(String billingData)
	{
	
	 JsonObject registerObject = new JsonParser().parse(billingData).getAsJsonObject();
	
	 String Bill_ID = registerObject.get("Bill_ID").getAsString();
	 String units = registerObject.get("units").getAsString();
	 String price_per_unit = registerObject.get("price_per_unit").getAsString();
	 
	 String output = billObj.updatebilling(Bill_ID, units, price_per_unit);
	return output;
	} 
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public <document> String deleteCustomer(String billingData)
	{
	
	 document doc = Jsoup.parse(billingData, "", Parser.xmlParser());

	
	 String Bill_ID = doc.select("Bill_ID").text();
	 String output = billObj.deletebiilingrep(Bill_ID);
	return output;
	}
	
}