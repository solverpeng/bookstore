package junit.test;

import java.util.List;

import org.junit.Test;

import com.nucsoft.bookstore.bean.Book;
import com.nucsoft.bookstore.bean.User;
import com.nucsoft.bookstore.dao.impl.BookDaoImpl;
import com.nucsoft.bookstore.dao.impl.UserDaoImpl;
import com.nucsoft.bookstore.dao.inter.BookDao;

public class BaseDaoTest {
	
	@Test
	public void testSelectList() {
		UserDaoImpl UserDaoImpl = new UserDaoImpl();
		String sql = "select user_id userId, user_name userName, user_pwd userPwd, email from users";
		List<User> list = UserDaoImpl.getBeanList(sql);
		System.out.println(list.size());
	}

	@Test
	public void testSelectOne(){
		UserDaoImpl UserDaoImpl = new UserDaoImpl();
		String sql = "select user_id userId, user_name userName, user_pwd userPwd, email from users where user_id = ?";
		User user = UserDaoImpl.getBean(sql, 1);
		System.out.println(user);
		
		String sql2 = "select * from users where user_id = ?";
		User user2 = UserDaoImpl.getBean(sql2, 1);
		System.out.println(user2);
	}


}
