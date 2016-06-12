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
<style type="text/css">
div {
	border: none;
}

table, td {
	border: none;
}
</style>
<c:set var="paramValue"
	value="&categoryId=${param.categoryId }&minPrice=${param.minPrice }&maxPrice=${param.maxPrice}&categoryName=${param.categoryName}"></c:set>
<script type="text/javascript" src="script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		$("#pageNoText").change(
			function() {
				var pageNo = $.trim(this.value);
				if (pageNo == "" || isNaN(pageNo)) {
					alert("pageNo不合法");
					return;
				}
				window.location.href = "${pageContext.request.contextPath}/client/BookClientServlet?method=getPage&pageNoStr="
						+ pageNo + "${paramValue}";
	
			});
	});
</script>
</head>
<body>

	<div class="centerTd">
		<c:choose>
			<c:when test="${!empty message}">
				${message}
			</c:when>
			<c:when test="${!empty sessionScope.cart && !sessionScope.cart.cartEmpty}">
				您的购物车中有${sessionScope.cart.totalCount}件商品
			</c:when>
			<c:otherwise>
				您的购物车中还没有商品
			</c:otherwise>
		</c:choose>
	</div>

	<div class="centerTd">
		<form action="client/BookClientServlet?method=getPage" method="post">
			价格 <input type="hidden" name="categoryId"
				value="${param.categoryId }" /> <input type="hidden"
				name="categoryName" value="${param.categoryName }" /> <input
				class="shortInp" type="text" name="minPrice"
				value="${param.minPrice }" />- <input class="shortInp" type="text"
				name="maxPrice" value="${param.maxPrice }" /> <input type="submit"
				value="查询" />
		</form>
	</div>
	<!-- 使用param获取值如果没有获取到返回的是null，不是空字符串 -->
	<div class="centerTd">当前分类：${(param.categoryName == null) ? "全部分类" : param.categoryName }</div>
	<table>
		<c:if test="${empty page.list }">
			<tr>
				<td colspan="2">没有获取到图书信息</td>
			</tr>
		</c:if>
		<c:if test="${!empty page.list }">
			<c:forEach items="${page.list }" var="book">
				<tr>
					<td><img alt="" src="${book.imgPath }"></td>
					<td>书名：<a
						href="client/BookClientServlet?method=getBook&bookId=${book.bookId }">${book.bookName }</a><br />
						作者：${book.author }<br /> 售价：${book.price }<br />
						库存：${book.storeNum }<br /> 销量：${book.salseAmount }<br />
						<a href="client/CartServlet?method=add2Cart&bookId=${book.bookId}">加入购物车</a>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div class="centerId">
		<c:if test="${page.hasPrev }">
			<a href="client/BookClientServlet?method=getPage&pageNoStr=1${paramValue}">首页</a>
			<a href="client/BookClientServlet?method=getPage&pageNoStr=${page.prev }${paramValue}">上一页</a>
		</c:if>
		共${page.totalPageNo }页&nbsp;当前是第${page.pageNo }页&nbsp;共${page.totalRecord }条记录
		<c:if test="${page.hasNext }">
			<a href="client/BookClientServlet?method=getPage&pageNoStr=${page.next }${paramValue}">下一页</a>
			<a href="client/BookClientServlet?method=getPage&pageNoStr=${page.totalPageNo }${paramValue}">末页</a>
		</c:if>

		跳转到第 <input type="text" class="shortInp" id="pageNoText" /> 页
	</div>
</body>
</html>