package com.me.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.me.domain.User;

public class UserAccessFilter implements Filter {


    private FilterConfig filterConfig = null;

    /**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	/**
     * Default constructor. 
     */
    public UserAccessFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest=(HttpServletRequest) request;
			//看看请求的资源是什么
			String uri=httpServletRequest.getRequestURI();
			if(uri.startsWith("/WriteToFuture/index.jsp")||uri.startsWith("/WriteToFuture/LoginServlet")||uri.startsWith("/WriteToFuture/img")||uri.startsWith("/WriteToFuture/CreateImg")||uri.startsWith("/WriteToFuture/css")||uri.startsWith("/WriteToFuture/js")||uri.startsWith("/WriteToFuture/assets")){
				//直接放行.
				chain.doFilter(httpServletRequest, response);
				return;
			}else{
				HttpSession session=httpServletRequest.getSession();
				User user=(User) session.getAttribute("loginUser");
				if(user!=null){
					//该用户合法,放行
					chain.doFilter(request, response);	
					return;
				}else{
					httpServletRequest.setAttribute("err", "请好好登陆?guy?");
					httpServletRequest.getRequestDispatcher("/error.jsp")
					.forward(httpServletRequest, response);
					return;
					}
				}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

		// TODO Auto-generated method stub
		this.filterConfig=fConfig;
	}

}
