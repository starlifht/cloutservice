package com.test.methods;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RightFilter implements Filter {

	@Override
	public void destroy() {

		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest) arg0;
		HttpServletResponse response=(HttpServletResponse) arg1;
		//HttpSession session = request.getSession(true);
		Cookie token=Cook.getCook(request, "token");
//		if(token==null||token.getValue().equals("")){
//			
//		}else{
			if(token.getValue().equals("tr11x0s8r0t23rr4xf3t19r10223s400"))
			{
			arg2.doFilter(arg0, arg1);
			System.out.println("登录");
			}else{
				System.out.println("未登录");
				response.sendRedirect(response.encodeURL("index.jsp"));
			}
		//}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

		
	}

}
