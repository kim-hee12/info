package ch38.Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ch38.Domain.Dao.ConnectionPool.ConnectionItem;
import ch38.Domain.Dao.ConnectionPool.ConnectionPool;
import ch38.Domain.Dto.BookDto;
import ch38.Domain.Dto.UserDto;

public class BookDaoimpl implements BookDao {
	// DB Attr
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private final String DRIVER_PATH = "oracle.jdbc.driver.OracleDriver";
	private final String ID = "system";
	private final String PW = "1234";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";

//	private ConnectionPool connectionPool;
//	private ConnectionItem connectionItem;

	// 싱글톤 패턴처리
	private static BookDaoimpl instance;

	public BookDaoimpl() throws SQLException, ClassNotFoundException {
		System.out.println("[DAO UserDaoimpl init ...");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(URL, ID, PW);
		conn.setAutoCommit(false);
		System.out.println("BookDaoimpl DB Connection Success");
	};

	public static BookDaoimpl getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null)
			instance = new BookDaoimpl();
		return instance;
	}

	// CRUD
	public int insert(BookDto bookDto) throws Exception {
		try {
			// connection get
//			connectionItem = connectionPool.getConnection();
//			Connection conn = connectionItem.getConn();

			pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?,?)");
			pstmt.setString(1, bookDto.getBookcode());
			pstmt.setString(2, bookDto.getBookName());
			pstmt.setString(3, bookDto.getPublisher());
			pstmt.setString(4, bookDto.getIsbn());

			// connection release
//			connectionPool.releaseConnection(connectionItem);

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("bookdao' s insert sql exception!!");
		} finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}

	public int update(UserDto userDto) throws SQLException {
		return 0;
	}

	public int delete(UserDto userDto) throws SQLException {
		return 0;
	}

	// 단건조회

	public UserDto select(UserDto userDtoo) {
		return null;
	}

	// 다건조회
	public List<UserDto> selectAll() {
		return null;
	}

}
