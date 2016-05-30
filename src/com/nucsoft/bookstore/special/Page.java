package com.nucsoft.bookstore.special;

import java.util.List;

public class Page<T> {
	// 每页显示多少条记录
	public static final int PAGE_SIZE = 3;
	// 要显示的数据
	private List<T> list;
	// 总记录数
	private int totalRecord;
	// 总页数
	private int totalPageNo;
	// 当前页
	private int pageNo;

	public Page(String pageNoStr, int totalRcord) {
		// 赋值总记录数
		this.totalRecord = totalRcord;
		
		// 根据总记录数计算总页数
		this.totalPageNo = this.totalRecord / PAGE_SIZE + ((this.totalRecord % PAGE_SIZE == 0) ? 0 : 1);
		
		// 指定 pageNo 默认值
		this.pageNo = 1;
		
		// 对pageNo进行赋值
		try {
			this.pageNo  = Integer.parseInt(pageNoStr);
		} catch (NumberFormatException e) {}
		
		// 对pageNo进行校正
		if(this.pageNo > this.totalPageNo) {
			this.pageNo = this.totalPageNo;
		}
		
		if(this.pageNo < 1) {
			this.pageNo = 1;
		}
		
	}

	// 是否有上一页
	public boolean isHasPrev() {
		return this.pageNo > 1;
	}

	// 是否有下一页
	public boolean isHasNext() {
		return this.pageNo < this.totalPageNo;
	}

	// 上一页
	public int getPrev() {
		return this.pageNo - 1;
	}

	// 下一页
	public int getNext() {
		return this.pageNo + 1;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public int getTotalPageNo() {
		return totalPageNo;
	}

	public int getPageNo() {
		return pageNo;
	}

}
