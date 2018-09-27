package com.me.utils;

/*import java.net.URL;*/
import java.util.Properties;
 
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.URLDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.me.domain.SendEmail;
 
/**
 * 测试发送复杂邮件：正文+附件
 */
public class SendEmailThread extends Thread{
	
	/** 邮件服务器地址   */
	private static final String MAIL_HOST = "smtp.qq.com";
	/** 设置超时时间   */
	private static final int MAIL_TIMEOUT = 8000;
	/** 邮件服务器是否否需要登录验证 */
	
	/** 邮箱用户名  */
	private static final String AUTH_USER_ADDRESS = "695978952@qq.com";
	
	/** 邮箱登录密码  */
	private static final String AUTH_USER_PASSWORD = "psveqwlifayibchg";
	
	/** 用户邮箱的昵称*/
	private static final String AUTH_USER_NICKNAME = "过去和未来的信使";
	
	private SendEmail sEmail;
	
	public SendEmailThread(SendEmail sendEmail) {
		this.sEmail=sendEmail;
	}
	
	@Override
	public void run() {
		
		try {
		Properties serverProperties = new Properties();
//		1. 设置服务器地址
	serverProperties.put("mail.smtp.host", MAIL_HOST);
//		2. 设置是否需要身份验证
	serverProperties.put("mail.smtp.auth", "true");
//	3. 设置超时时间，默认为用不超时,单位为毫秒
	serverProperties.put("mail.user", AUTH_USER_ADDRESS);
	serverProperties.put("mail.password",AUTH_USER_PASSWORD );
	serverProperties.put("mail.smtp.timeout", MAIL_TIMEOUT);
	serverProperties.put("mail.smtp.port", "25");
	serverProperties.put("mail.smtp.starttls.enable", "true");

	
/*//	2. 设置 认证授权
	Authenticator authenticator = new Authenticator() {
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(AUTH_USER_ADDRESS, AUTH_USER_PASSWORD);
		}
	};*/
	Session session = Session.getInstance(serverProperties, null);
	
//	3. 设置邮件内容
//		1. 创建邮件消息对象
		Message mailMsg = new MimeMessage(session);
//		2. 设置邮件主题
		mailMsg.setSubject(sEmail.getTitle());
//		3. 设置邮件发件人，MimeUtility.encodeText 解决中文乱码问题
		mailMsg.setFrom(new InternetAddress(MimeUtility.encodeText(AUTH_USER_NICKNAME) +"<" +  AUTH_USER_ADDRESS + ">"));
//		mailMsg.setFrom(new InternetAddress(AUTH_USER_ADDRESS)); //不设置用户邮箱昵称的方式
//		4. 设置收件人
		mailMsg.setRecipient(RecipientType.TO, new InternetAddress(sEmail.getEmailAddr()));
//		mailMsg.setRecipients(type, addresses); //多个收件人
//		5. 设置邮件抄送人
//		mailMsg.setRecipient(RecipientType.CC, new InternetAddress("****@qq.com"));
//		6. 设置邮件密送人
//		mailMsg.setRecipient(RecipientType.BCC, new InternetAddress("****@qq.com"));
		
//		7. 设置邮件内容
		Multipart mailContent = new MimeMultipart();
		
		// 7.1 正文部分
		BodyPart contentPart = new MimeBodyPart();
//		设置文本为html 文本
		contentPart.setContent(sEmail.getBodyText(), "text/html; charset=utf-8");
		//设置文本为纯文本内容
//		contentPart.setText("这是一封有附件的邮件邮件："  + System.currentTimeMillis());
		
		//7.2 附件部分： 网络图片附件，MimeUtility.encodeText 解决中文乱码问题
/*			BodyPart urlFilePart = new MimeBodyPart();
		urlFilePart.setFileName(MimeUtility.encodeText("图片1.jpg"));  //设置网络附件名称
		DataSource urlDs = new URLDataSource(new URL("http://image.baidu.com/search/down?tn=download&ipn=dwnl&word=download&ie=utf8&fr=result&url=http%3A%2F%2Fwww.uimaker.com%2Fuploads%2Fallimg%2F130228%2F1_130228110837_1.png&thumburl=http%3A%2F%2Fimg2.imgtn.bdimg.com%2Fit%2Fu%3D4027538074%2C4080457748%26fm%3D21%26gp%3D0.jpg"));
		DataHandler urlDh = new DataHandler(urlDs);
		urlFilePart.setDataHandler(urlDh );  //设置网络附件资源
		*/
/*			//7.3 附件部分：设置本地图片
		BodyPart localFilePart = new MimeBodyPart();
		localFilePart.setFileName(MimeUtility.encodeText("图片2.png"));  //设置本地附件名称
		DataSource localDs = new FileDataSource(new File("D:\\images\\img1.png"));
		DataHandler localDh = new DataHandler(localDs);
		localFilePart.setDataHandler(localDh); //设置本地附件资源
*/		
		mailContent.addBodyPart(contentPart);
/*			mailContent.addBodyPart(urlFilePart);*/
/*			mailContent.addBodyPart(localFilePart);*/
		mailMsg.setContent(mailContent);
//	4. 发送邮件
		Transport.send(mailMsg);
		System.out.println("^_^ 邮件发送成功  ^_^");
		
		}catch (Exception e) {
			System.out.println("发送失败");
		}

	}
	
 
 
}