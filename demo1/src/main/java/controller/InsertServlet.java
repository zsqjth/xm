package controller;

import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/product/insert")
public class InsertServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
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
        Product product = JSON.parseObject(params,Product.class);
        productService.add(product.getProductname(),product.getPrice(),product.getQuantity());

    }
}
