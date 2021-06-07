<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New License</title>
	<link rel="stylesheet" href="/css/styles.css"></link>
	<script src="/js/script.js"></script>	
</head>
<body>

	<h1>
		New License
	</h1>
	
	<form:form action="/licenses/new" method="post" modelAttribute="license">
	    <input type="hidden" name="_method" value="post">
	    
	    <p>
	        <form:label path="person">Person</form:label>
	        <form:errors path="person"/>
			<form:select path="person">
			   <form:option value="0" label="Please select a person"/>
				<c:forEach var="person" items="${persons}">
				   <form:option value="${person.id}" label="${person.firstname} ${person.lastname}"/>
				</c:forEach>
			</form:select>
	    </p>
	    <p>
	        <form:label path="state">State</form:label>
	        <form:errors path="state"/>
	        <form:select path="state" items="${states}"/>
	    </p>
	    <p>
	        <form:label path="expiration">Expiration Date</form:label>
	        <form:errors path="expiration"/>
			<fmt:formatDate value="${license.expiration}" var="dateString" pattern="dd/MM/yyyy" />
	        <form:input type="date" path="expiration" value="${dateString}" />
	    </p>
	    <input type="submit" value="Create"/>
	</form:form>

</body>
</html>