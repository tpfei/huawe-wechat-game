package com.huaweisoft.huawei5g.controller;

import com.huaweisoft.huawei5g.consts.ResponseCode;
import com.huaweisoft.huawei5g.service.UserGroupRankService;
import com.huaweisoft.huawei5g.utils.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@Api(value = "用户组排行 ")
@RequestMapping(value = "/admin")
@RestController
public class UserGroupRankController {
    @Autowired
    private UserGroupRankService userGroupRankServiceImpl;

    @RequestMapping(value = "/getUserGroups", method = RequestMethod.POST)
    public Object getAll(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                         @RequestParam(value = "pageSize", defaultValue = "2") Integer pageSize) {
        return userGroupRankServiceImpl.findUserGroupList(pageNo, pageSize);
    }

    @RequestMapping(value = "/serachUserGroups", method = RequestMethod.POST)
    public Object serachUserGroups(@RequestParam(value = "name", defaultValue = "test") String name,
                                   @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                   @RequestParam(value = "pageSize", defaultValue = "2") Integer pageSize) {
        return userGroupRankServiceImpl.searchGroupList(name, pageNo, pageSize);
    }


    @RequestMapping(value = "/exportUserGroups", method = RequestMethod.POST)
    public Object exportExcel(HttpServletResponse response) {
        if (userGroupRankServiceImpl.exportExcel(response)) {
            return ResponseResult.build(ResponseCode.SUCCESS);
        }
        return ResponseResult.build(ResponseCode.ERROR);
    }
}
