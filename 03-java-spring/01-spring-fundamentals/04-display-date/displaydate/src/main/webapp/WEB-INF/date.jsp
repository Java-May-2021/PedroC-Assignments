<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Display Date</title>
	<link rel="stylesheet" href="/css/style.css"></link>
    <script src="/js/date.js"></script>
</head>
<body>
	<div class="date">
		<c:out value="${dateAsStr}"/>
	</div>
</html>