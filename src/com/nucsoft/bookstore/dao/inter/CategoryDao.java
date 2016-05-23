package com.nucsoft.bookstore.dao.inter;

import java.util.List;

import com.nucsoft.bookstore.bean.Category;

public interface CategoryDao {
	void save(Category category);
	
	List<Category> getList();
	
	Category getCategoryById(String categoryId);
	
	void update(Category category);
	
	void delete(String categoryId);
}
