package com.nucsoft.bookstore.service.inter;

import java.util.List;

import com.nucsoft.bookstore.bean.Book;
import com.nucsoft.bookstore.special.Page;

public interface BookService {
	List<Book> getList();
	
	Book getById(String id);
	
	void save(Book book);
	
	void update(Book book);
	
	void delete(String id);
	
	Page<Book> getPage(String pageNoStr);
}
