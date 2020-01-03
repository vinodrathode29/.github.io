<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
	<head>
		<title>Menu Item List Customer</title>
		<link rel="stylesheet" type="text/css" href="./style/style.css"/>
	</head>             
	<body>
		<header><span>truYum</span>
			<img class="img" src="./images/truyum-logo-light.png" / > 
			<a id="menu" href="ShowCart">Cart</a>
			<a id="menu" href="ShowMenuItemListCustomer">Menu</a>
		</header>
	<div class="cont">
		<h2>Menu Items</h2>
		<p> Item added to Cart Successfully</p>
		<table class="table">
			<tr>
				<th class="title-name">Name</th>
				<th class="title-txt">Free Delivery</th>
				<th class="title-price">Price</th>
				<th>Category</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${ menuItemList}" var="menuItem">
				<tr>
					<td class="title-name">${menuItem.name}</td>
					
					 <td class="title-txt"><c:if test="${menuItem.freeDelivery}">Yes</c:if> <c:if test="${!menuItem.freeDelivery}">No</c:if></td>
					
					<td class="title-price">Rs.${menuItem.price}</td>
					
					<td class="title-txt">${menuItem.category}</td>
					
					<td class="title-txt"><a href="AddToCart?menuItemId=${menuItem.id }">Add to Cart</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
<footer>
   <span>Copyright@2019</span>
</footer>
	</body>
</html>


