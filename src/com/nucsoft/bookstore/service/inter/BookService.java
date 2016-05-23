package com.nucsoft.bookstore.service.inter;

import java.util.List;

import com.nucsoft.bookstore.bean.Book;

public interface BookService {
	List<Book> getList();
	
	Book getById(String id);
	
	void save(Book book);
	
	void update(Book book);
	
	void delete(String id);
}
