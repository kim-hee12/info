package Tests;

import org.junit.Test;

import Domain.Dao.UserDao;
import Domain.Dao.UserDaoImpl;
import Domain.Dto.UserDto;

public class DaoTests {

	@Test
	void test() throws Exception{
		UserDao userDao = UserDaoImpl.getInstance();
		
		userDao.insert(new UserDto("user1234","1234","ROLE_USER"));
	}
}
