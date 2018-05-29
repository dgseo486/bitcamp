<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam02</title>
</head>
<body>
<h1>EL에서 저장소를 사용하는 방법 1</h1>

<%
pageContext.setAttribute("name", "홍길동");
request.setAttribute("name", "임꺽정");
session.setAttribute("name", "유관순");
application.setAttribute("name", "윤봉길");
%>
PageContext: ${pageScope.name}<br>
PageContext: <%=pageContext.getAttribute("name")%><br>

ServletRequest: ${request.name}<br>
ServletRequest: <%=request.getAttribute("name")%><br>

HttpSession: ${sessionScope.name}<br>
HttpSession: <%=session.getAttribute("name")%><br>

ServletContext: ${applicationScope.name}<br>
ServletContext: <%=application.getAttribute("name")%><br>

<h2>expression element vs EL</h2>
<input type="text" value="<%=request.getAttribute("name")%>"><br>
<input type="text" value="${requestScope.name}"><br>

</body>
</html>