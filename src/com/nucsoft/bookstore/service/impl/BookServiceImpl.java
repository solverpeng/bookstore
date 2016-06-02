package com.nucsoft.bookstore.service.impl;

import java.util.List;

import com.nucsoft.bookstore.bean.Book;
import com.nucsoft.bookstore.dao.impl.BookDaoImpl;
import com.nucsoft.bookstore.dao.inter.BookDao;
import com.nucsoft.bookstore.service.inter.BookService;
import com.nucsoft.bookstore.special.Page;
import com.nucsoft.bookstore.special.PageCondition;

public class BookServiceImpl implements BookService {
	private BookDao bookDao = new BookDaoImpl();

	@Override
	public List<Book> getList() {
		return bookDao.getList();
	}

	@Override
	public Book getById(String id) {
		return bookDao.getById(id);
	}

	@Override
	public void save(Book book) {
		bookDao.save(book);
	}

	@Override
	public void update(Book book) {
		bookDao.update(book);
	}

	@Override
	public void delete(String id) {
		bookDao.delete(id);
	}

	@Override
	public Page<Book> getPage(String pageNoStr) {
		int totalRcord = bookDao.getTotalRecord();
		Page<Book> page = new Page<Book>(pageNoStr, totalRcord);
		List<Book> list = bookDao.getPageList(page.getPageNo(), Page.PAGE_SIZE);
		page.setList(list);
		return page;
	}

	@Override
	public Page<Book> getPage(PageCondition pageCondition) {
		int totalRcord = bookDao.getTotalRecord(pageCondition);
		Page<Book> page = new Page<Book>(pageCondition.getPageNoStr(), totalRcord);
		List<Book> list = bookDao.getPageList(pageCondition, page.getPageNo(), Page.PAGE_SIZE);
		page.setList(list);
		return page;
	}

}
