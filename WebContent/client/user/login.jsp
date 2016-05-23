<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="http://${pageContext.request.serverName }:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style/style.css" />
<script type="text/javascript">
	window.onload = function(){
		//1.为提交按钮绑定一个单击响应函数
		var subBtn = document.getElementById("subBtn");
		subBtn.onclick = function(){
			
			//获取用户输入的用户名和密码
			var nameStr = document.getElementsByName("userName")[0].value;
			var pwdStr = document.getElementsByName("password")[0].value;
			
			//对用户名和密码进行判断
			
			//对用户名进行验证
			var nameReg = /^[a-zA-Z0-9_]{3,16}$/;
			var flag = nameReg.test(nameStr); 
			if(!flag){
				alert("请输入正确的用户名3-16位大写或小写字母，数字或者下划线");
				return false;
			}
			
			//对密码进行验证
			var pwdReg = /^[a-zA-Z0-9_]{6,18}$/;
			flag = pwdReg.test(pwdStr);
			if(!flag){
				alert("请输入正确的密码6-18位大写或小写字母，数字或者下划线");
				return false;
			}
			
		};
	};
</script>
</head>
<body>
	${message }
	<form action="client/UserServlet?method=login" method="post">
		<table>
			<tr>
				<td colspan="2">用户登录</td>
			</tr>
			
			<tr>
				<td>用户名：</td><td><input type="text" name="userName" value="${param.userName }"/> </td>
			</tr>
			
			<tr>
				<td>密码：</td><td><input type="password" name="userPwd" /> </td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="登录" id="subBtn"/>
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>