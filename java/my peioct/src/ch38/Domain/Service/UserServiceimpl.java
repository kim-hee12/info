
package ch38.Domain.Service;

import java.sql.SQLException;

import ch38.Domain.Dao.UserDao;
import ch38.Domain.Dao.UserDaoimpl;
import ch38.Domain.Dao.ConnectionPool.ConnectionPool;
import ch38.Domain.Dto.UserDto;

public class UserServiceimpl {

	//
	private UserDao userDao;
	private ConnectionPool connectionPool;
	
	// 싱글톤 패턴
	private static UserServiceimpl instance;

	private UserServiceimpl() throws Exception {
		userDao = UserDaoimpl.getInstance();
		connectionPool = ConnectionPool.getInstance();
		System.out.println("[SERVICE] UserServiceimpl init ...");
	};

	public static UserServiceimpl getInstance() throws Exception {
		if (instance == null)
			instance = new UserServiceimpl();
		return instance;
	}

	// 회원가입(+TX처리필요)
	public boolean userJoin(UserDto userDto) throws Exception{
		boolean isjoin = false;
		try {
			connectionPool.beginTransaction();
			
			isjoin =  userDao.insert(userDto)>0;
//			userDao.insert(new userDto("aaaaa","","",""));
//			userDao.insert(new userDto("aaaab","","",""));
//			userDao.insert(new userDto("aaaaa","","",""));
			
			connectionPool.commitTransaction();
			
		}catch(SQLException e) { 
			connectionPool.rollbackTransaction();
		}
		return isjoin;
	};

	// 회원조회

	// 회원정보수정

	// 회원탈퇴

	// 로그인

	// 로그아웃
}
