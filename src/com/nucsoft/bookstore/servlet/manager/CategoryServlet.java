package com.nucsoft.bookstore.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nucsoft.bookstore.bean.Category;
import com.nucsoft.bookstore.service.impl.CategoryServiceImpl;
import com.nucsoft.bookstore.service.inter.CategoryService;
import com.nucsoft.bookstore.servlet.BaseServlet;
import com.nucsoft.bookstore.utils.WebUtil;

public class CategoryServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	private CategoryService categoryService = new CategoryServiceImpl();
	
	protected void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Category> list = categoryService.getList();
		WebUtil.sendData(req, resp, "categoryList", list, "/manager/category/list.jsp");
	}
	protected void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Category category = WebUtil.param2Bean(req, Category.class);
		categoryService.save(category);
		WebUtil.sendMessage(req, resp, "保存成功!");
	}
	protected void toEditUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String categoryId = req.getParameter("categoryId");
		Category category = categoryService.getCategoryById(categoryId);
		WebUtil.sendData(req, resp, "category", category, "/manager/category/edit.jsp");
	}
	protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Category category = WebUtil.param2Bean(req, Category.class);
		categoryService.update(category);
		WebUtil.sendMessage(req, resp, "更新成功！");
	}
	protected void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String categoryId = req.getParameter("categoryId");
		categoryService.delete(categoryId);
		WebUtil.sendMessage(req, resp, "删除成功!");
	}

}
