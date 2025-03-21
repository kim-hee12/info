//package ch문제;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class BookDto{
//	private Long bookCode;
//	private String bookName;
//	private String publisher;
//	private String isbn;
//	
//	public BookDto(Long bookCode, String bookName, String publisher, String isbn) {
//		super();
//		this.bookCode = bookCode;
//		this.bookName = bookName;
//		this.publisher = publisher;
//		this.isbn = isbn;
//	}
//	
//	
//	public Long getBookCode() {
//		return bookCode;
//	}
//
//
//
//	public void setBookCode(Long bookCode) {
//		this.bookCode = bookCode;
//	}
//
//	
//
//	public String getBookName() {
//		return bookName;
//	}
//
//
//
//	public void setBookNAme(String bookName) {
//		this.bookName = bookName;
//	}
//
//
//
//	public String getPublisher() {
//		return publisher;
//	}
//
//
//
//	public void setPublisher(String publisher) {
//		this.publisher = publisher;
//	}
//
//
//
//	public String getIsbn() {
//		return isbn;
//	}
//
//
//
//	public void setIsbn(String isbn) {
//		this.isbn = isbn;
//	}
//
//
//
//	@Override
//	public String toString() {
//		return "BookDto [bookCode=" + bookCode + ", bookName=" + bookName + ", publisher=" + publisher + ", isbn="
//				+ isbn + "]";
//	}
//	
//}
//
//public class C04 {
//	// DB CONN DATA
//	private static String id = "root";
//	private static String pw = "1234";
//	private static String url = "jdbc:mysql://localhost:3306/tmp_db";
//	
//	private static Connection conn;
//	private static PreparedStatement pstmt;
//	private static ResultSet rs;
//	
//	public static void conn() throws SQLException {
//		 if (conn == null || conn.isClosed()) {
//	            conn = DriverManager.getConnection(url, id, pw);
//	        }
//	}
//	public static List<BookDto> selectAll() throws SQLException {
//        List<BookDto> list = new ArrayList<>();
//        String sql = "SELECT * FROM books";
//
//        pstmt = conn.prepareStatement(sql);
//        rs = pstmt.executeQuery();
//
//        while (rs.next()) {
//            list.add(new BookDto(
//                rs.getLong("bookCode"),
//                rs.getString("bookName"),
//                rs.getString("publisher"),
//                rs.getString("isbn")
//            ));
//        }
//
//        return list;
//    }
//
//    // 단일 조회 (SELECT by ID)
//    public static BookDto select(Long bookCode) throws SQLException {
//        String sql = "SELECT * FROM books WHERE bookCode = ?";
//        pstmt = conn.prepareStatement(sql);
//        pstmt.setLong(1, bookCode);
//        rs = pstmt.executeQuery();
//
//        if (rs.next()) {
//            return new BookDto(
//                rs.getLong("bookCode"),
//                rs.getString("bookName"),
//                rs.getString("publisher"),
//                rs.getString("isbn")
//            );
//        }
//        return null;
//    }
//
//    // 데이터 삽입 (INSERT)
//    public static int insertBook(BookDto bookDto) throws SQLException {
//        String sql = "INSERT INTO books (bookCode, bookName, publisher, isbn) VALUES (?, ?, ?, ?)";
//        pstmt = conn.prepareStatement(sql);
//        pstmt.setLong(1, bookDto.getBookCode());
//        pstmt.setString(2, bookDto.getBookName());
//        pstmt.setString(3, bookDto.getPublisher());
//        pstmt.setString(4, bookDto.getIsbn());
//
//        return pstmt.executeUpdate();
//    }
//
//    // 데이터 수정 (UPDATE)
//    public static int updateBook(BookDto bookDto) throws SQLException {
//        String sql = "UPDATE books SET bookName = ?, publisher = ?, isbn = ? WHERE bookCode = ?";
//        pstmt = conn.prepareStatement(sql);
//        pstmt.setString(1, bookDto.getBookName());
//        pstmt.setString(2, bookDto.getPublisher());
//        pstmt.setString(3, bookDto.getIsbn());
//        pstmt.setLong(4, bookDto.getBookCode());
//
//        return pstmt.executeUpdate();
//    }
//
//    // 데이터 삭제 (DELETE)
//    public static int deleteBook(Long bookCode) throws SQLException {
//        String sql = "DELETE FROM books WHERE bookCode = ?";
//        pstmt = conn.prepareStatement(sql);
//        pstmt.setLong(1, bookCode);
//
//        return pstmt.executeUpdate();
//    }
//	public static void main(String[] args) {
//		
//		try {
//			//DBConn
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("Driver Loading Success...");
//			conn = DriverManager.getConnection(url,id,pw);
//			System.out.println("DB CONNECTED...");		
//
//			//Tx start
//			
//			//Insert
//			insertBook(new BookDto(1L,"도서명1","출판사명1","isbn-1"));
//			insertBook(new BookDto(2L,"도서명2","출판사명2","isbn-2"));
//			insertBook(new BookDto(3L,"도서명3","출판사명3","isbn-3"));
//			//SelectAll
//			List<BookDto> allBook = selectAll();
//			System.out.println("selectAll :");
//			allBook.forEach(el->System.out.println(el));
//			
//			//Select
//			BookDto dto = select(1L);
//			System.out.println("select : " + dto);
//			//Update
//			dto.setBookName("수정도서명-2");
//			dto.setPublisher("수정출판사명-2");
//			int r1 = updateBook(dto);
//			if(r1>0)
//				System.out.println("수정완료 : " + r1);
//			//Delete
//			int r2 = deleteBook(2L);
//			if(r2>0)
//				System.out.println("삭제완료 : " + r2);
//		//Tx End
//			 conn.commit();
//		}
//		catch(Exception e) {
//			//Tx Rollbackall
//			try {
//				 conn.rollback();
//	                System.out.println("트랜잭션 롤백!");
//	            } catch (SQLException rollbackEx) {
//	                rollbackEx.printStackTrace();
//	            }
//	        } finally {
//	            try {
//	                if (pstmt != null) pstmt.close();
//	                if (conn != null) conn.close();
//	            } catch (SQLException closeEx) {
//	                closeEx.printStackTrace();
//	            }
//	        }
//	}
//
//}
