package product;

import java.util.ArrayList;

public class Truck {

	private ArrayList<Pallet> pallets = new ArrayList<Pallet>();
	private ArrayList<String> productList = new ArrayList<String>();
	private Pallet p00;
	private Pallet p01;
	private Pallet p02;
	
	public void nn() {
		pallets.add(p00);
		pallets.add(p01);
		pallets.add(p02);
	}
	
	public void setProductList() {
		Product product = new Product();
		productList.addAll(product.productsPrice.keySet());
	}
	
	public void fillPallet(Pallet pallet) {
		for (int x = 0; x < 3; x++) {
			int product = (int)(Math.random() * (productList.size() - 1));
			int caseQuantity = (int)(Math.random() * 3);
			pallet.pallet.put(productList.get(product), caseQuantity);
		}
	}
	
	public void fillAll() {
		for (int q = 0; q < pallets.size(); q++) {
			fillPallet(pallets.get(q));
		}
	}
	
	public ArrayList<Pallet> delivery() {
		
		return pallets;
	}
}
