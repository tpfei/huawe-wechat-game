package com.huaweisoft.huawei5g.service;

import com.huaweisoft.huawei5g.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Integer id);

    List<User> getUsers();
}
