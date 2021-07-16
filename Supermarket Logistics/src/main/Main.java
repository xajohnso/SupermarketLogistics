package main;

import person.Shopper;
import product.Shelf;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Shopper Xavier = new Shopper();
		Shelf shelf = new Shelf();
		
		shelf.newShelf();
		Xavier.addCash(500.00);
		shelf.addToCart(Xavier);
		
	}

}
