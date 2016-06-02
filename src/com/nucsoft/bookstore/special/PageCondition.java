package com.nucsoft.bookstore.special;

public class PageCondition {
	private Integer categoryId = null;
	private int minPrice = 0;
	private int maxPrice = Integer.MAX_VALUE;

	private String pageNoStr;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		if(categoryId > 0) {
			this.categoryId = categoryId;
		}
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		if(maxPrice > 0) {
			this.maxPrice = maxPrice;
		}
	}

	public String getPageNoStr() {
		return pageNoStr;
	}

	public void setPageNoStr(String pageNoStr) {
		this.pageNoStr = pageNoStr;
	}

	@Override
	public String toString() {
		return "PageCondition [categoryId=" + categoryId + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice
				+ ", pageNoStr=" + pageNoStr + "]";
	}

}
