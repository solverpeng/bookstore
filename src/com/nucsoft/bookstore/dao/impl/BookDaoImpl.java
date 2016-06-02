package com.nucsoft.bookstore.dao.impl;

import java.util.List;

import com.nucsoft.bookstore.bean.Book;
import com.nucsoft.bookstore.dao.BaseDao;
import com.nucsoft.bookstore.dao.inter.BookDao;
import com.nucsoft.bookstore.special.PageCondition;

public class BookDaoImpl extends BaseDao<Book> implements BookDao {

	@Override
	public List<Book> getList() {
		String sql = "select book_id bookId, book_name bookName, author, price, store_num storeNum, "
				+ "salse_amount salseAmount, img_path imgPath, category_id categoryId from book";
		return this.getBeanList(sql);
	}

	@Override
	public Book getById(String id) {
		String sql = "select book_id bookId, book_name bookName, author, price, store_num storeNum, "
				+ "salse_amount salseAmount, img_path imgPath, category_id categoryId from book where book_id = ?";
		return this.getBean(sql, id);
	}

	@Override
	public void save(Book book) {
		String sql = "insert into book values(null, ?, ?, ?, ?, ?, ?, ?)";
		this.commonUpdate(sql, book.getBookName(), book.getAuthor(), book.getPrice(), book.getStoreNum(),
				book.getSalseAmount(), book.getImgPath(), book.getCategoryId());
	}

	@Override
	public void update(Book book) {
		String sql = "update book set book_name = ?, author = ?, price = ?, store_num = ?, salse_amount = ?, "
				+ "img_path = ?, category_id = ? where book_id = ?";
		this.commonUpdate(sql, book.getBookName(), book.getAuthor(), book.getPrice(), book.getStoreNum(),
				book.getSalseAmount(), book.getImgPath(), book.getCategoryId(), book.getBookId());
	}

	@Override
	public void delete(String id) {
		String sql = "delete from book where book_id = ?";
		this.commonUpdate(sql, id);
	}

	@Override
	public int getTotalRecord() {
		String sql = "select count(*) from book";
		long record = this.getSingleValue(sql);
		return (int) record;
	}

	@Override
	public List<Book> getPageList(int pageNo, int pageSize) {
		String sql = "select book_id bookId, book_name bookName, author, price, store_num storeNum, "
				+ "salse_amount salseAmount, img_path imgPath, category_id categoryId from book limit ?, ?";
		return this.getBeanList(sql, (pageNo - 1)*pageSize , pageSize);
	}

	@Override
	public int getTotalRecord(PageCondition pageCondition) {
		String sql = "select count(*) from book where price <= ? and price >= ? ";
		if(pageCondition.getCategoryId() != null) {
			sql += "and category_id =" + pageCondition.getCategoryId();
		}
		long record = this.getSingleValue(sql, pageCondition.getMaxPrice(), pageCondition.getMinPrice());
		return (int) record;
	}

	@Override
	public List<Book> getPageList(PageCondition pageCondition, int pageNo, int pageSize) {
		String sql = "select book_id bookId, book_name bookName, author, price, store_num storeNum, "
				+ "salse_amount salseAmount, img_path imgPath, category_id categoryId from book "
				+ "where price <= ? and price >= ? ";
		if(pageCondition.getCategoryId() != null) {
			sql += "and category_id = " + pageCondition.getCategoryId();
		}
		sql += " limit ?, ?";
		return this.getBeanList(sql, pageCondition.getMaxPrice(), pageCondition.getMinPrice(),(pageNo - 1)*pageSize , pageSize);
	}

}
