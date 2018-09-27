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
 * ���Է��͸����ʼ�������+����
 */
public class SendEmailThread extends Thread{
	
	/** �ʼ���������ַ   */
	private static final String MAIL_HOST = "smtp.qq.com";
	/** ���ó�ʱʱ��   */
	private static final int MAIL_TIMEOUT = 8000;
	/** �ʼ��������Ƿ����Ҫ��¼��֤ */
	
	/** �����û���  */
	private static final String AUTH_USER_ADDRESS = "695978952@qq.com";
	
	/** �����¼����  */
	private static final String AUTH_USER_PASSWORD = "psveqwlifayibchg";
	
	/** �û�������ǳ�*/
	private static final String AUTH_USER_NICKNAME = "��ȥ��δ������ʹ";
	
	private SendEmail sEmail;
	
	public SendEmailThread(SendEmail sendEmail) {
		this.sEmail=sendEmail;
	}
	
	@Override
	public void run() {
		
		try {
		Properties serverProperties = new Properties();
//		1. ���÷�������ַ
	serverProperties.put("mail.smtp.host", MAIL_HOST);
//		2. �����Ƿ���Ҫ�����֤
	serverProperties.put("mail.smtp.auth", "true");
//	3. ���ó�ʱʱ�䣬Ĭ��Ϊ�ò���ʱ,��λΪ����
	serverProperties.put("mail.user", AUTH_USER_ADDRESS);
	serverProperties.put("mail.password",AUTH_USER_PASSWORD );
	serverProperties.put("mail.smtp.timeout", MAIL_TIMEOUT);
	serverProperties.put("mail.smtp.port", "25");
	serverProperties.put("mail.smtp.starttls.enable", "true");

	
/*//	2. ���� ��֤��Ȩ
	Authenticator authenticator = new Authenticator() {
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(AUTH_USER_ADDRESS, AUTH_USER_PASSWORD);
		}
	};*/
	Session session = Session.getInstance(serverProperties, null);
	
//	3. �����ʼ�����
//		1. �����ʼ���Ϣ����
		Message mailMsg = new MimeMessage(session);
//		2. �����ʼ�����
		mailMsg.setSubject(sEmail.getTitle());
//		3. �����ʼ������ˣ�MimeUtility.encodeText ���������������
		mailMsg.setFrom(new InternetAddress(MimeUtility.encodeText(AUTH_USER_NICKNAME) +"<" +  AUTH_USER_ADDRESS + ">"));
//		mailMsg.setFrom(new InternetAddress(AUTH_USER_ADDRESS)); //�������û������ǳƵķ�ʽ
//		4. �����ռ���
		mailMsg.setRecipient(RecipientType.TO, new InternetAddress(sEmail.getEmailAddr()));
//		mailMsg.setRecipients(type, addresses); //����ռ���
//		5. �����ʼ�������
//		mailMsg.setRecipient(RecipientType.CC, new InternetAddress("****@qq.com"));
//		6. �����ʼ�������
//		mailMsg.setRecipient(RecipientType.BCC, new InternetAddress("****@qq.com"));
		
//		7. �����ʼ�����
		Multipart mailContent = new MimeMultipart();
		
		// 7.1 ���Ĳ���
		BodyPart contentPart = new MimeBodyPart();
//		�����ı�Ϊhtml �ı�
		contentPart.setContent(sEmail.getBodyText(), "text/html; charset=utf-8");
		//�����ı�Ϊ���ı�����
//		contentPart.setText("����һ���и������ʼ��ʼ���"  + System.currentTimeMillis());
		
		//7.2 �������֣� ����ͼƬ������MimeUtility.encodeText ���������������
/*			BodyPart urlFilePart = new MimeBodyPart();
		urlFilePart.setFileName(MimeUtility.encodeText("ͼƬ1.jpg"));  //�������總������
		DataSource urlDs = new URLDataSource(new URL("http://image.baidu.com/search/down?tn=download&ipn=dwnl&word=download&ie=utf8&fr=result&url=http%3A%2F%2Fwww.uimaker.com%2Fuploads%2Fallimg%2F130228%2F1_130228110837_1.png&thumburl=http%3A%2F%2Fimg2.imgtn.bdimg.com%2Fit%2Fu%3D4027538074%2C4080457748%26fm%3D21%26gp%3D0.jpg"));
		DataHandler urlDh = new DataHandler(urlDs);
		urlFilePart.setDataHandler(urlDh );  //�������總����Դ
		*/
/*			//7.3 �������֣����ñ���ͼƬ
		BodyPart localFilePart = new MimeBodyPart();
		localFilePart.setFileName(MimeUtility.encodeText("ͼƬ2.png"));  //���ñ��ظ�������
		DataSource localDs = new FileDataSource(new File("D:\\images\\img1.png"));
		DataHandler localDh = new DataHandler(localDs);
		localFilePart.setDataHandler(localDh); //���ñ��ظ�����Դ
*/		
		mailContent.addBodyPart(contentPart);
/*			mailContent.addBodyPart(urlFilePart);*/
/*			mailContent.addBodyPart(localFilePart);*/
		mailMsg.setContent(mailContent);
//	4. �����ʼ�
		Transport.send(mailMsg);
		System.out.println("^_^ �ʼ����ͳɹ�  ^_^");
		
		}catch (Exception e) {
			System.out.println("����ʧ��");
		}

	}
	
 
 
}