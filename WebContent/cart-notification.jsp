<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
	<head>
		<title>Cart Notifications</title>
			<link rel="stylesheet" type="text/css" href="./style/style.css"/>
	</head>
	<body>
		<header><span>truYum</span>
				<img class="img" src="./images/truyum-logo-light.png" / >
				<a id="menu" href="ShowCart">Cart</a>
				<a id="menu" href="ShowMenuItemListCustomer">Menu</a>
		</header>
	<div class="cont">
		<h2> Cart</h2>
		<p> Item removed from Cart successfully</p>
		<table class="tale">
			<tr>
				<th class="title-name">Name</th>
				<th class="title-name">Free Delivery</th>
				<th>Price</th>
				<th></th>
			</tr>
		<c:forEach items="${menuItemListCustomer}" var="menuItem">
				<tr>
					<td class="title-name">${menuItem.name}</td>
					
					 <td class="title-txt"><c:if test="${menuItem.freeDelivery}">Yes</c:if> <c:if test="${!menuItem.freeDelivery}">No</c:if></td>
					
					<td class="title-price">Rs.${menuItem.price}</td>
					
					<td class="title-txt"><a href="RemoveCart?id=${menuItem.id }">Delete</a></td>
				</tr>
			</c:forEach>
			<th></th>
					<th class="title-name">Total</th>
					<th class="title-price">Rs.${total}</th>
					<th></th>
		</table>
	</div>
 <footer>
	<span>Copyright@2019</span>
</footer>
	</body>
</html>


