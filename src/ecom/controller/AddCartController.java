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

@WebServlet("/addToCart")
public class AddCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int price = Integer.parseInt(request.getParameter("price"));
		String name = request.getParameter("name");
		String kind = request.getParameter("kind");
		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		product.setKind(kind);
		
		if (request.getSession().getAttribute("cartItems") == null) {
			List<Product> cartItems = new ArrayList<Product>();
			cartItems.add(product);
			HttpSession session = request.getSession();
			session.setAttribute("cartItems", cartItems);
			response.sendRedirect("index.jsp");
		} else {
			List<Product> cartItems2 = (ArrayList<Product>) request.getSession().getAttribute("cartItems");
			cartItems2.add(product);
			response.sendRedirect("index.jsp");
		}
	}
}
