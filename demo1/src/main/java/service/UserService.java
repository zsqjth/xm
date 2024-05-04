package service;

import pojo.User;

public interface UserService {
    void add(String username ,String password);
    User select(String username,String password);

}
