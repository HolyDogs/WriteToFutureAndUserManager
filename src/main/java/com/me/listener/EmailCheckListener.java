package com.me.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.me.utils.EmailCheckTask;

/**
 * Application Lifecycle Listener implementation class EmailCheckListener
 *
 */
@WebListener
public class EmailCheckListener implements ServletContextListener {
	private Timer timer=null;
    /**
     * Default constructor. 
     */
    public EmailCheckListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	if(timer!=null) {
    		timer.cancel();
    		sce.getServletContext().log("��ʱ������~");
    	}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        timer=new Timer(true);
        sce.getServletContext().log("��ʱ������");
        //����ÿ24Сʱִ��һ��
        timer.scheduleAtFixedRate(new EmailCheckTask(), 10*1000, 24*60*60*1000);
    }
	
}
