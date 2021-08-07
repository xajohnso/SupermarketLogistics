package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class Truck {
	
	protected ArrayList<Integer> productIDs = new ArrayList<Integer>();
	protected HashMap<Integer, Integer> pallet = new HashMap<Integer, Integer>();
	
	
	public void start() {
		getProductIDs();
		createPallet();
	}
	
	public void getProductIDs() {
		try {
			Connection cn = DriverManager.getConnection("location", "user", "password");
			
			String statement = "select idproducts from store.products";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(statement);
			
			while (rs.next()) {
				productIDs.add(rs.getInt("idproducts"));
			}
			
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createPallet() {
		for (int x = 0; x < productIDs.size(); x++) {
			int stockAmount = (int)(Math.random() * 3);
			pallet.put(productIDs.get(x), stockAmount);
		}
	}
	
	public void showPallet() {
		pallet.forEach((p,s) -> System.out.println("Product: " + p + " Stock: " + s));
	}
	
	public void emptyPallet(Pallet storePallet) {
		storePallet.palletTransfer(pallet);
		pallet.clear();
	}
	
	//             ***NEEDS WORK***
	public void newOrder() {
		
	}
}
