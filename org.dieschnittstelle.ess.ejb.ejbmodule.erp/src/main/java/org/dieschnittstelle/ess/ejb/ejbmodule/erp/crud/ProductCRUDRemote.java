package org.dieschnittstelle.ess.ejb.ejbmodule.erp.crud;

import java.awt.*;
import java.util.List;

import org.dieschnittstelle.ess.entities.erp.AbstractProduct;

import javax.ejb.Remote;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/*
 * EJB+JPA1/2/5:
 * this interface shall be implemented using a stateless EJB with an EntityManager.
 * See TouchpointCRUDStateless for an example EJB with a similar scope of functionality
 */
@Remote
@Path("/products")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface ProductCRUDRemote {

	@POST
    AbstractProduct createProduct(AbstractProduct prod);

	@GET
    List<AbstractProduct> readAllProducts();

	@PUT
    AbstractProduct updateProduct(AbstractProduct update);

	@GET
	@Path("/{id}")
    AbstractProduct readProduct(@PathParam("id") long productID);

	@DELETE
	@Path("/{id}")
    boolean deleteProduct(@PathParam("id") long productID);
}
