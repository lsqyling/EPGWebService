package com.baustem.xmlservice.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	
	//获取 data source
	private static DataSource dataSource = new ComboPooledDataSource();
	//获取ThreadLocal 来保存Connection
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	
	public static Connection getConnection() throws SQLException{
		Connection conn = threadLocal.get();
		if(conn==null){
			conn = dataSource.getConnection();
			threadLocal.set(conn);
		}
		return conn;
	}
	
	
	public static void close(){
		Connection conn = threadLocal.get();
		if(conn !=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		threadLocal.remove();
		
	}
	
	
	@Test
	public void test() throws SQLException{
		Connection connection = getConnection();
		System.out.println(connection);
	}
	
	
	
}
