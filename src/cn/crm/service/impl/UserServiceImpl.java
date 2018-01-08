package cn.crm.service.impl;

import cn.crm.mapper.UserMapper;
import cn.crm.pojo.User;
import cn.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
    @Override
    public void registUser(User user) {
        userMapper.registUser(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }

    @Override
    public User loginByProcedure(User user) {
        return userMapper.loginByProcedure(user);
    }
}
