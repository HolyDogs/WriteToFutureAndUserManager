package com.me.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyCharacterEncodingRequest extends HttpServletRequestWrapper {

	   private HttpServletRequest request;
	    public MyCharacterEncodingRequest(HttpServletRequest request) {
	        super(request);
	        this.request = request;
	    }
	    /* 重写getParameter方法
	     * @see javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
	     */
	    @Override
	    public String getParameter(String name) {
	        
	        try{
	            //获取参数的值
	            String value= this.request.getParameter(name);
	            if(value==null){
	                return null;
	            }
	            //如果不是以get方式提交数据的，就直接返回获取到的值
	            if(!this.request.getMethod().equalsIgnoreCase("get")) {
	                return value;
	            }else{
	                //如果是以get方式提交数据的，就对获取到的值进行转码处理
	                value = new String(value.getBytes("ISO8859-1"),this.request.getCharacterEncoding());
	                return value;
	            }
	        }catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	
}
