package cn.crm.service;

import cn.crm.pojo.User;

import java.util.List;

public interface UserService {
    User login(User user);

    void registUser(User user);

    List<User> findAllUsers();

   // User loginByProcedure(User user);
}
