package controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
import java.util.Map;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        StringBuilder sb = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while((line=reader.readLine())!=null){
            sb.append(line);
        }

        String params = sb.toString();
        User p = JSON.parseObject(params,User.class);
        String username = p.getUsername();
        String password = p.getPassword();
        User user = userService.select(username,password);


        if(user != null){
            HttpSession session = req.getSession();
            session.setAttribute("user",user);


            resp.getWriter().write("success");


        }else {
            // 登录失败
            //存储错误信息到request里
            req.setAttribute("login_msy","用户名或密码错误");
            resp.getWriter().write("false");
        }

    }
}
