package com.huaweisoft.huawei5g.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huaweisoft.huawei5g.mapper.UserMapper;
import com.huaweisoft.huawei5g.model.User;
import com.huaweisoft.huawei5g.service.UserRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRankServiceImpl extends ServiceImpl<UserMapper, User> implements UserRankService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAllUser() {

        return userMapper.getUsers();

    }

    @Override
    public List<User> searchUsers(String mobileOrName) {

        return userMapper.searchUsers(mobileOrName);
    }

    @Override
    public Object findUserList(Integer pageNo, Integer pageSize) {
        IPage<User> page = new Page<>(pageNo, pageSize);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        IPage<User> userIPage = baseMapper.selectMyPage(page, wrapper);
        return userIPage;
    }

    @Override
    public boolean exportExcel() {

        return false;
    }
}
