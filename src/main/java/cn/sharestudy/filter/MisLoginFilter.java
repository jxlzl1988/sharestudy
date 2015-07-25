package cn.sharestudy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.sharestudy.common.Constants;

public class MisLoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest r = (HttpServletRequest) request ;
		HttpSession session = r.getSession() ;
		String requestUrl = r.getRequestURL().toString() ;
		if(session.getAttribute(Constants.sessionKey) == null && !requestUrl.contains("/mis/login.html") && !requestUrl.contains("/mis/login.do")) {
			HttpServletResponse res = (HttpServletResponse) response ;
			
			res.sendRedirect(r.getContextPath() + "/mis/login.html");
		} else {
			chain.doFilter(request, response); 
		}
	}

	public void init(FilterConfig arg0) throws ServletException {

	}
}
