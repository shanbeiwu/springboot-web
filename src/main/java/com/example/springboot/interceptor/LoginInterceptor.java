package com.example.springboot.interceptor;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    //进入controller之前会先进入这个方法，此方法会在访问controller之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println(request.getContextPath());
        System.out.println(request.getRequestURI());
        System.out.println("这里是登陆拦截器，你已经被拦截到了");
        Object user = request.getSession().getAttribute("loginuser");
        if (user == null) {
            request.setAttribute("msg", "当前用户未登陆，请登陆后再试");
            request.getRequestDispatcher("index.html").forward(request, response);//获取request转发器
            return false;
        } else {
            return true;//返回值为false时会将访问controller请求拦截下来，true时通过
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
