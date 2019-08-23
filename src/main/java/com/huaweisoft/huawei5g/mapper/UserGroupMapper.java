package com.huaweisoft.huawei5g.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.huaweisoft.huawei5g.model.UserGroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGroupMapper extends BaseMapper<UserGroup> {

    List<UserGroup> getUserGroups();

    IPage<UserGroup> selectMyPage(IPage<UserGroup> page, @Param(Constants.WRAPPER) QueryWrapper<UserGroup> wrapper);

    IPage<UserGroup> serachUserGroups(IPage<UserGroup> page, @Param(Constants.WRAPPER) QueryWrapper<UserGroup> wrapper, String groupname);
}