package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class productDB {
	
	private int productNumber;
	private String productName;
	private int shelfCapacity;
	private double price;
	private int setAmount;
	private HashMap<Integer, String> productList = new HashMap<Integer, String>();
	private HashMap<String, Double> productPrice = new HashMap<String, Double>();
	
	public productDB() {
		updateProductList();
	}
	
	public productDB(String productName) {
		super();
		this.productName = productName;		
		setProductNumber((int)(Math.random() * 1000));
		setShelfCapacity((int)(Math.random() * 20));
		setSetAmount((int)(Math.random() * 10));
		setPrice((Math.random() * 10));
	}
	
	public int getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getShelfCapacity() {
		return shelfCapacity;
	}
	public void setShelfCapacity(int shelfCapacity) {
		this.shelfCapacity = shelfCapacity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getSetAmount() {
		return setAmount;
	}
	public void setSetAmount(int setAmount) {
		this.setAmount = setAmount;
	}
	
	public void addToDatabase() {
		try {
			Connection cn = DriverManager.getConnection("location", "user", "password");
			String statement = "insert into products " + 
			"(idproducts, product_name, shelf_capacity, price, floor_stock, back_stock, amount_in_set)" +
			" values (?, ?, ?, ?, ?, ?, ?)";
			

			PreparedStatement ps = cn.prepareStatement(statement);
			ps.setInt(1, getProductNumber());
			ps.setString(2, getProductName());
			ps.setInt(3, getShelfCapacity());
			ps.setDouble(4, getPrice());
			ps.setInt(5, 0);
			ps.setInt(6, 0);
			ps.setInt(7, getSetAmount());
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in connection");
		}
	}
	
	public void updateProductList() {
		try {
			Connection cn = DriverManager.getConnection("location", "user", "password");
			Statement st = cn.createStatement();
			String statement = "select idproducts, product_name, price from store.products";
			
			ResultSet rs = st.executeQuery(statement);
			while (rs.next()) {
				productList.put(rs.getInt("idproducts"), rs.getString("product_name"));
				productPrice.put(rs.getString("product_name"), rs.getDouble("price"));
			}
			
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Double getProductPrice(String productName) {
		
		return productPrice.get(productName);
	}
	
}
