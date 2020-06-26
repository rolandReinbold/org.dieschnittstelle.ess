package org.dieschnittstelle.ess.ejb.ejbmodule.erp;

import java.util.List;

import javax.ejb.Local;

import org.dieschnittstelle.ess.entities.erp.IndividualisedProductItem;
import org.dieschnittstelle.ess.entities.erp.StockItem;

@Local
public interface StockSystemLocal {

	/**
	 * adds some units of a product to the stock of a point of sale
	 *
	 * @param product
	 * @param pointOfSaleId
	 * @param units
	 */
    void addToStock(IndividualisedProductItem product, long pointOfSaleId, int units);

	/**
	 * removes some units of a product from the stock of a point of sale
	 *	
	 * @param product
	 * @param pointOfSaleId
	 * @param units
	 */
    void removeFromStock(IndividualisedProductItem product, long pointOfSaleId, int units);
	
	/**
	 * returns all products on stock of some pointOfSale
	 * 
	 * @param pointOfSaleId
	 * @return
	 */
    List<IndividualisedProductItem> getProductsOnStock(long pointOfSaleId);

	/**
	 * returns all products on stock
	 * 
	 * @return
	 */
    List<IndividualisedProductItem> getAllProductsOnStock();

	/**
	 * returns the units on stock for a product at some point of sale
	 * 
	 * @param product
	 * @param pointOfSaleId
	 * @return
	 */
    int getUnitsOnStock(IndividualisedProductItem product, long pointOfSaleId);

	/**
	 * returns the total number of units on stock for some product
	 * 
	 * @param product
	 * @return
	 */
    int getTotalUnitsOnStock(IndividualisedProductItem product);
	
	/**
	 * returns the points of sale where some product is available
	 * 
	 * @param product
	 * @return
	 */
    List<Long> getPointsOfSale(IndividualisedProductItem product);


	/**
	 * returns the complete available stock
	 * 
	 * @return
	 */
    List<StockItem> getCompleteStock();
	
}
