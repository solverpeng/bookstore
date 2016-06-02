<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base
	href="http://${pageContext.request.serverName }:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/style.css" />
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		var backEle = document.getElementById("back");
		backEle.onclick = function() {
			window.history.back();	
		}
	};
</script>
</head>
<body>
	${book.bookId }
	<img class="bookImg" src="${book.imgPath }"/> <br /><br />
	书名：${book.bookName }<br />
	作者：${book.author }	<br />
	价格：${book.price }<br />	
	销量：${book.salseAmount }<br />
	<button id="back">返回</button>
</body>
</html>