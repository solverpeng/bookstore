<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="http://${pageContext.request.serverName }:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style/style.css" />
</head>
<body>
	<div id="header">
		<h1 id="welcome">网上书城</h1>
		<div id="login">
			<a href="client/user/login.jsp" target="myIframe">登陆</a>|<a href="client/user/regist.jsp" target="myIframe">注册</a>
		</div>
	</div>
	<div id="main_div">
		<div id="left_div">
			<h3>全部分类</h3>
			<c:if test="${!empty categoryList }">
				<c:forEach items="${categoryList }" var="category">
					<a href="client/BookClientServlet?method=getPage&categoryId=${category.categoryId }&categoryName=${category.categoryName}" target="myIframe">${category.categoryName }</a> <br /><br />
				</c:forEach>	
			</c:if>
			<br><br>
			<a href="manager/manager.jsp">进入后台</a> <br /><br />
		</div>
		<div id="right_div">
			<iframe src="client/BookClientServlet?method=getPage" name="myIframe"></iframe>
		</div>
	</div>
</body>
</html>