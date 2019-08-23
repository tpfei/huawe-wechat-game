package com.huaweisoft.huawei5g.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huaweisoft.huawei5g.model.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public interface UserRankService extends IService<User> {

    Object searchUsers(String mobileOrName, Integer pageNo, Integer pageSize);

    Object findUserList(String weeks, Integer pageNo, Integer pageSize);

    Object findUserList(Integer pageNo, Integer pageSize);

    boolean exportExcel(HttpServletResponse response);
}
