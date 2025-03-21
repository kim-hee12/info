package ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C03Update {

	public static void main(String[] args) {
		//DB CONN DATA
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/test3db";
		
		//JDBC참조변수
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success...");
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB CONNECTED...");
			
			String name = args[0];
			int age = Integer.parseInt(args[1]);
			String addr = args[2];
			pstmt=conn.prepareStatement("insertinto tbl_std set age=?,addr=? where name=?");
			pstmt.setString(1,name);
			pstmt.setInt(2,age);
			pstmt.setString(3,addr);
			
//			pstmt = conn.prepareStatement("insert into tbl_std values('" + name + "','" + age + "','" + addr + "')");

			int result = pstmt.executeUpdate();
			
			if (result > 0)
				System.out.println("Update 성공");
			else
				System.out.println("Update 실패");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {	
			try { conn.close();} catch (SQLException e) {e.printStackTrace(); }
		}
	}

}