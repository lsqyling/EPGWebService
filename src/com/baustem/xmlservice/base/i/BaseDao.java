package com.baustem.xmlservice.base.i;

import java.util.List;

public interface BaseDao<T> {
	/**
	 * 解析xml,创建数据表
	 */
	void createDataTable(String sql,Object...params);
	/**
	 * 更新和插入数据
	 * @param sql
	 * @param params
	 * @return
	 */
	int update(String sql,Object...params);
	/**
	 * 查询单条数据，返回对象
	 * @param sql
	 * @param params
	 * @return
	 */
	T getBean(String sql,Object...params);
	/**
	 * 查询多条数据，返回数据列表
	 * @param sql
	 * @param params
	 * @return
	 */
	List<T> getBeanList(String sql,Object...params);
	/**
	 * 从数据库中记录总数
	 * @param sql
	 * @param params
	 * @return
	 */
	Object getTotalRecord(String sql,Object...params);
	/**
	 * 进行批处理操作的方法
	 * @param sql
	 * @param params
	 */
	int batch(String sql,Object[][] params);
	

}
