<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/css/styles.css"></link>
	<script src="/js/script.js"></script>	
</head>
<body>
	<div>
		<div class="navBarCell">
			Top Ten Songs
		</div>
		<div class="navBarCell">
			<a href="/dashboard">Dashboard</a>
		</div>
	</div>
	<ul>
		<c:forEach items="${songs}" var="song">
			<li>
				<c:out value="${song.rating}"/> - 
				<a href="/songs/${song.id}">
					<c:out value="${song.title}"/>
				</a> - 
				<c:out value="${song.artist}"/>
			</li>
		</c:forEach>
	</ul>
</body>
</html>