package com.nucsoft.bookstore.servlet.client;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
	
		//将当前访问的Book对象添加到浏览记录中
		// 1.创建Cookie对象
		Cookie cookie = new Cookie("book_" + book.getBookId(), URLEncoder.encode(book.getBookName(), "UTF-8"));
		// 2.回送Cookie
		resp.addCookie(cookie);
		WebUtil.sendData(req, resp, "book", book, "/client/book/book.jsp");
	}

	protected void getPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PageCondition pageCondition = WebUtil.param2Bean(req, PageCondition.class);
		Page<Book> page = bookService.getPage(pageCondition);
		WebUtil.sendData(req, resp, "page", page, "/client/book/showList.jsp");
	}

}
