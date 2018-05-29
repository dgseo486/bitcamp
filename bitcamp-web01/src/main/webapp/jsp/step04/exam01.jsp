<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam01</title>
</head>
<body>
<h1>EL(Expression Language)</h1>

<%
pageContext.setAttribute("name", "홍길동");
pageContext.setAttribute("age", 20);
%>
${pageScope.name}<br>
${pageScope["name"]}<br>
${pageScope['name']}<br>

${pageScope.age}<br>

해당 객체나 프로퍼티를 찾을 수 없으면 null이 아닌 빈 문자열이 리턴된다.<br>
${pageScope.tel}<br>

</body>
</html>