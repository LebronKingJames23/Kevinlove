package cn.crm.interceptor;

import cn.crm.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (httpServletRequest.getRequestURI().equals("/crm/User/login.action")||httpServletRequest.getRequestURI().equals("/crm/code/acode.action")) {
            return true;
        }
            User user = (User) httpServletRequest.getSession().getAttribute("loginUser");
            if (user == null) {

                httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/jsp/login.jsp");
                return false;
            }
            return true;
        }




    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
