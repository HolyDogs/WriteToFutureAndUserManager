package com.me.utils;

import com.me.domain.Mymail;
import com.me.domain.SendEmail;

public class SendEmailUtils {
	public static int sendEmails(SendEmail sendEmail) {
		String sendSmtp="smtp.qq.com";
		Mymail mymail=new Mymail(sendSmtp);
		mymail.setNeedAuth(true);
		if(mymail.setSubject(sendEmail.getTitle())==false) {
			return 0;
		}
		if(mymail.setBody(sendEmail.getBodyText())==false) {
			return 0;
		}
		if(mymail.setTo(sendEmail.getEmailAddr())==false) {
			return 0;
		}
		if(mymail.setFrom("695978952@qq.com")==false) {
			return 0;
		}
		mymail.setNamePass("695978952", "psveqwlifayibchg");
		
		if(mymail.sendout()==false) {
			return 0;
		}
		return 1;
	}
}
