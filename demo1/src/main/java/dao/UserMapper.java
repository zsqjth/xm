package dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.User;

public interface UserMapper {
    @Select("select * from user where username = #{username} and password = #{password}")
    User select(@Param("username")  String username, @Param("password") String password);

    @Insert("insert into user values (#{username},#{password})")
    void add(@Param("username")String username ,@Param("password")String password);

}
