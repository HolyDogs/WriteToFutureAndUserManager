package com.me.utils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.mysql.jdbc.Connection;

/**
 * 
 * @author fenghere
 *
 */
public class DbConnectUtils {

	private static String driver;
	private static String url;
	private static String name;
	private static String password;
	static {
		//读取数据库文件信息
		ResourceBundle rb=ResourceBundle.getBundle("dbinfo");
		driver=rb.getString("driver");
		url=rb.getString("url");
		name=rb.getString("name");
		password=rb.getString("password");
		
		try {
			Class.forName(driver);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() throws SQLException {
		return (Connection) DriverManager.getConnection(url, name, password);
	}
	
/*	public static void closeAll(Connection c,PreparedStatement s,ResultSet r) {
		if (r!=null) {
			try {
				r.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r=null;
		}
		if (s!=null) {
			try {
				s.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			s=null;
		}
		if (c!=null) {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c=null;
		}
	}*/
}
