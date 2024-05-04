package dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.Product;

import java.util.List;

public interface ProductMapper {
    @Select("select * from product")
    List<Product> selectAll();

    void add(Product product);

    @Select("select * from product where productname=#{productname}")
    Product select(@Param("productname")  String productname);

    void update(@Param("quantity") int quantity,@Param("id") int id);


    void deleteByid(Integer id);
}
