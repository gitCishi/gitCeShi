package cn.appsys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.appsys.pojo.BackendUser;
import cn.appsys.pojo.DevUser;


public class SysInterceptor extends HandlerInterceptorAdapter {
	
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
		System.out.println("SysInterceptor preHandle ==========================");
		HttpSession session = request.getSession();
		
		BackendUser backendUser = (BackendUser)session.getAttribute("userSession");
		DevUser devUser = (DevUser)session.getAttribute("devUserSession");
		
		if(devUser != null){ //dev SUCCESS
			return true;
		}else if(backendUser != null){ //backend SUCCESS
			return true;
		}else{
			response.sendRedirect(request.getContextPath()+"/403.jsp");
			return false;
		}
		
	}
}
