package com.me.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;

import com.me.domain.SendEmail;
import com.me.serviceimpl.EmailServiceImpl;

/**
 * 
 * 负责每日的查询有无需要发送的邮件
 * 并从数据库中删掉相应的内容
 * @author fenghere
 *
 */

public class EmailCheckTask extends TimerTask {
	private static boolean isRunning=false;
	private static EmailServiceImpl emailServiceImpl = null;
	private static String nowdate=null;
	private static ArrayList<SendEmail> aList=null;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//锁
		if(!isRunning) {
			isRunning=true;
			//开始执行任务
			emailServiceImpl=FactoryProducer.getFactory("service").getEmailServiceImpl();
			nowdate=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			aList=emailServiceImpl.checkDate(nowdate);
			if(aList==null) {
				System.out.println("没有要发送的邮件");
			}else {
				for(SendEmail sEmail:aList) {
					SendEmailUtils.sendEmails(sEmail);
					emailServiceImpl.delete(sEmail.getEmailId());
				}
			}
			//清空资源
			isRunning=false;
			emailServiceImpl=null;
			nowdate=null;
			aList=null;
			
		}
	}

}
