package com.nucsoft.bookstore.dao.impl;

import com.nucsoft.bookstore.bean.User;
import com.nucsoft.bookstore.dao.BaseDao;
import com.nucsoft.bookstore.dao.inter.UserDao;

public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public User query4Login(User user) {
		String sql = "select user_id userId, user_name userName, user_pwd userPwd, email from users where user_name = ? and user_pwd = ?";
		return this.getBean(sql, user.getUserName(), user.getUserPwd());
	}

	@Override
	public boolean query4Regist(User user) {
		String sql = "select user_id userId, user_name userName, user_pwd userPwd, email from users where user_name = ?";
		User queryUser = this.getBean(sql, user.getUserName());
		if(queryUser == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void save(User user) {
		String sql = "insert into users values(null, ?, ?, ?)";
		this.commonUpdate(sql, user.getUserName(), user.getUserPwd(), user.getEmail());
	}

}
