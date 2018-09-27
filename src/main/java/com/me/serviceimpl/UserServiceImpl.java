package com.me.serviceimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import com.me.dao.IUserDAO;
import com.me.domain.User;
import com.me.service.UserService;
import com.me.utils.DbConnectUtils;
import com.me.utils.FactoryProducer;
import com.mysql.jdbc.Connection;
/**
 * 
 * 
 * @author fenghere
 *
 */
public class UserServiceImpl implements UserService {
	private Connection connection;
	private IUserDAO userDAO;

	public ArrayList<User> listAll() {
		ArrayList<User> arrayList=null;
		
		try {
			connection=DbConnectUtils.getConnection();
			userDAO=(IUserDAO) FactoryProducer.getFactory("idao").getIDAO("User", connection);
			arrayList=userDAO.findAll();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrayList;
	}

	public int insert(User user) {
		int rs=0;
		
		try {
			connection=DbConnectUtils.getConnection();
			userDAO=(IUserDAO) FactoryProducer.getFactory("idao").getIDAO("User", connection);
			rs=userDAO.doCreate(user);
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	public int update(User user) {
		int rs=0;
		
		try {
			connection=DbConnectUtils.getConnection();
			userDAO=(IUserDAO) FactoryProducer.getFactory("idao").getIDAO("User", connection);
			rs=userDAO.doUpdate(user);
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	public int delete(String userid) {
		int rs=0;
		
		try {
			connection=DbConnectUtils.getConnection();
			userDAO=(IUserDAO) FactoryProducer.getFactory("idao").getIDAO("User", connection);
			rs=userDAO.doDelete(userid);
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	public User findOneById(String userid) {
		User user=null;
		
		try {
			connection=DbConnectUtils.getConnection();
			userDAO=(IUserDAO) FactoryProducer.getFactory("idao").getIDAO("User", connection);
			user=userDAO.doFind(userid);
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	

	public User checkUser(String userid, String password) {
		User user = this.findOneById(userid);
		if(user!=null) {
			if(!password.equals(user.getPassword())) {
				return null;
			}else {
				return user;
			}
		}else {
			return null;
		}
	}

	public ArrayList<User> findOneByName(String username) {
		ArrayList<User> arrayList=null;
		ArrayList<User> arrayList2=new ArrayList<User>();
		try {
			connection=DbConnectUtils.getConnection();
			userDAO=(IUserDAO) FactoryProducer.getFactory("idao").getIDAO("User", connection);
			arrayList=userDAO.findAll();
			connection.close();
			if(arrayList.size()!=0) {
				for(User user:arrayList) {
					if(user.getUserName().equals(username)) {
						arrayList2.add(user);
					}
				}
				return arrayList2;
			}else {
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
