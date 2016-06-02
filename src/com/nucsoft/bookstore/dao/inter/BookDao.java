package com.nucsoft.bookstore.dao.inter;

import java.util.List;

import com.nucsoft.bookstore.bean.Book;
import com.nucsoft.bookstore.special.PageCondition;

public interface BookDao {
	List<Book> getList();
	
	Book getById(String id);
	
	void save(Book book);
	
	void update(Book book);
	
	void delete(String id);
	
	int getTotalRecord();

	int getTotalRecord(PageCondition pageCondition);
	
	List<Book> getPageList(int pageNo, int pageSize);
	
	List<Book> getPageList(PageCondition pageCondition, int pageNo,int pageSize);
}
