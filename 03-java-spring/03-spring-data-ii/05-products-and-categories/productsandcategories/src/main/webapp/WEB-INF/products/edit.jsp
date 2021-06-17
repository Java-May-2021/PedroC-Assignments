<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit Product</title>
	<link rel="stylesheet" href="/css/styles.css"></link>
	<script src="/js/script.js"></script>	
</head>
<body>
	<h1>
		<c:out value="${product.name}"/>
	</h1>
	<table class="row">
	<tr>
		<td>
			<span>
				Categories:
			</span>	
			<ul>
				<c:forEach var="category" items="${associatedCategories}">
				   <li>
				   	${category.name}
				   </li>
				</c:forEach>
			</ul>
		</td>
		<td>
			<form:form action="/products/${product.id}" method="post">
			    <input type="hidden" name="_method" value="post">
			    Add Category:
				<select name="categoryId">
					<c:forEach var="category" items="${availableCategories}">
					   <option value="${category.id}">
					   	<c:out value="${category.name}"/>
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