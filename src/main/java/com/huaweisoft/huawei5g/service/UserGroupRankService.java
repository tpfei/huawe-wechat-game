package com.huaweisoft.huawei5g.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huaweisoft.huawei5g.model.UserGroup;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public interface UserGroupRankService extends IService<UserGroup> {

    Object findUserGroupList(Integer pageNo, Integer pageSize);

    boolean exportExcel(HttpServletResponse response);

    Object searchGroupList(String name, Integer pageNo, Integer pageSize);
}
