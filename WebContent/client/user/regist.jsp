<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="http://${pageContext.request.serverName }:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style/style.css" />
<script type="text/javascript" src="script/jquery-1.7.2.js"></script>
<script type="text/javascript">

	$(function(){
		
		//表单验证：对表单元素中填写的内容进行检查，如果满足既定规则则允许提交，否则不能提交
		$(":submit").click(function(){
			
			//1.用户名验证 /^[a-z0-9_-]{3,16}$/
			//①获取用户名文本框中的输入内容
			var userName = $.trim($("input[name=userName]").val());
			
			//去掉前后空格后再将文本内容写回文本框
			$("input[name=userName]").val(userName);
			
			//②使用正则表达式检查用户名是否满足规则
			var userNameReg = /^[a-zA-Z0-9_-]{3,16}$/;
			
			//③如果不满足则阻止表单提交
			if(!userNameReg.test(userName)) {
				alert("用户名不合法");
				return false;
			}
			
			//2.密码验证 /^[a-z0-9_-]{6,18}$/
			var userPwd = $.trim($("input[name=userPwd]").val());
			$("input[name=userPwd]").val(userPwd);
			
			var userPwdReg = /^[a-z0-9_-]{6,18}$/;
			if(!userPwdReg.test(userPwd)) {
				
				alert("密码不合法");
				return false;
				
			}
			
			//3.确认密码 和密码一致
			var repwd = $.trim($("input[name=repwd]").val());
			$("input[name=repwd]").val(repwd);
			if(userPwd != repwd) {
				alert("两次输入的密码必须一致");
				return false;
			}
			
			//4.Email 可以为空
			// /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/
			var email = $.trim($("input[name=email]").val());
			$("input[name=email]").val(email);
			
			//去掉前后空格后不等于空字符串，表示有非空的字符，需要进行验证
			if(email != "") {
				
				var emailReg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
				
				if(!emailReg.test(email)) {
					alert("Email格式不正确");
					return false;
				}
				
			}
			
		});
		
	});

</script>
</head>
<body>
	${message }
	<form action="client/UserServlet?method=regist" method="post">
		<table>
			<tr>
				<td colspan="2">用户注册</td>
			</tr>
			
			<tr>
				<td>用户名：</td><td><input type="text" name="userName" value="${param.userName }"/> </td>
			</tr>
			
			<tr>
				<td>密码：</td><td><input type="password" name="userPwd" value="123456" /> </td>
			</tr>
			
			<tr>
				<td>确认密码：</td><td><input type="password" name="repwd" value="123456" /> </td>
			</tr>
			
			<tr>
				<td>电子邮件：</td><td><input type="text" name="email" /> </td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="注册" />
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>