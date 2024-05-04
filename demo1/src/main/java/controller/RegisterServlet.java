package controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.JsonUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user/register")
public class RegisterServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 不再处理 GET 请求
        resp.getWriter().write("GET method not supported, use POST instead.");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        resp.setContentType("text/json;charset=utf-8");
        //调试
        resp.setHeader("Access-Control-Allow-Origin", "*");//为什么必须有这个

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
        userService.add(username, password);

        String json2 = JsonUtil.toJsonMap(0, "success", null);
        resp.getWriter().write(json2);

    }
}
