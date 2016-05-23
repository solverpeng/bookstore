<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base
	href="http://${pageContext.request.serverName }:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="manager/BookServlet?method=update" method="post">
		<input type="hidden" name="bookId" value="${book.bookId }" /><br> 
		图书名称：<input type="text" name="bookName" value="${book.bookName }"/><br> 
		作者：<input type="text" name="author" value="${book.author }"/><br> 
		价格：<input type="text" name="price" value="${book.price }" /><br> 
		库存：<input type="text" name="storeNum" value="${book.storeNum }" /><br> 
		销量：<input type="text" name="salseAmount" value="${book.salseAmount }" /> <br>
		分类：<select name="categoryId">
			<c:forEach items="${categoryList }" var="category">
				<option value="${category.categoryId }"
					<c:if test="${book.categoryId == category.categoryId }">selected="selected"</c:if>>
					${category.categoryName }
				</option>
			</c:forEach>
			</select>
			<br>
		<input type="submit" value="更新" />
	</form>
</body>
</html>