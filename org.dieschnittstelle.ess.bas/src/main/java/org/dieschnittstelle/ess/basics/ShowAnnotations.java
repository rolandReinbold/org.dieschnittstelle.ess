package org.dieschnittstelle.ess.basics;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dieschnittstelle.ess.basics.annotations.AnnotatedStockItemBuilder;
import org.dieschnittstelle.ess.basics.annotations.DisplayAs;
import org.dieschnittstelle.ess.basics.annotations.StockItemProxyImpl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.*;

import static org.dieschnittstelle.ess.utils.Utils.*;

public class ShowAnnotations {

	protected static Logger logger = LogManager
			.getLogger(ShowAnnotations.class);

	public static void main(String[] args) {
		// we initialise the collection
		StockItemCollection collection = new StockItemCollection(
				"stockitems_annotations.xml", new AnnotatedStockItemBuilder());
		// we load the contents into the collection
		collection.load();

		for (IStockItem consumable : collection.getStockItems()) {
			showAttributes(((StockItemProxyImpl)consumable).getProxiedObject());
		}

		// we initialise a consumer
		Consumer consumer = new Consumer();
		// ... and let them consume
		consumer.doShopping(collection.getStockItems());
	}

	/*
	 * TODO BAS2
	 */
	private static void showAttributes(Object consumable) {
		final Class consumableClass = consumable.getClass();
		show("class is: " + consumableClass);

		// Result string.
		String result = "{" + consumableClass.getSimpleName();

		// Iterate over the declared fields and append the values to the result string.
		for(Field classField : consumableClass.getDeclaredFields()) {
			// Set accessibility to true.
			classField.setAccessible(true);

			try {
				String fieldName = classField.getName();
				if (classField.isAnnotationPresent(DisplayAs.class)) {
					DisplayAs displayAsAnnotation = classField.getAnnotation(DisplayAs.class);
					fieldName = displayAsAnnotation.value();
				}

				// Get and append the field value.
				result = result.concat(" " + fieldName + ":" + classField.get(consumable) + ",");
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

	// Replace char at last index.
	result = result.substring(0, result.length() -1).concat("}");
	show(result);
	}
}

