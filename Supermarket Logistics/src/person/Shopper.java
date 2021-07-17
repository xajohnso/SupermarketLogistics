package person;

import java.util.ArrayList;
import java.util.HashMap;

import product.Product;

public class Shopper {


	private double wallet;
	private HashMap<String, Integer> Cart = new HashMap<String, Integer>();
	private ArrayList<String> productsInCart = new ArrayList<String>();
	private double priceTotal = 0;
	
	
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
	
	public void getItems() {
		Product product = new Product();
		int quantity = 0;
		double cost = 0;
		double total = (double) quantity * cost;
		for (int x = 0; x < productsInCart.size(); x++) {
			cost = product.getProductsPrice(productsInCart.get(x));
			quantity = Cart.get(productsInCart.get(x));
			priceTotal = priceTotal + total;
		}
		
	}
	
}
