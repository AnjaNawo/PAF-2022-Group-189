package com;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML 
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import model.Customer;

@Path("/Customer")
public class CustomerRegister {
	Customer CustomerObj = new Customer();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readCustomer() {
		return CustomerObj.readCustomer();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertCustomer(
	 @FormParam("FirstName") String FirstName,			
	 @FormParam("LastName") String LastName,
	 @FormParam("CustomerAddress") String CustomerAddress,
	 @FormParam("Gender") String Gender,
	 @FormParam("CustomerMobileNo") String CustomerMobileNo)
	{
	 String output = CustomerObj.insertCustomer(FirstName, LastName, CustomerAddress, Gender, CustomerMobileNo);
	return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateCustomer(String customerData)
	{
	//Convert the input string to a JSON object
	 JsonObject registerObject = new JsonParser().parse(customerData).getAsJsonObject();
	//Read the values from the JSON object
	 String CustomerID = registerObject.get("CustomerID").getAsString();
	 String FirstName = registerObject.get("FirstName").getAsString();
	 String LastName = registerObject.get("LastName").getAsString();
	 String CustomerAddress = registerObject.get("CustomerAddress").getAsString();
	 String Gender = registerObject.get("Gender").getAsString();
	 String CustomerMobileNo = registerObject.get("CustomerMobileNo").getAsString();
	 String output = CustomerObj.updateCustomer(CustomerID, FirstName, LastName, CustomerAddress, Gender, CustomerMobileNo);
	return output;
	} 
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteCustomer(String customerData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(customerData, "", Parser.xmlParser());

	//Read the value from the element 
	 String CustomerID = doc.select("CustomerID").text();
	 String output = CustomerObj.deleteCustomer(CustomerID);
	return output;
	}
	
}
