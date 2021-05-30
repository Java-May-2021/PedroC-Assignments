<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/css/styles.css"></link>
	<script src="/js/script.js"></script>	
</head>
<body>
	<a href="/languages">Dashboard</a>
	<h1><c:out value="${language.name}"/></h1>
	<p>Creator: <c:out value="${language.creator}"/></p>
	<p>Current Version: <c:out value="${language.currentVersion}"/></p>
	<a href="/languages/${language.id}/edit">Edit</a>
	<form action="/languages/${language.id}" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete">
	</form>	
</body>
</html>