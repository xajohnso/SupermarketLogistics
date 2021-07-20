package person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import product.Shelf;

public class Shopper {


	private double wallet;
	private HashMap<String, Integer> Cart = new HashMap<String, Integer>();
	private ArrayList<String> productsInCart = new ArrayList<String>();
	
	
	public Shopper() {}
	
	public double getWallet() {
		return wallet;
	}
	public void addCash(double wallet) {
		this.wallet = wallet;
	}
	public HashMap<String, Integer> getCart() {
		return Cart;
	}
	public void setCart(HashMap<String, Integer> cart) {
		Cart = cart;
	}
	
	//Sum of the price of items in the cart is deducted from wallet *Check to assure enough money*
	public double removeCash(double amount) {
		wallet = wallet - amount;
		return wallet;
	}
	
	//Adds product and amount of product to cart of shopper
	public void addToCart(String product, Integer amount) {
		Cart.put(product, amount);
	}
	
	public void printCart() {
		Cart.forEach((k,v) -> System.out.println(k + " Quantity: " + v));
	}
	
	public void cartToSet() {
		productsInCart.addAll(Cart.keySet());
	}
	
	public double getItems(Shelf shelf) {
		
		double priceTotal = 0.0;
		double quantity = 0;
		double cost = 0.0;
		
		for (int x = 0; x < productsInCart.size(); x++) {
			cost = shelf.getProductsPrice(productsInCart.get(x));
			quantity = (double) Cart.get(productsInCart.get(x));
			priceTotal = priceTotal + (cost * quantity);
		}
		
		return priceTotal;
	}
	
	public void removeItems(Scanner scanner) {
		System.out.println("Which item?");
		printCart();
		int choice = scanner.nextInt();
		switch(choice) {
		default:
			String pS = productsInCart.get(choice - 1);
			System.out.println("Quantity?");
			int qC = scanner.nextInt();
			boolean check = Cart.get(pS) == qC;
			if (check == true) {
				Cart.remove(pS);
			} else {
				Cart.replace(pS, Cart.get(pS) - qC);
			}
		break;
		}
	}
	
}
