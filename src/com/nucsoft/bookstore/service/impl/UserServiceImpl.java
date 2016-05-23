package com.nucsoft.bookstore.service.impl;

import com.nucsoft.bookstore.bean.User;
import com.nucsoft.bookstore.dao.impl.UserDaoImpl;
import com.nucsoft.bookstore.dao.inter.UserDao;
import com.nucsoft.bookstore.service.inter.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User login(User user) {
		return userDao.query4Login(user);
	}

	@Override
	public boolean regist(User user) {
		boolean isCanSave = userDao.query4Regist(user);
		if(isCanSave) {
			userDao.save(user);
			return true;
		} else {
			return false;
		}
	}

}
