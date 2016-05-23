package com.nucsoft.bookstore.dao.impl;

import java.util.List;

import com.nucsoft.bookstore.bean.Category;
import com.nucsoft.bookstore.dao.BaseDao;
import com.nucsoft.bookstore.dao.inter.CategoryDao;

public class CategoryDaoImpl extends BaseDao<Category> implements CategoryDao {

	@Override
	public void save(Category category) {
		String sql = "insert into category values(null, ?)";
		commonUpdate(sql, category.getCategoryName());
	}

	@Override
	public List<Category> getList() {
		String sql = "select category_id categoryId, category_name categoryName from category";
		return getBeanList(sql);
	}

	@Override
	public Category getCategoryById(String categoryId) {
		String sql = "select category_id categoryId, category_name categoryName from category where category_id = ?";
		return getBean(sql, categoryId);
	}

	@Override
	public void update(Category category) {
		String sql = "update category set category_name = ? where category_id = ?";
		commonUpdate(sql, category.getCategoryName(), category.getCategoryId());
	}

	@Override
	public void delete(String categoryId) {
		String sql = "delete from category where category_id = ?";
		commonUpdate(sql, categoryId);
	}

}
