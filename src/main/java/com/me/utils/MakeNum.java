package com.me.utils;

import java.util.Random;

public class MakeNum {

	//�ú���ʱ�������7λ����
	public static String makeNum() {
		Random r = new Random();
		//9999999 ��������7λ
		String num = r.nextInt(9999) + ""; 
		StringBuffer sb = new StringBuffer();
		//�������4λ��ǰ�油��
		for (int i = 0; i < 4 - num.length(); i++) {
			sb.append("0");
		}
		num = sb.toString() + num;
		return num;
	}
}
