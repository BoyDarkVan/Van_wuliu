package com.van.intercetor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Myinterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

       //拦截
       //排除不需要拦截的url
        if (httpServletRequest.getRequestURI().endsWith("login")) {
                     return  true;
        }
        if (httpServletRequest.getSession().getAttribute("user")!=null){
            return  true;
        }
//        httpServletResponse.sendRedirect("/WEB-INF/views/login.jsp");
        httpServletRequest.getRequestDispatcher("/WEB-INF/views/login.html").forward(httpServletRequest, httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
