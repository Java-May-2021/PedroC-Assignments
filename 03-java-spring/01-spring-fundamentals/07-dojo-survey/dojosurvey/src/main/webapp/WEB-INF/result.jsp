<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Dojo Survey</title>
	<link rel="stylesheet" href="/css/styles.css" />
</head>
<body>
	<div class="result">
		<h3>Submitted Info</h3>
		<div class="row">
			<div class="col-left">Name:</div>
			<div class="col-right"><c:out value="${name}"/></div>
		</div>
		<div class="row">
			<div class="col-left">Dojo Location:</div>
			<div class="col-right"><c:out value="${location}"/></div>
		</div>
		<div class="row">
			<div class="col-left">Favorite Language:</div>
			<div class="col-right"><c:out value="${favlanguage}"/></div>
		</div>
		<div class="row">
			<div class="col-left">Comment:</div>
			<div class="col-right"><c:out value="${comment}"/></div>
		</div>
	</div>
</body>
</html>