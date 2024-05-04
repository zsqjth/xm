package controller;

import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.JsonUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while((line=reader.readLine())!=null)
        {
            stringBuilder.append(line);
        }
        String params = stringBuilder.toString();
        User user = JSON.parseObject(params,User.class);
        String username = user.getUsername();
        String password = user.getPassword();
        User user2 = userService.select(username,password);
        if(user2 != null){
            HttpSession session = req.getSession();
            session.setAttribute("user",user2);
            Cookie c_username = new Cookie("username",username);
            Cookie c_password = new Cookie("password",password);
            c_username.setMaxAge(60*60*24*7);
            c_password.setMaxAge(60*60*7*24);
            resp.addCookie(c_username);
            resp.addCookie(c_password);
            resp.getWriter().write("success");


        }else {
            // 登录失败
            //存储错误信息到request里
            req.setAttribute("login_msy","用户名或密码错误");
            resp.getWriter().write("false");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
