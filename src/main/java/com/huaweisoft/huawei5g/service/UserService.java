package com.huaweisoft.huawei5g.service;

import com.huaweisoft.huawei5g.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User getUserById(Integer id);

    List<User> getUsers();

    Map<Integer, String> addUser(User user);

    int deleteUserById(Integer id);

    int deleteUsersBatch(List<Integer> ids);

    int addUsersBatch(List<User> users);
}
