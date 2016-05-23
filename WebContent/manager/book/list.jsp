<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="http://${pageContext.request.serverName }:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		$('.del').click(function() {
			var categoryName = $(this).parents("tr").find("td:eq(1)").text();
			var result = confirm("确定要删除【" + categoryName + "】吗？");
			if(!result) {
				return false;
			}
		});
	});
</script>
</head>
<body>
	<table border="1" cellpadding="2" cellspacing="0">
		<tr align="center">
			<th>ID</th>
			<th>NAME</th>
			<th>AUTHOR</th>
			<th>PRICE</th>
			<th>STORENUM</th>
			<th>SALSEAMOUNT</th>
			<th>IMG</th>
			<th>更新</th>	
			<th>删除</th>
		</tr>
		<c:if test="${!empty bookList}">
			<c:forEach items="${bookList }" var="book">
				<tr align="center">
					<td>${book.bookId }</td>
					<td>${book.bookName }</td>
					<td>${book.author }</td>
					<td>${book.price }</td>
					<td>${book.storeNum }</td>
					<td>${book.salseAmount }</td>
					<td><a href="images/connan2.jpg">查看封面</a></td>
					<td>
						<a href="manager/BookServlet?method=toEditUI&id=${book.bookId }">更新</a>
						</td>
					<td>
						<a class="del" href="manager/BookServlet?method=delete&id=${book.bookId }">删除</a>
					</td>	
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>