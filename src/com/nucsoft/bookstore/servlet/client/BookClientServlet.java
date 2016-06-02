package com.nucsoft.bookstore.servlet.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nucsoft.bookstore.bean.Book;
import com.nucsoft.bookstore.service.impl.BookServiceImpl;
import com.nucsoft.bookstore.service.inter.BookService;
import com.nucsoft.bookstore.servlet.BaseServlet;
import com.nucsoft.bookstore.special.Page;
import com.nucsoft.bookstore.special.PageCondition;
import com.nucsoft.bookstore.utils.WebUtil;

public class BookClientServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookServiceImpl();
	
	protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookId = req.getParameter("bookId");
		Book book = bookService.getById(bookId);
		WebUtil.sendData(req, resp, "book", book, "/client/book/book.jsp");
	}

	protected void getPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PageCondition pageCondition = WebUtil.param2Bean(req, PageCondition.class);
		Page<Book> page = bookService.getPage(pageCondition);
		WebUtil.sendData(req, resp, "page", page, "/client/book/showList.jsp");
	}

}
