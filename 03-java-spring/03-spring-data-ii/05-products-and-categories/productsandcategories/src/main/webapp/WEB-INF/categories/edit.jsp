<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit Category</title>
	<link rel="stylesheet" href="/css/styles.css"></link>
	<script src="/js/script.js"></script>	
</head>
<body>
	<h1>
		<c:out value="${category.name}"/>
	</h1>
	<table class="row">
	<tr>
		<td>
			<span>
				Products:
			</span>	
			<ul>
				<c:forEach var="product" items="${associatedProducts}">
				   <li>
				   	${product.name}
				   </li>
				</c:forEach>
			</ul>
		</td>
		<td>
			<form:form action="/categories/${category.id}" method="post">
			    <input type="hidden" name="_method" value="post">
			    Add Product:
				<select name="productId">
					<c:forEach var="product" items="${availableProducts}">
					   <option value="${product.id}">
					   	<c:out value="${product.name}"/>
					   </option>
					</c:forEach>
				</select>
				<div>
				    <input type="submit" value="Add"/>
				</div>
			</form:form>
		</td>
	</tr>
	</table>
</body>
</html>