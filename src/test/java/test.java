import java.sql.SQLException;
import java.util.ArrayList;

import com.me.daoimpl.UserDAOImpl;
import com.me.domain.User;
import com.me.serviceimpl.UserServiceImpl;
import com.me.utils.DbConnectUtils;
import com.me.utils.FactoryProducer;

public class test {

	@org.junit.Test
	public void Test() {
		UserServiceImpl userServiceImpl=FactoryProducer.getFactory("service").getUserServiceImpl();
		ArrayList<User> aList=userServiceImpl.listAll();
		for(User u:aList) {
			System.out.println(u.getUserName()+u.getUserType());
		}
		
		
		try {
			UserDAOImpl userDAOImpl=new UserDAOImpl(DbConnectUtils.getConnection());
			User user=userDAOImpl.doFind("10001");
			System.out.println(user.getUserName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
