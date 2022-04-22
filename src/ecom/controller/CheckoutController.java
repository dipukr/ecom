package ecom.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecom.dao.OrderDAO;
import ecom.model.Order;
import ecom.model.User;
import ecom.model.Product;

@WebServlet("/checkOut")
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	User user = (User) request.getSession().getAttribute("user");
    	if (user == null) response.sendRedirect("login.jsp");
    	else {
    		HttpSession session = request.getSession();
    		@SuppressWarnings("unchecked")
			List<Product> cartItems = (ArrayList<Product>) session.getAttribute("cartItems");
    		OrderDAO dao = new OrderDAO();
    		dao.connectDB();
    		for (Product cartItem: cartItems) {
    			Order order = new Order();
    			order.setProductId(cartItem.getId());
    			order.setUserId(user.getId());
    			dao.save(order);
    		}
    		response.sendRedirect("orders.jsp");
    	}
    }
}
