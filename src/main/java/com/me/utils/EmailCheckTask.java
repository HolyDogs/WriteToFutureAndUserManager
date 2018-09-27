package com.me.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;

import com.me.domain.SendEmail;
import com.me.serviceimpl.EmailServiceImpl;

/**
 * 
 * ����ÿ�յĲ�ѯ������Ҫ���͵��ʼ�
 * �������ݿ���ɾ����Ӧ������
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
		//��
		if(!isRunning) {
			isRunning=true;
			//��ʼִ������
			emailServiceImpl=FactoryProducer.getFactory("service").getEmailServiceImpl();
			nowdate=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			aList=emailServiceImpl.checkDate(nowdate);
			if(aList==null) {
				System.out.println("û��Ҫ���͵��ʼ�");
			}else {
				for(SendEmail sEmail:aList) {
					SendEmailUtils.sendEmails(sEmail);
					emailServiceImpl.delete(sEmail.getEmailId());
				}
			}
			//�����Դ
			isRunning=false;
			emailServiceImpl=null;
			nowdate=null;
			aList=null;
			
		}
	}

}
