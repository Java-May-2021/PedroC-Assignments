<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>The code</title>
</head>	
<body>
	<form method="POST" action="/code">
		<div >
			<c:out value="${trainharder}"/>
		</div>
		<div >
			What is the code?
		</div>
		<div >
			<input type="text" name="thecode" />
		</div>
		<div >
			<button>Try Code</button>
		</div>
	</form>
</body>
</html>