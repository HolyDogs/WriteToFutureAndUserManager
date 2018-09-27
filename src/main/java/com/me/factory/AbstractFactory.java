package com.me.factory;


import com.me.dao.IDAO;
import com.me.serviceimpl.EmailServiceImpl;
import com.me.serviceimpl.UserServiceImpl;
import com.mysql.jdbc.Connection;
/**
 * 
 * @author fenghere
 * @category 抽象工厂模式用错了。。。
 */

public abstract class AbstractFactory {
	public abstract IDAO<?, ?> getIDAO(String idaotype,Connection connection);
	public abstract UserServiceImpl getUserServiceImpl();
	public abstract EmailServiceImpl getEmailServiceImpl();
}
