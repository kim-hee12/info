package ch38.Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ch38.Domain.Dto.UserDto;
//import ch38.Domain.Dao.ConnectionPool.ConnectionItem;
//import ch38.Domain.Dao.ConnectionPool.ConnectionPool;

public class UserDaoimpl extends Dao implements UserDao {
	// DB Attr
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String id="system";
	private String pw="1234";
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	
//	// connection pool
//	private Connectionpool connectionPool;
//	private ConnectionItem connectionItem;
	
	// 싱글톤 패턴처리
	private static UserDaoimpl instance;
	public UserDaoimpl() throws Exception {
		System.out.println("[DAO UserDaoimpl init ...");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url,id,pw);
		conn.setAutoCommit(false);
		System.out.println("UserDaoimpl DB Connection Success");
//		connectionPool =ConnectionPool.getInstance();
	};
	public static UserDao getInstance() throws  Exception {
		if(instance==null)
			instance = new UserDaoimpl();
		return instance;
	}
	
	// CRUD
	@Override
	public int insert(UserDto userDto) throws Exception{
		try {
//			connectionItem = connectionPool.getConnection();
//			Connection conn = connectionItem.getConn();
			
			pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?,?)");
			pstmt.setString(1, userDto.getUserid());
			pstmt.setString(2, userDto.getUsername());
			pstmt.setString(3, userDto.getPassword());
			pstmt.setString(4,"ROLE_USER");
			
			//Connection release
			connectionPool.releaseConnection(connectionItem);
			
			return pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("userdao' s insert sql exception!!");
		}finally {
			try {pstmt.close();}catch(Exception e2) {}
		}
	}
	public int update(UserDto UserDto) throws SQLException{
//		try {
//			pstmt = conn.prepareStatement("");
//			return pstmt.executeUpdate();
//		}catch(SQLException e){
//			e.printStackTrace();
//			throw new SQLException("userdao' s update sql exception!!");
//		}finally {
//			try {pstmt.close();}catch(Exception e2) {}
//		}
		return 0;
	}
	public int delete() throws SQLException{
//		try {
//			pstmt = conn.prepareStatement("");
//			return pstmt.executeUpdate();
//		}catch(SQLException e){
//			e.printStackTrace();
//			throw new SQLException("userdao' s delete sql exception!!");
//		}finally {
//			try {pstmt.close();}catch(Exception e2) {}
//		}
		return 0;
	}
	// 단건조회
	public UserDto select(UserDto UserDto) {
		return null;
	}
	// 다건조회
	public List<UserDto> selectAll(){
		return null;
	}
	@Override
	public int delete(UserDto userDto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
