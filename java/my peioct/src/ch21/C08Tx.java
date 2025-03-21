package ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class C08Tx {
	
	static String id = "root";
	static String pw = "1234";
	static String url = "jdbc:mysql://localhost:3306/test3db";
	
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success...");
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB CONNECTED");
			
			System.out.println("INSERT 시작...");
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement("insert into tbl_std values('a',1,'a')");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("insert into tbl_std values('b',1,'a')");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("insert into tbl_std values('c',1,'a')");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("insert into tbl_std values('d',1,'a')");
			pstmt.executeUpdate();
			System.out.println("INSERT 종료...");
		}
		catch(Exception e) {
			e.printStackTrace();
			try{conn.rollback();}catch(Exception e3) {}
		}
		finally {
			try {pstmt.close();}catch(Exception e2) {}
			try {conn.close();}catch(Exception e2) {}
			
		}
	}

}
