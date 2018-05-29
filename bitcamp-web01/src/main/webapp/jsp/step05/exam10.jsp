<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jsp.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam10</title>
</head>
<body>

	<h1>JSTL - c:forTokens</h1>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
    <h2>콤마로 구분된 문자열 반복하기</h2>
    
    <c:forTokens items="${'홍길동,임꺽정,유관순,안중근,윤봉길'}" var="name" delims=",">
       ${pageScope.name},
    </c:forTokens>
    
    <h2>다른 문자로 구분된 문자열 반복하기</h2>
    <c:forTokens items="${'홍길동^^임꺽정^^유관순^^안중근^^윤봉길'}" var="name" delims="^^">
       ${pageScope.name},
    </c:forTokens>
    
    
</body>
</html>