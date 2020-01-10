<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
    <head>
        <title>Edit Menu Item </title>
           <link rel="stylesheet" type"text/css" href="./style/style.css"/>
		   <script src="./js/script.js" type="text/javascript"></script>
    </head>
	<body>
		<header><span id="head">truYum</span>
			<img class="img" src="./images/truyum-logo-light.png"/> 
			<a id="menu" href="ShowMenuItemListAdmin" >Menu</a>
		</header>
	<div>
		<h2>Edit Menu Item</h2>
			<form class="cont" name="form" onSubmit="return validation()" method="post" action="EditMenuItem?id=${menuItem.id }">
				<table>
					<tr>
						<td colspan="4"><label for="txtName"> Name</label></td>
					</tr>
					<tr>
						<td colspan="4"><input type="text" id="txtName" name="txtName" size="80" value="${menuItem.name}"></td>
					</tr>
					<tr>
						<td><label for="txtPrice">Price(Rs.)</label></td>
						<td>Active</td>
						<td><label for="txtDoB">Date of Launch</label></td>
						<td><label for="Category">Category</label></td>
					</tr>
					<tr>
						<td><input type="text" class="title-price" id="txtPrice" name="txtPrice" value="${menuItem.price}"></td>
						
						<td><label for="rdYes"><input type="radio" id ="rdYes" name="rdYes"	value="Yes"<c:if test="${ menuItem.active eq 'true'}"> checked="checked"</c:if>>Yes</label>
					
						<label for="rdNo"><input type="radio" id="rdNo" name="rdYes" value="No"<c:if test="${ menuItem.active eq 'false'}"> checked="checked"</c:if>>No</label></td>
						
						<td><fmt:formatDate type="date" pattern = "dd/MM/yyyy" value= "${movie.dateOfLaunch}" var="format" /><input type="text" id="txtDoB" name="txtDoB"  value="${format }"></td>
						
						<td><select name="category" id="category">
							<option value="${menuItem.category}">${menuItem.category}</option>
							<option value="Starters">Starters</option>
							<option value="Main Corse">Main course</option>
							<option value="Deserts">Deserts</option>
							<option value="Drinks">Drinks</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2"><label for ="cbDelivery"><input type="checkbox" id="cbDelivery" name="cbDelivery" 
						<c:if test="${menuItem.freeDelivery eq 'true'}">Checked</c:if>>
						<c:if test="${menuItem.freeDelivery eq 'false'}"> </c:if>Free Delivery</label></td>	
					</tr>
					<tr>
						<td  colspan="2"><input class="color" type="submit" value="Save" ></td>
					</tr>
				</table>
			</form>
	</div>	
<footer>
	<span>Copyright@2019</span>
</footer>
	</body>
</html>


