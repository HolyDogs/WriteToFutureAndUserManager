package com.me.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.me.utils.MyCharacterEncodingRequest;

/**
* @ClassName: CharacterEncodingFilter
* @Description: �˹������������ȫվ������������
* @author: fenghere
* 
*
*/ 
public class CharacterEncodingFilter implements Filter {

    private FilterConfig filterConfig = null;
    //����Ĭ�ϵ��ַ�����
    private String defaultCharset = "UTF-8";

    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest request = (HttpServletRequest) req;

        HttpServletResponse response = (HttpServletResponse) resp;
        String charset = filterConfig.getInitParameter("charset");
        if(charset==null){
            charset = defaultCharset;
        }
        request.setCharacterEncoding(charset);
        response.setCharacterEncoding(charset);
        response.setContentType("text/html;charset="+charset);
        
        MyCharacterEncodingRequest requestWrapper = new MyCharacterEncodingRequest(request);
        chain.doFilter(requestWrapper, response);
        return;
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        //�õ��������ĳ�ʼ��������Ϣ
        this.filterConfig = filterConfig;
    }
    
    public void destroy() {

    }
}
