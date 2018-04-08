package com.gui.service;

import java.util.List;

import com.gui.pojo.User;

public interface UserService {

    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);
    User selectByPrimaryKey(Integer userId);
}
