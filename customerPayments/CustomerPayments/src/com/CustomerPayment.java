package com;

import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML 
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import model.payment;


@Path("/payment")
public class CustomerPayment{
	payment paymentObj = new payment();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readPayment() {
		return paymentObj.readPayment();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPayment(
	 @FormParam("amount") String amount,			
	 @FormParam("cardName") String cardName,
	 @FormParam("cardNumber") String cardNumber,
	 @FormParam("CVV") String CVV,
	 @FormParam("cardType") String cardType)
	{
	 String output = paymentObj.insertPayments(amount, cardName, cardNumber, CVV, cardType);
	return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePayment(String customerData)
	{
	//Convert the input string to a JSON object
	 JsonObject registerObject = new JsonParser().parse(customerData).getAsJsonObject();
	//Read the values from the JSON object
	 String paymentID = registerObject.get("paymentID").getAsString();
	 String amount = registerObject.get("amount").getAsString();
	 String cardName = registerObject.get("cardName").getAsString();
	 String cardNumber = registerObject.get("cardNumber").getAsString();
	 String CVV = registerObject.get("CVV").getAsString();
	 String cardType = registerObject.get("cardType").getAsString();
	 String output = paymentObj.updatePayment(paymentID, amount, cardName,cardNumber, CVV, cardType);
	return output;
	} 
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePayment(String paymentData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(paymentData, "", Parser.xmlParser());

	//Read the value from the element 
	 String paymentID = doc.select("paymentID").text();
	 String output = paymentObj.deletePayment(paymentID);
	return output;
	}
	
}
