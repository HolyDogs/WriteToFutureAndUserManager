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
 * Servlet implementation class UserIdReturn
 */
@WebServlet("/UserIdReturn")
public class UserIdReturn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserIdReturn() {
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
		String string;
		UserServiceImpl userServiceImpl=FactoryProducer.getFactory("service").getUserServiceImpl();
		User user=null;
			string=request.getParameter("userid");
			user=userServiceImpl.findOneById(string);
			if(user!=null) {
				out.print("<h1>");
				out.print(user.getUserId()+"--");
				out.print(user.getUserType()+"--");
				out.print(user.getUserName()+"--");
				out.print(user.getSex()+"--");
				out.print(user.getPassword());
				out.print("</h1>");
			}else {
				out.println("<h1>查无此人~</h1>");
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
