package com.nucsoft.bookstore.dao.inter;

import java.util.List;

import com.nucsoft.bookstore.bean.Book;

public interface BookDao {
	List<Book> getList();
	
	Book getById(String id);
	
	void save(Book book);
	
	void update(Book book);
	
	void delete(String id);
}
