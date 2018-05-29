<%@page import="jsp.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam06</title>
</head>
<body>

	<h1>JSTL - c:if</h1>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<c:if test="${20 < 25}" var="r1" scope="page"/>
	r1 : ${pageScope.r1}<br>
	
	<c:set var="age" value="17"/>
	
	<c:if test="${age < 19}">
	   미성년입니다.
	</c:if>
	
	<c:if test="${age > 19}">
       성년입니다.
    </c:if>
    
</body>
</html>