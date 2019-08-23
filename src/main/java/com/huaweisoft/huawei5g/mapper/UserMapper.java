package com.huaweisoft.huawei5g.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.huaweisoft.huawei5g.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {

    List<User> getLists();

    /**
     * 自定义sql分页
     */
    IPage<User> searchUsers(IPage<User> page, @Param(Constants.WRAPPER) Wrapper<User> queryWrapper, String mobileOrName);

    IPage<User> rankByWeeks(IPage<User> page, @Param(Constants.WRAPPER) Wrapper<User> queryWrapper, String weeks);

    IPage<User> rankByTotalScore(IPage<User> page, @Param(Constants.WRAPPER) QueryWrapper<User> wrapper);
}