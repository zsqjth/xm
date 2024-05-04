package dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.Product;

import java.util.List;

public interface ProductMapper {
    @Select("select * from product")
    List<Product> selectAll();
    @Insert("insert into product values (null,#{productname},#{price},#{quantity})")
    void add(@Param("productname")String productname , @Param("price")Double price,@Param("quantity")Integer quantity);

    @Select("select * from product where productname=#{productname}")
    Product select(@Param("productname")  String productname);
}
