package service;

import pojo.Product;

import java.util.List;

public interface ProductService {
    List<Product> selectAll();
    void add(Product product);

    Product select(String productname);

    void delete(int id);

    void updata(int quantity,int id);
}
