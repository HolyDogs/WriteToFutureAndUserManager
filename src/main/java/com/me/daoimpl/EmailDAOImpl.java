package com.me.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.me.dao.IEmailDAO;
import com.me.domain.SendEmail;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
/***
 * 
 * @author fenghere
 *
 */
public class EmailDAOImpl implements IEmailDAO {
	Connection connection;
	PreparedStatement pStatement;
	ResultSet rSet;
	public EmailDAOImpl(Connection connection) {
		this.connection=connection;
	}
	public int doCreate(SendEmail ex) throws SQLException {
		int rs=0;
		if(ex!=null) {
		String sql="INSERT INTO table_email(title,bodytext,emailaddr,senddate) VALUES(?,?,?,?)";
		pStatement=(PreparedStatement) connection.prepareStatement(sql);
		pStatement.setString(1, ex.getTitle());
		pStatement.setString(2, ex.getBodyText());
		pStatement.setString(3, ex.getEmailAddr());
		pStatement.setString(4, ex.getSendDate());
		rs=pStatement.executeUpdate();
		return rs;}else {
		return rs;}
	}

	public int doDelete(Integer id) throws SQLException {
		int rs=0;
		if(id!=null) {
		String sql="DELETE FROM table_email WHERE emailid=?";
		pStatement=(PreparedStatement) connection.prepareStatement(sql);
		pStatement.setInt(1, id);
		rs=pStatement.executeUpdate();
		return rs;}else {
		return rs;}
	}

	public SendEmail doFind(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int doUpdate(SendEmail ex) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<SendEmail> findAll() throws SQLException {
		ArrayList<SendEmail> aList=new ArrayList<SendEmail>();
		String sql="SELECT * FROM table_email";
		pStatement=(PreparedStatement) connection.prepareStatement(sql);
		rSet=pStatement.executeQuery();
		while (rSet.next()) {
			SendEmail sEmail=new SendEmail();
			sEmail.setEmailId(rSet.getInt(1));
			sEmail.setTitle(rSet.getString(2));
			sEmail.setBodyText(rSet.getString(3));
			sEmail.setEmailAddr(rSet.getString(4));
			sEmail.setSendDate(rSet.getString(5));
			aList.add(sEmail);
		}
		rSet.close();
		pStatement.close();
		return aList;
	}
	public void haha() {
		// TODO Auto-generated method stub
		
	}

}
