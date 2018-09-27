package com.me.dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * @author fenghere
 *
 * @param <T> 数据对象类型
 * @param <K> 数据对象主键类型
 */
public interface IDAO<T,K> {
	public int doCreate(T ex) throws SQLException;
	public int doDelete(K id) throws SQLException;
	public T doFind(K id) throws SQLException;
	public int doUpdate(T ex) throws SQLException;
	public ArrayList<T> findAll() throws SQLException;
}
