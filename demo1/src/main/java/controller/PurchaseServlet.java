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

@WebServlet("/product/purchase")
public class PurchaseServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int number = Integer.parseInt(req.getParameter("number"));
        Product product = productService.select(name);
        int quantity = product.getQuantity();
        System.out.println(quantity);
        System.out.println(number);
        quantity = quantity - number;
        System.out.println(quantity);
        productService.updata(quantity,product.getId());
        String json2 = JsonUtil.toJsonMap(0, "success", null);
        resp.getWriter().write(json2);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
