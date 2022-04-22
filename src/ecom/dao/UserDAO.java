package ecom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import ecom.model.User;

public class UserDAO {

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
	
	public User login(String email, String password) {
		User user  = null;
		try {
			String sql = String.format("select * from users where email='%s' and password='%s'", email, password);
			ResultSet rs = stat.executeQuery(sql);
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}