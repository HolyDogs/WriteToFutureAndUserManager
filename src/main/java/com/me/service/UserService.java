package com.me.service;

import java.util.ArrayList;
import com.me.domain.*;
/**
 * 
 * @author fenghere
 *
 */

public interface UserService {
	public ArrayList<User> listAll();
	
	public int insert(User user);
	public int update(User user);
	public int delete(String userid);
	
	public User findOneById(String userid);
	public ArrayList<User> findOneByName(String username);
	
	public User checkUser(String userid,String password);
	
}
