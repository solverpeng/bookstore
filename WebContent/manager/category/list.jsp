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
	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>更新</th>	
			<th>删除</th>
		</tr>
		<c:if test="${!empty categoryList}">
			<c:forEach items="${categoryList }" var="category">
				<tr>
					<td>${category.categoryId }</td>
					<td>${category.categoryName }</td>
					<td>
						<a href="manager/CategoryServlet?method=toEditUI&categoryId=${category.categoryId }">更新</a>
						</td>
					<td>
						<a class="del" href="manager/CategoryServlet?method=del&categoryId=${category.categoryId}">删除</a>
					</td>	
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>