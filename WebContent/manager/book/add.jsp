<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="http://${pageContext.request.serverName }:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="manager/BookServlet?method=save" method="post">
		图书名称：<input type="text" name="bookName" /><br>
		作者：<input type="text" name="author" /><br>
		价格：<input type="text" name="price" /><br>
		库存：<input type="text" name="storeNum" /><br>
		销量：<input type="text" name="salseAmount" /><br>
		分类：<select name="categoryId">
				<c:forEach items="${categoryList }" var="category">
					<option value="${category.categoryId }">${category.categoryName }</option>
				</c:forEach>
			</select>
			<br>
		<input type="submit" value="添加" />
	</form>
</body>
</html>