package junit.test;

import java.util.List;

import org.junit.Test;

import com.nucsoft.bookstore.bean.Book;
import com.nucsoft.bookstore.dao.impl.BookDaoImpl;
import com.nucsoft.bookstore.dao.inter.BookDao;

public class BookDaoTest {
	private BookDao bookDao = new BookDaoImpl();
	
	@Test
	public void testGetBookPageList() {
		List<Book> pageList = bookDao.getPageList(1, 5);
		System.out.println(pageList);
	}
	
	
	@Test
	public void testSave() {
		for (int i = 0; i < 38; i++) {
			Book book = new Book();
			book.setAuthor("author" + i);
			book.setBookName("bookName" + i);
			book.setPrice(100);
			book.setSalseAmount(100);
			book.setStoreNum(100);
			book.setCategoryId((i % 10) + 1);
			bookDao.save(book);
		}
	}

}
