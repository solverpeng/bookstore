package com.nucsoft.bookstore.servlet.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nucsoft.bookstore.bean.Category;
import com.nucsoft.bookstore.service.impl.CategoryServiceImpl;
import com.nucsoft.bookstore.service.inter.CategoryService;
import com.nucsoft.bookstore.utils.WebUtil;


public class ClientServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private CategoryService categoryService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		if("toClientUI".equals(method)) {
			List<Category> list = categoryService.getList();
			WebUtil.sendData(req, resp, "categoryList", list, "/client/client.jsp");
		}
	}

}
