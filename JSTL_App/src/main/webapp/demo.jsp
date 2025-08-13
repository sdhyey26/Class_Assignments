<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>	
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <b><c:out value="25" /></b>
    <br />

    <c:set var="name" value="dhyey" />

    <c:out value="${name}" />
    <br />

    <c:if test="${name == 'swapnil'}">
        <p>Hello Swapnil</p>
    </c:if>
    
    <c:if test="${name == 'admin'}">
            <c:redirect url="Admin.jsp" />
    </c:if>
    
    <c:choose>
        <c:when test="${name == 'swapnil'}">
            <p>Hello Swapnil</p>
        </c:when>

        <c:when test="${name == 'swapnil12'}">
            <p>Hello Swapnil12</p>
        </c:when>

        <c:otherwise>
            <p>Hello Guest</p>
        </c:otherwise>
    </c:choose>
    
    <c:set var="names" value="${fn:split('Dhyey,Rishit,Ashish,Harshad', ',')}" />
    
    
	<ul>
	<c:forEach var="name" items="${names}">
	<li>${name}</li>
	</c:forEach>
	</ul>
	 
</body>
</html>