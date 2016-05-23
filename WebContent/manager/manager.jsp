<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	</div>
	<div id="main_div">
		<div id="left_div">
			<h3>分类管理</h3>
			<a href="manager/category/add.jsp" target="myIframe">添加分类</a> <br /><br />
			<a href="manager/CategoryServlet?method=showList" target="myIframe">查看分类</a> <br /><br />
			<br><br>
			<a href="manager/BookServlet?method=toAddUI" target="myIframe">添加图书</a> <br /><br />
			<a href="manager/BookServlet?method=showList" target="myIframe">查看图书</a> <br /><br />
			<br><br>
			<a href="client/ClientServlet?method=toClientUI">进入前台</a> <br /><br />
		</div>
		<div id="right_div">
			<iframe src="manager/default.html" name="myIframe"></iframe>
		</div>
	</div>
</body>
</html>