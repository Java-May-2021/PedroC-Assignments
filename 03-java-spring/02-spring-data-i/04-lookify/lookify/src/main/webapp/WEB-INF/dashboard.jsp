<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/css/styles.css"></link>
	<script src="/js/script.js"></script>	
</head>
<body>
	<div>
		<div class="navBarCell dashboardCell ${mode}">
			<a href="/songs/new">Add New</a>
		</div>
		<div class="navBarCell dashboardCell ${mode}">
			<a href="/search/topTen">Top Songs</a>
		</div>
		<div class="navBarCell searchCell ${mode}">
			Songs by artist <c:out value="${searchTerm}"/>
		</div>
		<div class="navBarCell">
			<input id="artistSearch" type="text" name="artist" value="${searchTerm}" />
			<input type="submit" onclick="search()" value="New Search" />
		</div>
		<div class="navBarCell searchCell ${mode}">
			<a href="/dashboard">Dashboard</a>
		</div>
	</div>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${songs}" var="song">
				<tr>
					<td>
						<a href="/songs/${song.id}">
							<c:out value="${song.title}"/>
						</a>
					</td>
					<td>
						<c:out value="${song.rating}"/>
					</td>
					<td>
						<form action="/songs/${song.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete">
						</form>	
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>