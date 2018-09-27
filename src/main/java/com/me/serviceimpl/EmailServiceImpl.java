package com.me.serviceimpl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.me.dao.IEmailDAO;
import com.me.daoimpl.EmailDAOImpl;
import com.me.domain.SendEmail;
import com.me.service.EmailService;
import com.me.utils.DbConnectUtils;
import com.me.utils.FactoryProducer;
import com.mysql.jdbc.Connection;

public class EmailServiceImpl implements EmailService{

	private Connection connection;
	private IEmailDAO eDao;
	
	
	public int insert(SendEmail sendEmail) {
		int rs=0;
		try {
			connection=DbConnectUtils.getConnection();
			eDao=(EmailDAOImpl) FactoryProducer.getFactory("idao").getIDAO("Email", connection);
			rs=eDao.doCreate(sendEmail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public ArrayList<SendEmail> checkDate(String newdate) {
		ArrayList<SendEmail> aList=null;
		ArrayList<SendEmail> aList2=new ArrayList<SendEmail>();
		try {
			connection=DbConnectUtils.getConnection();
			eDao=(EmailDAOImpl) FactoryProducer.getFactory("idao").getIDAO("Email", connection);
			aList=eDao.findAll();
			connection.close();
			if(aList.size()!=0) {
				for(SendEmail sendEmail:aList) {
					if(sendEmail.getSendDate().equals(newdate)) {
						aList2.add(sendEmail);
					}
				}
				return aList2;
			}else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public int delete(int i) {
		int rs=0;
		try {
			connection=DbConnectUtils.getConnection();
			eDao=(EmailDAOImpl) FactoryProducer.getFactory("idao").getIDAO("Email", connection);
			rs=eDao.doDelete(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
