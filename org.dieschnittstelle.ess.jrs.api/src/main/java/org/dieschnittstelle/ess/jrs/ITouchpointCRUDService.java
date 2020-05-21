package org.dieschnittstelle.ess.jrs;

import org.dieschnittstelle.ess.entities.crm.StationaryTouchpoint;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/touchpoints")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface ITouchpointCRUDService {

	@POST
	StationaryTouchpoint createTouchpoint(StationaryTouchpoint touchpoint);
	
	@GET
	List<StationaryTouchpoint> readAllTouchpoints();

	@GET
	@Path("/{touchpointId}")
	StationaryTouchpoint readTouchpoint(@PathParam("touchpointId") long id);

	/*
	 * JRS1: add a new annotated method for using the updateTouchpoint functionality of TouchpointCRUDExecutor and implement it
	 */
	@PUT
	@Path("/{touchpointId}")
	StationaryTouchpoint updateTouchpoint(@PathParam("touchpointId") long id, StationaryTouchpoint update);

	@DELETE
	@Path("/{touchpointId}")
	boolean deleteTouchpoint(@PathParam("touchpointId") long id);
}
