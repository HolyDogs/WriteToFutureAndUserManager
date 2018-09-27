package com.me.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyCharacterEncodingRequest extends HttpServletRequestWrapper {

	   private HttpServletRequest request;
	    public MyCharacterEncodingRequest(HttpServletRequest request) {
	        super(request);
	        this.request = request;
	    }
	    /* ��дgetParameter����
	     * @see javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
	     */
	    @Override
	    public String getParameter(String name) {
	        
	        try{
	            //��ȡ������ֵ
	            String value= this.request.getParameter(name);
	            if(value==null){
	                return null;
	            }
	            //���������get��ʽ�ύ���ݵģ���ֱ�ӷ��ػ�ȡ����ֵ
	            if(!this.request.getMethod().equalsIgnoreCase("get")) {
	                return value;
	            }else{
	                //�������get��ʽ�ύ���ݵģ��ͶԻ�ȡ����ֵ����ת�봦��
	                value = new String(value.getBytes("ISO8859-1"),this.request.getCharacterEncoding());
	                return value;
	            }
	        }catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	
}
