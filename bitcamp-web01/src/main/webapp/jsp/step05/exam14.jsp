<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jsp.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam14</title>
</head>
<body>
	<h1>JSTL - c:parseDate</h1>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
    <h2>다양한 형식의 문자열을 가지고 java.util.Date 객체 생성</h2>
    
    <c:choose>
        <c:when test="${param.type == 1}">
            <fmt:parseDate value="${param.date}" pattern="yyyy-MM-dd" var="d1"/>
        </c:when>
        <c:when test="${param.type == 2}">
            <fmt:parseDate value="${param.date}" pattern="MM/dd/yyyy" var="d1"/>
        </c:when>
        <c:otherwise>
            <c:set var="d1" value="유효한 형식이 아닙니다."/>
        </c:otherwise>
    </c:choose>
    
    날짜 = ${d1}<br>
    
</body>
</html>