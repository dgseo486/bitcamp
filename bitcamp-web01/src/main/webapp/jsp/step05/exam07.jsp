<%@page import="jsp.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam07</title>
</head>
<body>

	<h1>JSTL - c:choose</h1>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<c:set var="age" value="-10"/>
	<c:choose>
	   <c:when test="${age > 0 && age < 19}">
	       미성년입니다.
	   </c:when>
	   <c:when test="${age >= 19 and age < 65}">
           성년입니다.
       </c:when>
       <c:when test="${age >= 65}">
           노인입니다.
       </c:when>
	   <c:otherwise>
	       나이가 없거나 잘못된 값입니다.
	   </c:otherwise>
	</c:choose>
    
</body>
</html>