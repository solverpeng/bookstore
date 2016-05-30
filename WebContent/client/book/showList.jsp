<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="http://${pageContext.request.serverName }:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/style.css" />
<title>Insert title here</title>
<style type="text/css">
	div {
		border: none;
	}
	
	table, td {
		border: none;
	}
</style>
<script type="text/javascript" src="script/jquery-1.7.2.js"></script> 
<script type="text/javascript">
	$(function() {
		$("#pageNoText").change(function() {
			var pageNo = $.trim(this.value);
			if(pageNo == "" || isNaN(pageNo)) {
				alert("pageNo不合法");
				return ;
			}
			window.location.href = "${pageContext.request.contextPath}/client/BookClientServlet?method=getPage&pageNoStr=" + pageNo;
		});		
	});
</script>
</head>
<body>
	<table>
		<c:if test="${empty page.list }">
			<tr>
				<td colspan="2">没有获取到图书信息</td>
			</tr>
		</c:if>
		<c:if test="${!empty page.list }">
			<c:forEach items="${page.list }" var="book">
				<tr>
					<td>
						<img alt="" src="${book.imgPath }">	
					</td>
					<td>
						书名：<a href="client/BookClient?method=&bookId=${book.bookId }">${book.bookName }</a><br/>
						作者：${book.author }<br/>
						售价：${book.price }<br/>
						库存：${book.storeNum }<br/>
						销量：${book.salseAmount }<br/>
						<a href="#">加入购物车</a>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div class="centerId">
		<c:if test="${page.hasPrev }">
			<a href="client/BookClientServlet?method=getPage&pageNoStr=1">首页</a>
			<a href="client/BookClientServlet?method=getPage&pageNoStr=${page.prev }">上一页</a>
		</c:if>
		共${page.totalPageNo }页&nbsp;当前是第${page.pageNo }页&nbsp;共${page.totalRecord }条记录
		<c:if test="${page.hasNext }">
			<a href="client/BookClientServlet?method=getPage&pageNoStr=${page.next }">下一页</a>
			<a href="client/BookClientServlet?method=getPage&pageNoStr=${page.totalPageNo }">末页</a>
		</c:if>
		
		跳转到第 <input type="text" class="shortInp" id="pageNoText"/> 页
	</div>
</body>
</html>