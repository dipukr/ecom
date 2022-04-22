package ecom.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecom.dao.UserDAO;
import ecom.model.User;

@WebServlet("/userLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		UserDAO dao = new UserDAO();
		dao.connectDB();
		User user = dao.login(email, password);
		if (user == null)
			out.println("invalid email or password");
		else {
			response.sendRedirect("index.jsp");
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		}
	}
}
