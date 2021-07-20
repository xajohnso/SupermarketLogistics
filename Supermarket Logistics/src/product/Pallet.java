package product;

import java.util.HashMap;

public class Pallet {

	protected HashMap<String, Integer> pallet = new HashMap<String, Integer>();
	
	public void removeItems(String product) {
		pallet.remove(product);
	}
	
	public void getItem(String product) {
		pallet.get(product);
	}
}
