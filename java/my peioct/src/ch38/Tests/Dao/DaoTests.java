package ch38.Tests.Dao;

import java.sql.SQLException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import ch38.Domain.Dao.BookDao;
import ch38.Domain.Dao.BookDaoimpl;
import ch38.Domain.Dao.UserDao;
import ch38.Domain.Dao.UserDaoimpl;
import ch38.Domain.Dto.BookDto;
import ch38.Domain.Dto.UserDto;


class DaoTests {

	@Test
	@Disabled
	void test1() throws Exception {
		
		UserDao userDaoimpl = UserDaoimpl.getInstance();
		
	}

	
	
	@Test
	void test2() throws Exception{
		UserDao userDaoimpl = UserDaoimpl.getInstance();
		userDaoimpl.insert(new UserDto("aaa","홍길동","1234",""));
	}
	
	@Test
	@Disabled
	void test3() throws Exception {
		
		BookDao bookDaoimpl = BookDaoimpl.getInstance();
		bookDaoimpl.insert(new BookDto("1111","리눅스다","한빛미디어","111-111"));
		
	}

	
	
	@Test
	@Disabled
	void test4() throws Exception{
		
	}
}