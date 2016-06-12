package junit.test;

import org.junit.Test;

import com.nucsoft.bookstore.bean.User;
import com.nucsoft.bookstore.dao.impl.UserDaoImpl;
import com.nucsoft.bookstore.dao.inter.UserDao;

public class UserDaoTest {
	private UserDao userDao = new UserDaoImpl();
	
	@Test
	public void test() {
		User user = new User();
		user.setUserName("user001");
		user.setUserPwd("123456");
		User queryUser = userDao.query4Login(user);
		System.out.println(queryUser);
	}

}
