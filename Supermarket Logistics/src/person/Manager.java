package person;

import product.productDB;

public class Manager {

	public void addProducts(String productName) {
		
		productDB pDB = new productDB(productName);
		pDB.addToDatabase();
	}
}
