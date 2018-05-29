<%@page import="jsp.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam08</title>
</head>
<body>

	<h1>JSTL - c:forEach</h1>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<h2>14에서 20까지 반복하기</h2>
	
	<p>
	<c:forEach begin="14" end="20" var="no">
	   ${pageScope.no},
	</c:forEach>
	</p>
	
    <p>
    <c:forEach begin="14" end="20" var="no" step="3">
       ${pageScope.no},
    </c:forEach>
    </p>
    
    <h2>배열 반복하기</h2>
    <%pageContext.setAttribute("names", 
            new String[]{"홍길동", "임꺽정", "유관순", "안중근", "윤봉길", "김구", "신채호", "김원봉"}); %>
    <p>
    <c:forEach items="${names}" begin="2" end="5" var="name">
       ${pageScope.name},
    </c:forEach>
    </p>
    
    <p>
    <c:forEach items="${names}" end="5" var="name">
       ${pageScope.name},
    </c:forEach>
    </p>
    
    <p>
    <c:forEach items="${names}" begin="2" var="name">
       ${pageScope.name},
    </c:forEach>
    </p>
    
    <p>
    <c:forEach items="${names}" var="name">
       ${pageScope.name},
    </c:forEach>
    </p>
    
</body>
</html>