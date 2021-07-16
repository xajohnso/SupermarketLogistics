package person;

import java.util.HashMap;

public class Shopper {


	private double wallet;
	private HashMap<String, Integer> Cart = new HashMap<String, Integer>();
	
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
	
	/*
	1) List products in cart 2) Choose product(s) to remove 3) Call to finish method
	
	public void removeProduct() {
	Scanner sn = new Scanner(System.in);
	Shelf shelf = new Shelf();
	System.out.println("Which product would you like?");
	shelf.showShelf();
	int productChoice = sn.nextInt();
	
	System.out.println("Quantity?");
	int quantityChoice = sn.nextInt();
	
	}
	*/
	
	//Adds product and amount of product to cart of shopper
	public void addToCart(String product, Integer amount) {
		Cart.put(product, amount);
	}
	
	public void printCart() {
		Cart.forEach((k,v) -> System.out.println(k + " Quantity: " + v));
	}
	
}
