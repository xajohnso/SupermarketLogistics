package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class Pallet {

	protected HashMap<Integer, Integer> pallet = new HashMap<Integer, Integer>();
	protected HashMap<Integer, Integer> totalAmount = new HashMap<Integer, Integer>();
	
	
	public void palletTransfer(HashMap<Integer, Integer> truckPallet) {
		pallet.putAll(truckPallet);
	}
	
	public void gettingTotalAmount() {
		try {
			Connection cn = DriverManager.getConnection("location", "user", "password");
			String statement = "select idproducts, amount_in_set from products";
			Statement ps = cn.createStatement();
			ResultSet rs = ps.executeQuery(statement);
			
			while (rs.next()) {
				totalAmount.put(rs.getInt("idproducts"), (rs.getInt("amount_in_set") * pallet.get(rs.getInt("idproducts"))));
			}
			
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stock() {
		try {
			Connection cn = DriverManager.getConnection("location", "user", "password");
			String statement = "select idproducts, shelf_capacity, floor_stock, back_stock from store.products";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(statement);
			while (rs.next()) {
				int difference = rs.getInt("shelf_capacity") - rs.getInt("floor_stock");
				if (totalAmount.get(rs.getInt("idproducts")) > difference) {
					updateStock(rs.getInt("idproducts"), rs.getInt("shelf_capacity"), (totalAmount.get(rs.getInt("idproducts")) - difference), rs.getInt("back_stock"));
				} else {
					uSL(rs.getInt("idproducts"), rs.getInt("floor_stock") + totalAmount.get(rs.getInt("idproducts")), 0, rs.getInt("back_stock"));
				}
			}
			
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateStock(int idProduct, int newFloorStock, int newBackStock, int backstock) {
		try {
			Connection cn = DriverManager.getConnection("location", "user", "password");
			String statement = "update store.products " + " set floor_stock = ?, back_stock = ? " + "where idproducts = ?";
			PreparedStatement ps = cn.prepareCall(statement);
			ps.setInt(1, newFloorStock);
			ps.setInt(2, backstock + newBackStock);
			ps.setInt(3, idProduct);
			
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void uSL(int idProduct, int newFloorStock, int newBackStock, int backstock) {
		try {
			Connection cn = DriverManager.getConnection("location", "user", "password");
			String statement = "update store.products " + " set floor_stock = ?, back_stock = ? " + "where idproducts = ?";
			PreparedStatement ps = cn.prepareCall(statement);
			ps.setInt(1, newFloorStock);
			ps.setInt(2, backstock + newBackStock);
			ps.setInt(3, idProduct);
			
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
