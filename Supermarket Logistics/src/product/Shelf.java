package product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import person.Shopper;

public class Shelf extends Product {

	private HashMap<String, Integer> shelf = new HashMap<String, Integer>();
	private ArrayList<String> shelf2 = new ArrayList<String>();
	private int productSpace = 10;
	
	//Adds products to shelf when employee stocks **NEEDS WORK**
	public void addShelf(String product) {
		boolean check = shelf.containsKey(product);
		int x = 0;
		System.out.println(check);
		if (check == true) {
				x = shelf.get(product) + products.get(product);
				
				// If-else to see if a full case of a product can be put on the shelf **BACKSTOCK LINK NEEDED**
				if (x > productSpace) {
					shelf.replace(product, productSpace);
				} else {
					shelf.replace(product, x);
				}
				
		} else {
			shelf.put(product, products.get(product));
		}

		
	}
	
	// Adds products to the shelf *Start*
	public void newShelf() {
		setProducts();
		products.forEach((k,v) -> addShelf(k));
		shiftCollection();
	}
	
	// Prints shelf
	public void showShelf() {
		shelf.forEach((k, v) -> System.out.println("Product: " + k + " In stock: " + v));
	}
	
	// Updates shelf after shopper buys
	public void updateShelf(String product, int amount) {
		shelf.replace(product, shelf.get(product) - amount);
	}
	
	public void addToCart(Shopper shopper) {
		int zz = 0;
		Scanner sn = new Scanner(System.in);
		do {
		System.out.println("What product would you like?");
		showShelf();
		int productChoice = sn.nextInt();
		
		System.out.println("How much of product would you like?");
		int quantityChoice = sn.nextInt();
		
		System.out.println("Is this right? 1) Yes 2) No \nProduct: " + shelf2.get(productChoice - 1) + "\nQuantity: " + quantityChoice);
		int finCheck = sn.nextInt();
		if (finCheck == 1) {
			updateShelf(shelf2.get(productChoice - 1), quantityChoice);
			shopper.addToCart(shelf2.get(productChoice - 1), quantityChoice);
			System.out.println("Is this all you want?");
			shopper.printCart();
			System.out.println("1) Yes 2) No");
			int fc = sn.nextInt();
			if (fc == 1) {
				zz++;
				sn.close();
			} else {}
		} else {}
		} while (zz == 0);
	}
	
	public void shiftCollection() {
		shelf2.addAll(shelf.keySet());
	}
	
	
}
