package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;
import utils.JsonUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/product/search")
public class SearchServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String productname = req.getParameter("productname");
        System.out.println(productname);
        Product product = productService.select(productname);
        if(product!=null){
            Map<String, Object> map = new HashMap();
            map.put("productname",product.getProductname());
            map.put("quantity",product.getQuantity());
            String json2 = JsonUtil.toJsonMap(0, "success", map);
            resp.getWriter().write(json2);
        }else{
            resp.getWriter().write("false");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
