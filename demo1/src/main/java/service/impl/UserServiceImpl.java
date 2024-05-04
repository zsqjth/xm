package service.impl;

import dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.User;
import service.UserService;
import utils.SqlsessionFactoryUtils;

public class UserServiceImpl implements UserService {
    SqlSessionFactory factory = SqlsessionFactoryUtils.getSqlsessionFactory();

    @Override
    public void add(String username, String password) {
        //2 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3 获取MAPPER代理
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.add(username, password);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public User select(String username, String password) {
        //2 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3 获取MAPPER代理
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User select = mapper.select(username, password);
        return select;

    }


}
