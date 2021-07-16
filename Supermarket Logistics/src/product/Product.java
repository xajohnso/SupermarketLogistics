package product;

import java.util.LinkedHashMap;

public class Product {

	protected LinkedHashMap<String, Integer> products = new LinkedHashMap<String, Integer>();
	
	public void setProducts() {
		products.put("Chicken", 6);
		products.put("Milk", 6);
		products.put("Candy", 6);
		products.put("Powerade", 6);
	}
}
