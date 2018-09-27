package com.me.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.me.domain.User;
import com.me.serviceimpl.UserServiceImpl;
import com.me.utils.FactoryProducer;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/**
	 * 
	 */
/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str=request.getSession().getAttribute("checkcode").toString();
		String str1=request.getParameter("checknum");
		String userid=request.getParameter("usernum");
		String password=request.getParameter("password");
		if(!str.equals(str1)) {
			request.setAttribute("err", "验证码错误");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return ;
		}
		UserServiceImpl userServiceImpl=FactoryProducer.getFactory("service").getUserServiceImpl();
		User user=userServiceImpl.checkUser(userid, password);
		if(user==null) {
			request.setAttribute("err", "用户名或密码错误");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}else if(user.getUserType()==0){
			request.getSession().setAttribute("loginUser", user);
			request.getRequestDispatcher("/manager.jsp").forward(request, response);
			return;
		}else if(user.getUserType()==1){
			request.getSession().setAttribute("loginUser", user);
			request.getRequestDispatcher("/sendemail.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
