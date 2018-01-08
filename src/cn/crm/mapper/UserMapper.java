package cn.crm.mapper;

import cn.crm.pojo.User;

import java.util.List;

public interface UserMapper {

    void registUser(User user);
    User login(User user);

    List<User> findAllUsers();

    User loginByProcedure(User user);
}
