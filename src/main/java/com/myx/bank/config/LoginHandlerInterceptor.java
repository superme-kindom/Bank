package com.myx.bank.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description: LoginHandlerInerceptor 进行登录拦截防止没有登录的用户进入主页面<br>
 * date: 2021/8/6 22:29 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUSer = request.getSession().getAttribute("loginUserId");
        if (loginUSer == null) {//没有session说明用户未登录，进行拦截；
            request.setAttribute("message", "没有登录,请先登录!!!");
            request.getRequestDispatcher("/login.html").forward(request, response);
            return false;
        } else {
            return true;
        }
    }
}
