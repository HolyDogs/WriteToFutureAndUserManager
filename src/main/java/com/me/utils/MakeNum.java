package com.me.utils;

import java.util.Random;

public class MakeNum {

	//该函数时随机生成7位数字
	public static String makeNum() {
		Random r = new Random();
		//9999999 可以生成7位
		String num = r.nextInt(9999) + ""; 
		StringBuffer sb = new StringBuffer();
		//如果不够4位，前面补零
		for (int i = 0; i < 4 - num.length(); i++) {
			sb.append("0");
		}
		num = sb.toString() + num;
		return num;
	}
}
