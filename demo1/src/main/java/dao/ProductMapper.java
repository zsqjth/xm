package dao;


import org.apache.ibatis.annotations.Select;
import pojo.Product;

import java.util.List;

public interface ProductMapper {
    @Select("select * from product")
    List<Product> selectAll();
    
}
