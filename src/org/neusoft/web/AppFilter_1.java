package org.neusoft.web;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;


 //StrutsPrepareFilter and StrutsExecuteFilter, have a look at the implementation here
public class AppFilter_1 extends StrutsPrepareAndExecuteFilter {
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		
		if ("GET".equals(request.getMethod())) {
			//response.sendRedirect("/neusoftsms/index.jsp?er=-1");
			//return;
			System.out.println(request.getServletPath());
			throw new ServletException("对不起,您的操作不符合规范");
		}
		
		super.doFilter(arg0, arg1, arg2);
	}

}
