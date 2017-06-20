package cn.itheima.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SecurityInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		if(arg0.getRequestURI().indexOf("/login")>0){
			return true;
		}
		if(arg0.getSession().getAttribute("uid")!=null){
			return true;
		}else{
			arg0.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(arg0, arg1);
			arg0.setAttribute("systemMsg", "请登录");
			return false;
		}
	}

}
