package product;

import java.util.ArrayList;
import java.util.HashMap;

public class Shelf extends Product {

	private HashMap<String, Integer> shelfStock = new HashMap<String, Integer>();
	private ArrayList<String> productNames = new ArrayList<String>();
	private int productSpace = 10;
	
	//Adds products to shelf when employee stocks **NEEDS WORK**
	public void addShelf(String product) {
		boolean check = shelfStock.containsKey(product);
		int x = 0;
		System.out.println(check);
		if (check == true) {
				x = shelfStock.get(product) + productsPackages.get(product);
				
				// If-else to see if a full case of a product can be put on the shelf **BACKSTOCK LINK NEEDED**
				if (x > productSpace) {
					shelfStock.replace(product, productSpace);
				} else {
					shelfStock.replace(product, x);
				}
				
		} else {
			shelfStock.put(product, productsPackages.get(product));
		}

		
	}
	
	// Adds products to the shelf *Start*
	public void newShelf() {
		setProducts();
		setPrices();
		productsPackages.forEach((k,v) -> addShelf(k));
		shiftCollection();
	}
	
	// Prints shelf
	public void showShelf() {
		shelfStock.forEach((k, v) -> System.out.println("Product: " + k + " In stock: " + v));
	}
	
	// Updates shelf after shopper buys
	public void updateShelf(String product, int amount) {
		shelfStock.replace(product, shelfStock.get(product) - amount);
	}
	
	
	public void shiftCollection() {
		productNames.addAll(shelfStock.keySet());
	}
	
	public String getProduct(int position) {
		String product = productNames.get(position - 1);
		return product;
	}
	
	
}
