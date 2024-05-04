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

        Map<String, String[]> parameterMap = req.getParameterMap();
        String username = parameterMap.get("username")[0];
        String password = parameterMap.get("password")[0];

        System.out.println(username);
        System.out.println(password);
        try {
            userService.add(username, password);
            String json2 = JsonUtil.toJsonMap(0, "success", null);
            resp.getWriter().write(json2);
        } catch (NumberFormatException e) {
            // 非数字值异常处理
            e.printStackTrace();
            String jsonError = JsonUtil.toJsonMap(1, "Invalid input data format", null);
            resp.getWriter().write(jsonError);
        } catch (Exception e) {
            // 其他异常处理
            e.printStackTrace();
            String jsonError = JsonUtil.toJsonMap(2, "Internal server error", null);
            resp.getWriter().write(jsonError);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
