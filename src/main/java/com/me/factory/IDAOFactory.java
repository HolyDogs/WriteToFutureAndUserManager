package com.me.factory;

import com.me.dao.IDAO;
import com.me.daoimpl.EmailDAOImpl;
import com.me.daoimpl.UserDAOImpl;
import com.me.serviceimpl.EmailServiceImpl;
import com.me.serviceimpl.UserServiceImpl;
import com.mysql.jdbc.Connection;
/**
 * 
 * @author fenghere
 *
 */

public class IDAOFactory extends AbstractFactory {

	@Override
	public IDAO<?, ?> getIDAO(String idao,Connection connection) {
		if(idao.equals("User")) {
			return new UserDAOImpl(connection);
		}else if(idao.equals("Email")){
			return new EmailDAOImpl(connection);
		}
		return null;
	}

	@Override
	public UserServiceImpl getUserServiceImpl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmailServiceImpl getEmailServiceImpl() {
		// TODO Auto-generated method stub
		return null;
	}


}
