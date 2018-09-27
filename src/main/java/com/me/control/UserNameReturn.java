package com.me.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.me.domain.User;
import com.me.serviceimpl.UserServiceImpl;
import com.me.utils.FactoryProducer;

/**
 * Servlet implementation class UserNameReturn
 */
@WebServlet("/UserNameReturn")
public class UserNameReturn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserNameReturn() {
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
		ArrayList<User> aList=null;
			string=request.getParameter("username");
			aList=userServiceImpl.findOneByName(string);
			if(aList!=null) {
				for(User user2:aList) {
					out.print("<h1>");
					out.print(user2.getUserId()+"--");
					out.print(user2.getUserType()+"--");
					out.print(user2.getUserName()+"--");
					out.print(user2.getSex()+"--");
					out.print(user2.getPassword());
					out.print("</h1>");
					out.println();
				}
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
