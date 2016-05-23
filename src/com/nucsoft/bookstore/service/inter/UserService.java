package com.nucsoft.bookstore.service.inter;

import com.nucsoft.bookstore.bean.User;

public interface UserService {
	/**
	 * 根据表单传入的User对象查询数据库返回User对象，以判断是否能登录
	 */
	User login(User user);
	
	/**
	 * 注册 
	 */
	boolean regist(User user);
}
