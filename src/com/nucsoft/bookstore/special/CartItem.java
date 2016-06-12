package com.nucsoft.bookstore.special;

import com.nucsoft.bookstore.bean.Book;

/**
 * Created by solverpeng on 2016/6/12.
 */
public class CartItem {
    private int count;
    private Book book;

    public CartItem(Book book, int count) {
        this.book = book;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public double getAmount() {
        return this.book.getPrice() * this.count;
    }
}
