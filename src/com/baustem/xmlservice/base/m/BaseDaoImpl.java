package com.baustem.xmlservice.base.m;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.baustem.xmlservice.base.i.BaseDao;
import com.baustem.xmlservice.utils.JDBCUtils;

public class BaseDaoImpl<T> implements BaseDao<T> {
	
	private QueryRunner runner = new QueryRunner(); 
	private Class<T> type = null;
	
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		
		Type t = this.getClass().getGenericSuperclass();
		if(t instanceof ParameterizedType){
			
			ParameterizedType cla = (ParameterizedType) t;
			Type[] types = cla.getActualTypeArguments();
			type = (Class<T>) types[0];
			
		}
	
	}
	
	
	@Override
	public void createDataTable(String sql, Object... params) {
		update(sql, params);
	}


	@Override
	public int update(String sql, Object... params) {
		int count = 0;
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			count = runner.update(conn, sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally{
		}
		return count;
	}

	@Override
	public T getBean(String sql, Object... params) {
		T t = null;
		Connection conn = null;
		
		try {
			conn = JDBCUtils.getConnection();
			t = runner.query(conn, sql, new BeanHandler<T>(type), params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return t;
	}

	@Override
	public List<T> getBeanList(String sql, Object... params) {
		List<T> list = null;
		Connection conn = null;
		
		try {
			conn = JDBCUtils.getConnection();
			list = runner.query(conn, sql, new BeanListHandler<T>(type), params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	@Override
	public Object getTotalRecord(String sql, Object... params) {
		Object obj = null;
		Connection conn = null;
		
		try {
			conn = JDBCUtils.getConnection();
			obj = runner.query(conn, sql, new ScalarHandler<Object>(), params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return obj;
	}

	@Override
	public int batch(String sql, Object[][] params) {
		int count;
		Connection conn = null;
		
		try {
			conn = JDBCUtils.getConnection();
			int[] batch = runner.batch(conn, sql, params);
			count = batch.length;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally{
			
		}
		
		return count;
		
		
	}


	

}
