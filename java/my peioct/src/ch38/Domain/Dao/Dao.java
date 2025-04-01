package ch38.Domain.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ch38.Domain.Dao.ConnectionPool.ConnectionItem;
import ch38.Domain.Dao.ConnectionPool.ConnectionPool;

public class Dao {
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	protected ConnectionPool connectionPool;
	protected ConnectionItem connectionItem;
	public Dao() throws Exception{
		//connectionPool
		connectionPool =ConnectionPool.getInstance();
	}
}
