<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin Home</title>
<link rel="stylesheet" type"text/css" href="./style/style.css" />
</head>
<body>
	<header> <span> truYum </span> <img class="img"
		src="./images/truyum-logo-light.png" /> <a id="menu"
		href="ShowMenuItemListAdmin">Menu</a> </header>
	<div class="cont">
		<h2>Menu Items</h2>
		<table class="table">
			<tr>
				<th class="title-name">Name</th>
				<th class="title-price">Price</th>
				<th class="title-txt">Active</th>
				<th class="title-txt">Date Of Launch</th>
				<th class="title-txt">Category</th>
				<th class="title-txt">Free Delivery</th>
				<th class="title-txt">Action</th>
			</tr>
			<c:forEach items="${ menuItemList}" var="menuItem">
				<tr>
					<td class="title-name">${menuItem.name}</td>
					<td class="title-price">Rs.${menuItem.price}</td>
					<td class="title-txt"><c:if test="${menuItem.active}">Yes</c:if>
										  <c:if test="${!menuItem.active}">No</c:if></td>

					<td class="title-text"><fmt:formatDate pattern="dd/MM/yyyy"
							value="${menuItem.dateOfLaunch}" /></td>

					<td class="title-txt">${menuItem.category}</td>
					<td class="title-txt"><c:if test="${menuItem.freeDelivery}">Yes</c:if>
						<c:if test="${!menuItem.freeDelivery}">No</c:if></td>

					<td class="title-txt"><a
						href="ShowEditMenuItem?id=${menuItem.id }">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<footer> <span>Copyright @ 2019</span> </footer>
</body>
</html>



