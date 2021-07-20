package main;

import java.util.Scanner;

import person.Cashier;
import person.Shopper;
import product.Product;
import product.Shelf;

public class Main {
		
	static Shopper shopper = new Shopper();
	static Shelf shelf = new Shelf();
	static Product product = new Product();
	static Cashier cashier = new Cashier();
	
	public static void main(String[] args) {
		
		int num = (int) (Math.random() * 4);
		System.out.println(num);
		
		Scanner scanner = new Scanner(System.in);
		start(shopper, shelf);
		shop(shopper, shelf, scanner);
		cashier.checkOut(shopper, shelf, scanner);
		
		scanner.close();
	}
	
	public static void start(Shopper shopper, Shelf shelf) {
		shelf.newShelf();
		shopper.addCash(500.00);
	}
	
	public static void shop(Shopper shopper, Shelf shelf, Scanner scanner) {
		int zz = 0;

		do {
		System.out.println("What product would you like?");
		shelf.showShelf();
		int productChoice = scanner.nextInt();
		
		System.out.println("How much of product would you like?");
		int quantityChoice = scanner.nextInt();
		
		System.out.println("Is this right? 1) Yes 2) No \nProduct: " + shelf.getProduct(productChoice) + "\nQuantity: " + quantityChoice);
		int finCheck = scanner.nextInt();
		if (finCheck == 1) {
			shelf.updateShelf(shelf.getProduct(productChoice), quantityChoice);
			shopper.addToCart(shelf.getProduct(productChoice), quantityChoice);
			System.out.println("Is this all you want?");
			shopper.printCart();
			System.out.println("1) Yes 2) No");
			int fc = scanner.nextInt();
			if (fc == 1) {
				priceTotal(shopper, shelf);
				zz++;
			} else {}
		} else {}
		} while (zz == 0);
	}
	
	public static void priceTotal(Shopper shopper, Shelf shelf) {
		shopper.cartToSet();
		shopper.getItems(shelf);
	}

}
