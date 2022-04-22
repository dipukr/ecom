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

import ecom.model.Product;

@WebServlet("/cancelCartItem")
public class CancelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		@SuppressWarnings("unchecked")
		List<Product> cartItems = (ArrayList<Product>) session.getAttribute("cartItems");
		for (Product cartItem: cartItems) {
			if (cartItem.getId() == id) {
				cartItems.remove(cartItems.indexOf(cartItem));
				break;
			}
		}
		response.sendRedirect("cart.jsp");
    }
}
