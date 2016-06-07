package com.nucsoft.bookstore.servlet.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nucsoft.bookstore.bean.User;
import com.nucsoft.bookstore.service.impl.UserServiceImpl;
import com.nucsoft.bookstore.service.inter.UserService;
import com.nucsoft.bookstore.servlet.BaseServlet;
import com.nucsoft.bookstore.utils.WebUtil;

public class UserServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
	
	protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("loginUser");
	
		resp.sendRedirect(req.getContextPath() + "/index.jsp");
	
	}

	protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = WebUtil.param2Bean(req, User.class);
		User queryUser = userService.login(user);

		if (queryUser == null) {
			// 登录失败
			req.setAttribute("message", "用户或密码不正确");
			req.getRequestDispatcher("/client/user/login.jsp").forward(req, resp);
		} else {
			// 登录成功
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", queryUser);
			resp.sendRedirect(req.getContextPath() + "/client/user/login-success.html");
		}
	}

	protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object code = session.getAttribute("CODE");
		String codeParam = req.getParameter("codeParam");
		
		if(codeParam != null && !codeParam.equalsIgnoreCase(code.toString())) {
			req.setAttribute("message", "验证码不正确");
			WebUtil.sendData(req, resp, "message", "验证码不正确", "/client/user/regist.jsp");
			return ;
		}
		
		session.removeAttribute("CODE");
		
		User user = WebUtil.param2Bean(req, User.class);
		boolean isSuccess = userService.regist(user);
		if (isSuccess) {
			req.getRequestDispatcher("/client/user/login.jsp").forward(req, resp);
		} else {
			req.setAttribute("message", "用户名已存在!");
			req.getRequestDispatcher("/client/user/regist.jsp").forward(req, resp);
		}
	}

}