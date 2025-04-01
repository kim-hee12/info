package Domain;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private static BookDAO instance;

    private final String DRIVER_PATH = "oracle.jdbc.driver.OracleDriver";
    private final String ID = "system";
    private final String PW = "1234";
    private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";

    private BookDAO() {
        try {
            Class.forName(DRIVER_PATH);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBC 드라이버 로드 실패", e);
        }
    }

    public static BookDAO getInstance() {
        if (instance == null) {
            synchronized (BookDAO.class) {
                if (instance == null) {
                    instance = new BookDAO();
                }
            }
        }
        return instance;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, ID, PW);
    }

 // 1. 도서 추가 (Create)
    public int insert(BookDTO bookDto) throws Exception {
        String checkSql = "SELECT COUNT(*) FROM BOOKTBL WHERE BOOK_CODE = ?";
        String insertSql = "INSERT INTO BOOKTBL (BOOK_CODE, CLASSIFICATION_ID, BOOK_AUTHOR, BOOK_NAME, PUBLISHER, ISRESERVE) VALUES (?, ?, ?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement checkStmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            conn.setAutoCommit(false); // 트랜잭션 시작

            // 중복 확인
            checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setInt(1, bookDto.getBookcode());
            rs = checkStmt.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                throw new SQLException("중복된 BOOK_CODE 값이 존재합니다: " + bookDto.getBookcode());
            }

            // 중복이 없으면 삽입 실행
            pstmt = conn.prepareStatement(insertSql);
            pstmt.setInt(1, bookDto.getBookcode());
            pstmt.setInt(2, bookDto.getCLASSIFICATION_ID());
            pstmt.setString(3, bookDto.getBOOK_AUTHOR());
            pstmt.setString(4, bookDto.getBookname());
            pstmt.setString(5, bookDto.getPublisher());
            pstmt.setInt(6, bookDto.getIsreserve());

            int result = pstmt.executeUpdate();
            conn.commit();  // 성공하면 커밋
            return result;

        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback(); // 예외 발생 시 롤백
            }
            throw new SQLException("도서 등록 중 오류 발생! " + e.getMessage(), e);
        } finally {
            // 자원 정리 (null 체크 후 close)
            try { if (rs != null) rs.close(); } catch (Exception ignored) {}
            try { if (checkStmt != null) checkStmt.close(); } catch (Exception ignored) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception ignored) {}
            try { if (conn != null) conn.close(); } catch (Exception ignored) {}
        }
    }


 // 2. 도서 조회 (Read)
    public List<BookDTO> selectAll() throws Exception {
        String sql = "SELECT * FROM BOOKTBL";
        List<BookDTO> bookList = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                BookDTO book = new BookDTO();
                book.setBookcode(rs.getInt("BOOKCODE"));  // 대소문자 확인
                book.setBookname(rs.getString("BOOKNAME"));
                book.setPublisher(rs.getString("PUBLISHER"));
                book.setIsreserve(rs.getInt("ISRESERVE"));
                book.setCLASSIFICATION_ID(rs.getInt("CLASSIFICATION_ID"));
                book.setBOOK_AUTHOR(rs.getString("BOOK_AUTHOR"));
                bookList.add(book);
            }
        } catch (SQLException e) {
            throw new SQLException("도서 조회 중 오류 발생!", e);
        }
        return bookList;
    }


    // 3. 도서 정보 수정 (Update)
    public int updateBook(int bookcode, String newBookName) throws Exception {
        String sql = "UPDATE booktbl SET bookname = ? WHERE bookcode = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);
            pstmt.setString(1, newBookName);
            pstmt.setInt(2, bookcode);

            int result = pstmt.executeUpdate();
            conn.commit();
            return result;

        } catch (SQLException e) {
            throw new SQLException("도서 수정 중 오류 발생!", e);
        }
    }

    // 4. 도서 삭제 (Delete)
    public int delete(int bookcode) throws Exception {
        String sql = "DELETE FROM booktbl WHERE bookcode = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);
            pstmt.setInt(1, bookcode);

            int result = pstmt.executeUpdate();
            conn.commit();
            return result;

        } catch (SQLException e) {
            throw new SQLException("도서 삭제 중 오류 발생!", e);
        }
    }
}


