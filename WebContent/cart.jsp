<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="ecom.util.Util" %>
<%@ page import="ecom.model.User" %>
<%@ page import="ecom.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%  
	User user = (User) request.getSession().getAttribute("user");
	List<Product> cartItems = (ArrayList<Product>) session.getAttribute("cartItems");
	request.setAttribute("cartItems", cartItems);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<link rel="stylesheet" href="index.css">
<style>
	.custom-table {
		border-collapse: collapse;
		margin: 20px 0px;
		font-size: 20px;
		min-width: 400px;
		width: 50%;
		margin-left: auto;
		margin-right: auto;
		border-radius: 5px;
		overflow: hidden;
	}
	.custom-table thead tr {
		background-color: #009879;
		color: #ffffff;
		text-align: center;
		font-weight: bold;
	}
	.custom-table th,
	.custom-table td {
		padding: 12px 15px;
	}
	.custom-table tbody tr {
		border-bottom: 1px solid #dddddd;
		border-left: 5px solid #009879;
		border-right: 5px solid #009879;
		text-align: center;
	}
	.custom-table tbody tr:nth-of-type(even) {
		background: #f3f3f3;
		width: 250px;
	}
	.custom-table tbody tr:last-of-type {
		border-bottom: 3px solid #009879;
	}
 	.custom-table tbody tr {
		cursor: pointer;
	}
	h2 {
		color: grey;
		width: 50%;
		height: 40px;
		padding-top: 15px;
		padding-bottom: 5px;
		text-align: center;
		background: rgba(0,0,0,0.05);
		border-radius: 5px;
		border-bottom: 2px solid green;
		margin-left: auto;
		margin-right: auto;
	}
	.chekout-button {
		margin-left: 42%;
	}
	.chekout-button button {
		padding: 15px 50px;
		background: white;
		color: #28282B;
		font-size: 20px;
		font-family: "DejaVu Serif";
		border-radius: 4px;
		border: 2px solid #28282B;
	}
	.chekout-button button:hover {
		background: #28282B;
		color: white;
	}
</style>
</head>
<body>
	<%@ include file="nav.dat" %>
	<table class="custom-table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Kind</th>
				<th>Price</th>
				<th>Cancel</th>
			</tr>
		</thead>
		<tbody>
			<%
			if (!cartItems.isEmpty()) {
				for (Product item: cartItems) {%>
				<tr>
					<td><%=item.getName()%></td>
					<td><%=item.getKind()%></td>
					<td><%=item.getPrice()%></td>
					<td><a href="cancelCartItem?id=<%=item.getId()%>">Cancel</a></td>
				</tr>
				<%
				}
			}	
			%>
		</tbody>
	</table> <br>
	<h2>Total Price: <%=Util.getTotalPrice(cartItems) %></h2> <br>
	<div class="chekout-button">
		<a href="checkOut"><button>Checkout</button></a>
	</div>
</body>
</html>