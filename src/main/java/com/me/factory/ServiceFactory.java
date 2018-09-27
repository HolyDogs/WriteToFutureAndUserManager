package com.me.factory;
/**
 * 
 * @author fenghere
 *
 */

import com.me.dao.IDAO;
import com.me.serviceimpl.EmailServiceImpl;
import com.me.serviceimpl.UserServiceImpl;
import com.mysql.jdbc.Connection;

public class ServiceFactory extends AbstractFactory{
	
	
	public UserServiceImpl getUserServiceImpl() {
		return new UserServiceImpl();
	}

	@Override
	public IDAO<?, ?> getIDAO(String idaotype, Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmailServiceImpl getEmailServiceImpl() {
		return new EmailServiceImpl();
	}
}
