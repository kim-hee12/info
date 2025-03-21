package ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C05Select {

	public static void main(String[] args) {
		
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/test3db";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success...");
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB CONNECTED");
			
			pstmt = conn.prepareStatement("select * from tbl_std");
			
			
			rs =  pstmt.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					System.out.print(rs.getString("name")+" ");
					System.out.print(rs.getString("age")+" ");
					System.out.print(rs.getString("addr")+" ");
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		
		try {
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	}

}
