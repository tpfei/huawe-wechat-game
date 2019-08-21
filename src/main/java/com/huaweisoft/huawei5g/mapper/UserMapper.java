package com.huaweisoft.huawei5g.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.huaweisoft.huawei5g.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {
    List<User> getUsers();

    List<User> searchUsers(String mobileOrName);


    /**
     * 自定义sql分页
     *
     * @param page
     * @param queryWrapper
     * @return
     */
    IPage<User> selectMyPage(IPage<User> page, @Param(Constants.WRAPPER) Wrapper<User> queryWrapper);

    User getUserById(Integer id);

    int addUser(User user);

    int deleteUserById(Integer id);

}