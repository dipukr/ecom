package ecom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ecom.model.Product;

public class ProductDAO {
	
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
	
	public List<Product> getProducts() {
		List<Product> products = new ArrayList<>();
		try {
			String sql = String.format("select * from products");
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setKind(rs.getString("kind"));
				product.setPrice(rs.getInt("price"));
				product.setImage(rs.getString("image"));
				products.add(product);
			}
			return products;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
}
