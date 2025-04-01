package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Domain.BookDAO;
import Domain.BookDTO;

class test {

	@Test
	void test() throws Exception {
		BookDAO bookdao = BookDAO.getInstance();
		bookdao.insert(new BookDTO(1010,1,"윤성우","열혈C","오렌지미디어",0));
	}

}
