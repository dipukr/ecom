<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  

<%@ page import="ecom.dao.ProductDAO"%>
<%@ page import="ecom.model.User" %>
<%@ page import="ecom.model.Product" %>
<%@ page import="java.util.List" %>

<%  
	User user = (User) request.getSession().getAttribute("user");
	ProductDAO dao = new ProductDAO();
	dao.connectDB();
	List<Product> products = dao.getProducts();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="index.css">
</head>
<body>
	<%@ include file="nav.dat" %>
    <h1>Products</h1>
    <div class="products">
    	<%
    	if (!products.isEmpty()) {
    		for (Product product: products){%>
    			<div class="product">
    				<img alt="" src="image/<%=product.getImage()%>">
    				<p class="name"><%=product.getName()%></p>
    				<p class="price"><%=product.getPrice()%></p>
    				<p class="kind">Category: <%=product.getKind()%></p>
    				<div class="buttons">
    					<a href="addToCart?id=<%= product.getId() %>&name=<%= product.getName() %>&price=<%= product.getPrice() %>&kind=<%= product.getKind() %>"><button>Add to Cart</button></a>
    				</div>
    			</div>
    		<%
    		}
    	}
    	%>
    </div>
</body>
</html>