package com.me.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.me.dao.IUserDAO;
import com.me.domain.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
/**
 * 
 * @author fenghere
 *
 */

public class UserDAOImpl implements IUserDAO {
	Connection connection;
	PreparedStatement pStatement;
	ResultSet rSet;
	public UserDAOImpl(Connection connection) {
		this.connection=connection;
	}
	
	public int doCreate(User ex) throws SQLException {
		int rs=0;
		if(ex!=null) {
		String sql="INSERT INTO table_user VALUES(?,?,?,?,?)";
		pStatement=(PreparedStatement) connection.prepareStatement(sql);
		pStatement.setString(1, ex.getUserId());
		pStatement.setInt(2, ex.getUserType());
		pStatement.setString(3, ex.getPassword());
		pStatement.setString(4, ex.getUserName());
		pStatement.setInt(5	, ex.getSex());
		rs=pStatement.executeUpdate();
		pStatement.close();
		return rs;}
		return rs;
	}

	public int doDelete(String id) throws SQLException {
		int rs=0;
		if(id!=null) {
		String sql="DELETE FROM table_user WHERE userid=?";
		pStatement=(PreparedStatement) connection.prepareStatement(sql);
		pStatement.setString(1, id);
		rs=pStatement.executeUpdate();
		pStatement.close();}
		return rs;
	}

	public User doFind(String id) throws SQLException {
		User user = null;
		if(id!=null) {
		String sql="SELECT userType,password,username,sex FROM table_user WHERE userid=?";
		pStatement=(PreparedStatement) connection.prepareStatement(sql);
		pStatement.setString(1, id);
		rSet=pStatement.executeQuery();
		while (rSet.next()) {
			user=new User();
			user.setUserId(id);
			user.setUserType(rSet.getInt(1));
			user.setPassword(rSet.getString(2));
			user.setUserName(rSet.getString(3));
			user.setSex(rSet.getInt(4));
		}
		pStatement.close();
		return user;}
		return user;
	}

	public int doUpdate(User ex) throws SQLException {
		int rs=0;
		if(ex!=null) {
		String sql="UPDATE table_user SET userType=?,password=?,username=?,sex=?"+" WHERE userid=?";
		pStatement=(PreparedStatement) connection.prepareStatement(sql);
		pStatement.setInt(1, ex.getUserType());
		pStatement.setString(2, ex.getPassword());
		pStatement.setString(3, ex.getUserName());
		pStatement.setInt(4, ex.getSex());
		pStatement.setString(5, ex.getUserId());
		rs=pStatement.executeUpdate();
		pStatement.close();
		return rs;}
		return rs;
	}

	public ArrayList<User> findAll() throws SQLException {
		ArrayList<User> aList=new ArrayList<User>();
		String sql="SELECT * FROM table_user";
		pStatement=(PreparedStatement) connection.prepareStatement(sql);
		rSet=pStatement.executeQuery();
		while (rSet.next()) {
			User user=new User();
			user.setUserId(rSet.getString(1));
			user.setUserType(rSet.getInt(2));
			user.setPassword(rSet.getString(3));
			user.setUserName(rSet.getString(4));
			user.setSex(rSet.getInt(5));
			aList.add(user);
		}
		rSet.close();
		pStatement.close();
		return aList;
	}

}
