package org.dieschnittstelle.ess.jrs;

import org.dieschnittstelle.ess.entities.erp.AbstractProduct;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/*
 * UE JRS2: 
 * deklarieren Sie hier Methoden fuer:
 * - die Erstellung eines Produkts
 * - das Auslesen aller Produkte
 * - das Auslesen eines Produkts
 * - die Aktualisierung eines Produkts
 * - das Loeschen eines Produkts
 * und machen Sie diese Methoden mittels JAX-RS Annotationen als WebService verfuegbar
 */

/*
 * JRS3: aendern Sie Argument- und Rueckgabetypen der Methoden von AbstractProduct auf AbstractProduct
 */
@Path("/products")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface IProductCRUDService {

	@POST
	AbstractProduct createProduct(AbstractProduct prod);

	@GET
	List<AbstractProduct> readAllProducts();

	@GET
	@Path("/{productId}")
	AbstractProduct readProduct(@PathParam("productId") long id);

	@PUT
	@Path("/{productId}")
	AbstractProduct updateProduct(@PathParam("productId") long id,
								  AbstractProduct update);

	@DELETE
	@Path("/{productId}")
	boolean deleteProduct(@PathParam("productId") long id);
}
