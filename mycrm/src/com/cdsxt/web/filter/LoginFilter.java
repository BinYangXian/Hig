package com.cdsxt.web.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{
	
	ArrayList<String> fileNames=new ArrayList<String>();
	ArrayList<String> ends=new ArrayList<String>();
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		fileNames.add("jpg");
		fileNames.add("png");
		fileNames.add("gif");
		fileNames.add("css");
		fileNames.add("js");
		//------
		ends.add("login.jsp");
		ends.add("loginAction_login.action");
	}
	
	public Boolean valiStr(String str){
		for(String x : ends){
			if(str.endsWith(x)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		String uri=req.getRequestURI();
		String[] strs=uri.split("\\.");
		String fileName=strs[strs.length-1];
		if(fileNames.contains(fileName)||valiStr(uri)){
			chain.doFilter(request, response);
		}else {
			HttpSession session=req.getSession();
			Object loginUser=session.getAttribute("loginUser");
			if(loginUser!=null){
				chain.doFilter(request, response);
			}else {
				HttpServletResponse rsp=(HttpServletResponse)response;
				rsp.sendRedirect(req.getContextPath()+"/login.jsp");
			}
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	
}
