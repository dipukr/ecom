package ecom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import ecom.model.Order;

public class OrderDAO {
	
	private Connection con;
	private Statement stat;
	
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb", "root", "root");
			stat = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void save(Order order) {
		try {
			String sql = String.format("insert into orders (pid,uid) values(%d,%d)",
					order.getProductId(), order.getUserId());
			stat.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
