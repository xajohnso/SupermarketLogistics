package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class Shelf {

	private HashMap<String, Integer> shelfStock = new HashMap<String, Integer>();
	private productDB pDB = new productDB();
	
	
	// Prints shelf
	public void showShelf() {
		shelfStock.forEach((k, v) -> System.out.println("Product: " + k + " In stock: " + v + " Price: $" + pDB.getProductPrice(k)));
	}
	
	public void updateShelf() {
		try {
			Connection cn = DriverManager.getConnection("location", "user", "password");
			
			String statement = "SELECT * FROM store.floor_products";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(statement);
			
			while (rs.next()) {
				shelfStock.put(rs.getString("product_name"), rs.getInt("floor_stock"));
			}
			
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Updates shelf after shopper buys
	public void shelfShopUpdate(String product, int amount) {
		shelfStock.replace(product, shelfStock.get(product) - amount);
	
		try {
		Connection cn = DriverManager.getConnection("location", "user", "password");
		String statement = "update store.products " + "set floor_stock = (?) where product_name = (?)";
		PreparedStatement ps = cn.prepareStatement(statement);
		ps.setInt(1, shelfStock.get(product) - amount);
		ps.setString(2, product);

		cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
