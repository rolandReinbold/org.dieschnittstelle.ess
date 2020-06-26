package org.dieschnittstelle.ess.wsv.client.service;

import org.dieschnittstelle.ess.entities.crm.AbstractTouchpoint;

import javax.ws.rs.*;
import java.util.List;

@Path("/touchpoints")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public interface ITouchpointCRUDService {
	
	@GET
    List<AbstractTouchpoint> readAllTouchpoints();

	@GET
	@Path("/{touchpointId}")
    AbstractTouchpoint readTouchpoint(@PathParam("touchpointId") long id);

	@POST
    AbstractTouchpoint createTouchpoint(AbstractTouchpoint touchpoint);
	
	@DELETE
	@Path("/{touchpointId}")
    boolean deleteTouchpoint(@PathParam("touchpointId") long id);

	@PUT
	@Path("/{touchpointId}")
    AbstractTouchpoint updateTouchpoint(@PathParam("touchpointId") long id, AbstractTouchpoint touchpoint);

}
