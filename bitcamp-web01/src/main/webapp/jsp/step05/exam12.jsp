<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jsp.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam12</title>
</head>
<body>
	<h1>JSTL - c:import</h1>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
    <h2>HTTP 요청을 수행한 후 그 결과를 가져오기</h2>
    <c:url value="http://www.zdnet.co.kr/news_view.asp" var="url1" scope="page">
        <c:param name="article_id" value="20180528085226"/>
        <c:param name="lo" value="z36"/>
    </c:url>
    
    <c:import url="${url1}" var="result" scope="page"/>
    
    <textarea cols="80" rows="15">${pageScope.result}</textarea>
    
</body>
</html>