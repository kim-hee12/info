package ch38.Domain.Dao;

import java.sql.SQLException;
import java.util.List;

import ch38.Domain.Dto.UserDto;

public interface UserDao {
	
	int insert(UserDto userDto) throws Exception;

	int update(UserDto userDto) throws SQLException;

	int delete(UserDto userDto) throws SQLException;
	//단건조회

	UserDto select(UserDto userDto);
	//다건조회

	List<UserDto> selectAll();

}
