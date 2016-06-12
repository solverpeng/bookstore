package junit.test;

import java.sql.Connection;

import org.junit.Test;

import com.nucsoft.bookstore.utils.JDBCUtils;

public class JDBCUtilsTest {

	@Test
	public void test() {
		Connection connection = JDBCUtils.getConnection();
		System.out.println(connection);
		JDBCUtils.realseResources(connection, null, null);
	}

}
