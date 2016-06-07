<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base
	href="http://${pageContext.request.serverName }:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty historyMap }">
		目前木有浏览记录	<br/>
	</c:if>
	<c:if test="${!empty historyMap }">
		<c:forEach items="${historyMap }" var="entry">
			${entry.value }&nbsp;<a href="client/BookClientServlet?method=getBook&bookId=${entry.key }">查看图书详细信息</a><br><br>
		</c:forEach>
	</c:if>
	<a href="client/BookClientServlet?method=clearHistory">清除浏览记录</a>
</body>
</html>