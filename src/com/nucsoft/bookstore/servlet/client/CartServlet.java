package com.nucsoft.bookstore.servlet.client;

import com.nucsoft.bookstore.bean.Book;
import com.nucsoft.bookstore.service.impl.BookServiceImpl;
import com.nucsoft.bookstore.service.inter.BookService;
import com.nucsoft.bookstore.servlet.BaseServlet;
import com.nucsoft.bookstore.special.Cart;
import com.nucsoft.bookstore.utils.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by solverpeng on 2016/6/12.
 */
public class CartServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();
    // 添加到购物车
    protected void add2Cart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookId = req.getParameter("bookId");
        Book book = bookService.getById(bookId);

        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        cart.add2Cart(book);
        WebUtil.sendData(req, resp, "message", "您刚刚将"+book.getBookName()+"加入购物车", "/client/BookClientServlet?method=getPage");
    }
}
