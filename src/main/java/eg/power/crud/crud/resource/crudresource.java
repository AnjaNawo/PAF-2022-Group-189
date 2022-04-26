package eg.power.crud.crud.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import eg.power.crud.crud.model.crudmodel;
import eg.power.crud.crud.service.crudservice;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/crud")
public class crudresource {
	
	
	crudservice service = new crudservice();
	
	@Path("/insertion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public crudmodel addPowercut(crudmodel powercut) {
		return service.addPowercut(powercut);
	
	}
	
	@Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<crudmodel> getPowercut() throws SQLException {
		return service.getPowercut();
	
	}
	
	@Path("/retrieveById/(id)")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<crudmodel> getPowercut(@PathParam("id") int id) throws SQLException {
		return service.getPowercutById(id);
	
	
	}
	
	@Path("/updatePowercut")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public crudmodel updatePowercut(crudmodel powercut) {
		return service.updatePowercut(powercut);
	
	}
	
	@Path("/deletePowercutById/(id)")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deletePowercut(@PathParam("id") int id) {
		return service.deletePowercut(id);
	
	}


}
 