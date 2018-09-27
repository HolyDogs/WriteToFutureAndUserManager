package com.me.service;

import java.util.ArrayList;

import com.me.domain.SendEmail;

/**
 * 
 * @author fenghere
 *
 */
public interface EmailService {
	public int insert(SendEmail sendEmail);
	
	public ArrayList<SendEmail> checkDate(String newdate);
	
	public int delete(int i);
}
