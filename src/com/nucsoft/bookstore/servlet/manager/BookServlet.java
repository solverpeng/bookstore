package com.nucsoft.bookstore.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nucsoft.bookstore.bean.Book;
import com.nucsoft.bookstore.bean.Category;
import com.nucsoft.bookstore.service.impl.BookServiceImpl;
import com.nucsoft.bookstore.service.impl.CategoryServiceImpl;
import com.nucsoft.bookstore.service.inter.BookService;
import com.nucsoft.bookstore.service.inter.CategoryService;
import com.nucsoft.bookstore.servlet.BaseServlet;
import com.nucsoft.bookstore.utils.WebUtil;

public class BookServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	private BookService bookService = new BookServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl();

	protected void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Book> list = bookService.getList();
		WebUtil.sendData(req, resp, "bookList", list, "/manager/book/list.jsp");
	}

	protected void toAddUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Category> list = categoryService.getList();
		WebUtil.sendData(req, resp, "categoryList", list, "/manager/book/add.jsp");
	}

	protected void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Book book = WebUtil.param2Bean(req, Book.class);
		bookService.save(book);
		WebUtil.sendMessage(req, resp, "保存成功!");
	}

	protected void toEditUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Category> list = categoryService.getList();
		String bookId = req.getParameter("id");
		Book book = bookService.getById(bookId);
		req.setAttribute("categoryList", list);
		req.setAttribute("book", book);
		req.getRequestDispatcher("/manager/book/edit.jsp").forward(req, resp);
	}

	protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Book book = WebUtil.param2Bean(req, Book.class);
		bookService.update(book);
		WebUtil.sendMessage(req, resp, "修改成功!");
	}

	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		bookService.delete(id);
		WebUtil.sendMessage(req, resp, "删除成功!");
	}

}
