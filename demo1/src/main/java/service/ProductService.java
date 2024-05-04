package service;

import pojo.Product;

import java.util.List;

public interface ProductService {
    List<Product> selectAll();
    void add(String productname,Double price,Integer quantity);

    Product select(String productname);
}
