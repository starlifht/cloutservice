package com.cloud.methods;

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


import org.apache.commons.lang3.StringUtils;

public class RightFilter implements Filter {
	/******
	 * 权限过滤器
	 */
	private String excludedPages;

	private String[] excludedPageArray;

	@Override
	public void destroy() {
		return;

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest) arg0;
		HttpServletResponse response=(HttpServletResponse) arg1;
		boolean isExcludedPage = false;
		for (String page : excludedPageArray) {//判断是否在过滤url之外
		if(request.getServletPath().equals(page)){
		isExcludedPage = true;
		break;
		}}
		//HttpSession session = request.getSession(true);
		
		Cookie token=CookBook.getCook(request, "token");
//		if(token==null||token.getValue().equals("")){
//			
//		}else{
			if(token!=null||isExcludedPage)
			{
			arg2.doFilter(arg0, arg1); 
		//	System.out.println("登录");
			}else{
			//	System.out.println("未登录");
				response.sendRedirect(response.encodeURL("login.jsp?ru="+request.getRequestURI()));
			}
		//}
		
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		excludedPages = fConfig.getInitParameter("excludedPages");
		if (StringUtils.isNotEmpty(excludedPages)) {
			excludedPageArray = excludedPages.split(",");
		}
		return;

	}

}
