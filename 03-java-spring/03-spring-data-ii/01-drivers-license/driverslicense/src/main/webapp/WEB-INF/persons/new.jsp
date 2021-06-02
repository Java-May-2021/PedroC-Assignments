<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Person</title>
	<link rel="stylesheet" href="/css/styles.css"></link>
	<script src="/js/script.js"></script>	
</head>
<body>

	<h1>
		New Person
	</h1>
	
	<form:form action="/persons/new" method="post" modelAttribute="person">
	    <input type="hidden" name="_method" value="post">
	    <p>
	        <form:label path="firstname">First Name</form:label>
	        <form:errors path="firstname"/>
	        <form:input path="firstname"/>
	    </p>
	    <p>
	        <form:label path="lastname">Last Name</form:label>
	        <form:errors path="lastname"/>
	        <form:input path="lastname"/>
	    </p>
	    <input type="submit" value="Create"/>
	</form:form>

</body>
</html>