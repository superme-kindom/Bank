package com.myx.bank.controller;

import com.myx.bank.dao.UserImpl;
import com.myx.bank.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * description: LoginController 接受前端传来的登录请求,并对Url进行映射<br>
 * date: 2021/8/6 22:19 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */

@Controller
public class LoginController {
    @RequestMapping("/user/login")//页面的url请求地址
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession httpSession) {
        User user = new UserImpl().getUserById(Integer.parseInt(username));
        System.out.println("接收到用户名为：" + username + " 密码为：" + password + " 姓名为：" + user.getName() + " 的用户。");
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            model.addAttribute("message", "用户名或密码为空！！！");
            return "login";//与templates中login.html对应
        } else {
            httpSession.setAttribute("loginUserId", username);
            httpSession.setAttribute("loginUserName", user.getName());
            httpSession.setAttribute("loginUserPhoneNumber", user.getPhoneNumber());
            httpSession.setAttribute("loginUserAddress", user.getAddress());

            return "redirect:/index.html";//与templates中index.html对应

        }
    }
}

