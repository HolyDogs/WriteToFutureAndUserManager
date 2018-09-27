package com.me.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.me.domain.SendEmail;
import com.me.serviceimpl.EmailServiceImpl;
import com.me.utils.FactoryProducer;
import com.me.utils.SendEmailUtils;

/**
 * Servlet implementation class EmailSendServlet
 */
@WebServlet("/EmailSendServlet")
public class EmailSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailSendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		String submitType=request.getParameter("submit");
		String title=request.getParameter("emailtitle");
		String emailBody=request.getParameter("emailbody");
		String date=request.getParameter("year")+"-"+request.getParameter("month")+"-"+request.getParameter("day");
		String addr=request.getParameter("addr");
		SendEmail sendEmail = new SendEmail();
		sendEmail.setTitle(title);
		sendEmail.setBodyText(emailBody);
		sendEmail.setEmailAddr(addr);
		sendEmail.setSendDate(date);
		if(submitType.equals("SendNow")) {
			/*SendEmailThread sThread=new SendEmailThread(sendEmail);
			sThread.start();*/
			int i=SendEmailUtils.sendEmails(sendEmail);
			if(i==0) {
				out.println("发送失败,请稍后再试...");
			}else if(i==1) {
				out.print("发送成功了嗷~~^_^");
			}
		}else if(submitType.equals("ClickMeToSend")) {

			EmailServiceImpl eServiceImpl=FactoryProducer.getFactory("service").getEmailServiceImpl();
			int rs=eServiceImpl.insert(sendEmail);
			if(rs==0) {
				out.println("您的邮件寄存失败");
			}else {
				out.print("<h1>您的邮件已入库，静静等待收信的那一天吧~</h1>");
			}
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
