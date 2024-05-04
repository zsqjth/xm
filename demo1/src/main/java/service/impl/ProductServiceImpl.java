package service.impl;

import dao.ProductMapper;
import dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Product;
import pojo.User;
import service.ProductService;
import utils.SqlsessionFactoryUtils;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    SqlSessionFactory factory = SqlsessionFactoryUtils.getSqlsessionFactory();
    @Override
    public List<Product> selectAll() {
        //2 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3 获取MAPPER代理
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        List<Product> products = mapper.selectAll();
        sqlSession.close();
        return products;
    }

    @Override
    public void add(String productname, Double price, Integer quantity) {
        //2 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3 获取MAPPER代理
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        mapper.add(productname, price, quantity);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public Product select(String productname) {
        //2 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3 获取MAPPER代理
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        Product select = mapper.select(productname);
        sqlSession.close();
        return select;
    }


}
