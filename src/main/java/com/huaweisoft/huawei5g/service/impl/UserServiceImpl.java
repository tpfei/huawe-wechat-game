package com.huaweisoft.huawei5g.service.impl;

import com.huaweisoft.huawei5g.mapper.UserMapper;
import com.huaweisoft.huawei5g.model.User;
import com.huaweisoft.huawei5g.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    private Map<Integer, String> map =  new HashMap<>();

    public Map<Integer, String> addUser(User user) {
        map.clear();
        checkAddUser(user);

        if (map == null || map.size() == 0) {
            int flag = userMapper.addUser(user);
            map.put(flag, "插入成功");
        } else {
            map.put(0, "插入失败");
        }
        return map;
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    private void checkAddUser(User user) {
        if (user == null) {
            map.put(2, "用户信息不能为空");
        }
        if (user.getUsername() == null || user.getUsername().trim().length() == 0) {
            map.put(3, "用户名不能为空");
        }
        if(user.getMobile() == null || user.getMobile().trim().length() == 0) {
            map.put(4, "手机号不能为空");
        } else {
            if (mobileExsist(user.getMobile())) {
                map.put(5, "手机号码已经存在");
            }
        }
        if (user.getCreatedAt() == null) {
            map.put(6, "注册时间不能为空");
        }
        if (user.getUpdateAt() == null) {
            map.put(7, "更新时间不能为空");
        }
    }

    private boolean mobileExsist(String mobile) {
        //向数据库中查询出所有手机号码
        List<User> users = getUsers();
        List<String> mobiles = users.stream().map(User::getMobile).collect(Collectors.toList());
        //判断是否重复
        if (mobiles.contains(mobile)) {
            return true;
        }
        return false;
    }
}
