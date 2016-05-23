package com.nucsoft.bookstore.dao.inter;

import com.nucsoft.bookstore.bean.User;

public interface UserDao {
	User query4Login(User user);
	
	boolean query4Regist(User user);
	
	void save(User user);
}
