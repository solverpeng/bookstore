package com.nucsoft.bookstore.bean;

public class Book {
	private Integer bookId;
	private String bookName;
	private String author;
	private double price;
	private int storeNum;
	private int salseAmount;
	private String imgPath = "images/connan2.jpg";
	private Integer categoryId;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
	}

	public int getSalseAmount() {
		return salseAmount;
	}

	public void setSalseAmount(int salseAmount) {
		this.salseAmount = salseAmount;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", price=" + price
				+ ", storeNum=" + storeNum + ", salseAmount=" + salseAmount + ", imgPath=" + imgPath + ", categoryId="
				+ categoryId + "]";
	}

}
