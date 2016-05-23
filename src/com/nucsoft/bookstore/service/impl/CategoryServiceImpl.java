package com.nucsoft.bookstore.service.impl;

import java.util.List;

import com.nucsoft.bookstore.bean.Category;
import com.nucsoft.bookstore.dao.impl.CategoryDaoImpl;
import com.nucsoft.bookstore.dao.inter.CategoryDao;
import com.nucsoft.bookstore.service.inter.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDao categoryDao = new CategoryDaoImpl();

	@Override
	public void save(Category category) {
		categoryDao.save(category);
	}

	@Override
	public List<Category> getList() {
		return categoryDao.getList();
	}

	@Override
	public Category getCategoryById(String categoryId) {
		return categoryDao.getCategoryById(categoryId);
	}

	@Override
	public void update(Category category) {
		categoryDao.update(category);
	}

	@Override
	public void delete(String categoryId) {
		categoryDao.delete(categoryId);

	}

}
