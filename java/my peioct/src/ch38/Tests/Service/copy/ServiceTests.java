package ch38.Tests.Service.copy;

import java.sql.SQLException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import ch38.Domain.Dto.BookDto;
import ch38.Domain.Dto.UserDto;
import ch38.Domain.Service.BookServiceimpl;
import ch38.Domain.Service.UserServiceimpl;

class ServiceTests {

	@Test
	@Disabled
	void test() throws Exception {
		UserServiceimpl userService = UserServiceimpl.getInstance();
		userService.userJoin(null);
//		userService.userJoin(new UserDto("bbb","남길동","1234","ROLE_USER"));
	}
	
	@Test
	void test_2() throws Exception{
		BookServiceimpl bookService = BookServiceimpl.getInstance();
		bookService.bookRegistration(new BookDto("1010101","C언어기본","코리아미디어","1010-1010"));
	}
	
	@Test
	@Disabled
	void test_99() {
		
	}

}
