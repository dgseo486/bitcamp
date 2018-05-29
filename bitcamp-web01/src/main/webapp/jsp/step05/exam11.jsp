<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jsp.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam11</title>
</head>
<body>
	<h1>JSTL - c:url</h1>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <h2>값을 포함하고 있는 복잡한 URL 만들기</h2>
    <c:url value="http://localhost:8888/java-project/member/add" var="url1" scope="page">
        <c:param name="id" value="value01"/>
        <c:param name="email" value="value01@test.com"/>
        <c:param name="password" value="1111"/>
    </c:url>
    
    <a href="${url1}">회원 등록</a>
    
</body>
</html>