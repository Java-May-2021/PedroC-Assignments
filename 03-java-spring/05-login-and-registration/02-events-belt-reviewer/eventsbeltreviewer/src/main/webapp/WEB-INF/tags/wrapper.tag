<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="app-header">
	<div class="app-name">
		Events Planner
	</div>
	<div class="app-links">
	
	<c:choose>
		<c:when test="${loggedIn}">
			<a href="/logout">Logout</a>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
            	
	</div>
</div>
<jsp:doBody/>
