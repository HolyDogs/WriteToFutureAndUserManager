package com.me.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.me.domain.User;
import com.me.serviceimpl.UserServiceImpl;
import com.me.utils.FactoryProducer;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String userid=request.getParameter("userid");
		int usertype=Integer.parseInt(request.getParameter("userType"));
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		int sex=Integer.parseInt(request.getParameter("sex"));
		User user=new User();
		user.setUserId(userid);
		user.setUserName(username);
		user.setUserType(usertype);
		user.setPassword(password);
		user.setSex(sex);
		UserServiceImpl userServiceImpl=FactoryProducer.getFactory("service").getUserServiceImpl();
		int i=userServiceImpl.insert(user);
		if(i>0) {
			out.println("添加成功~");
		}else {
			out.println("添加失败！");
		}
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
