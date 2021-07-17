package product;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Product {

	protected LinkedHashMap<String, Integer> productsPackages = new LinkedHashMap<String, Integer>();
	protected HashMap<String, Double> productsPrice = new HashMap<String, Double>();
	
	public void setProducts() {
		productsPackages.put("Chicken", 6);
		productsPackages.put("Milk", 6);
		productsPackages.put("Candy", 6);
		productsPackages.put("Powerade", 6);
	}
	
	public void setPrices() {
		productsPrice.put("Chicken", 7.50);
		productsPrice.put("Milk", 6.35);
		productsPrice.put("Candy", 11.67);
		productsPrice.put("Powerade", 20.11);
	}
	
	public double getProductsPrice(String productName) {
		double price = productsPrice.get(productName);
		
		return price;
	}
}
