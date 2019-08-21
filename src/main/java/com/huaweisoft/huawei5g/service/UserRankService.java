package com.huaweisoft.huawei5g.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huaweisoft.huawei5g.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRankService extends IService<User> {
    List<User> getAllUser();

    List<User> searchUsers(String mobileOrName);

    /**
     * 查询用户列表
     *
     * @return
     */
    Object findUserList(Integer pageNo, Integer pageSize);

    boolean exportExcel();
}
