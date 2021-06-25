<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Index</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/styles.css"></link>
</head>
<body>
	<div class="wrapper">
		<div class="column">
		    <h3>Register</h3>
		    
		    <p class="formErrors"><form:errors path="user.*"/></p>
		    
		    <form:form method="POST" action="/registration" modelAttribute="user">
		    	<table class="formWrapper">
			    	<tr>
			    		<td>
			    			<form:label path="firstName">First Name:</form:label>
			    		</td>
			    		<td>
			    			<form:input path="firstName"/>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td>
			    			<form:label path="lastName">Last Name:</form:label>
			    		</td>
			    		<td>
			    			<form:input path="lastName"/>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td>
			    			<form:label path="email">Email:</form:label>
			    		</td>
			    		<td>
			    			<form:input path="email"/>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td>
			    			<form:label path="password">Password:</form:label>
			    		</td>
			    		<td>
			    			<form:password path="password"/>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td>
			    			<form:label path="passwordConfirmation">Password Confirmation:</form:label>
			    		</td>
			    		<td>
			    			<form:password path="passwordConfirmation"/>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td colspan="2" class="formButtons">
			    			<input type="submit" value="Register"/>
			    		</td>
			    	</tr>
		    	</table>
		    </form:form>
		</div>
		<div class="column">

		    <h3>Login</h3>
		    <p class="formErrors"><c:out value="${loginErrors}" /></p>
		    <form method="post" action="/login">
		    	<table class="formWrapper">
			    	<tr>
			    		<td>
			    			<label type="email" for="email">Email</label>
			    		</td>
			    		<td>
			    			<input type="text" id="email" name="email"/>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td>
			    			<label for="password">Password</label>
			    		</td>
			    		<td>
			    			<input type="password" id="password" name="password"/>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td colspan="2" class="formButtons">
			    			<input type="submit" value="Login"/>
			    		</td>
			    	</tr>
		    	</table>
		        
		    </form>    

		</div>
	</div>
</body>
</html>