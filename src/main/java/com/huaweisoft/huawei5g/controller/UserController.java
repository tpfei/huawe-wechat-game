package com.huaweisoft.huawei5g.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huaweisoft.huawei5g.consts.ResponseCode;
import com.huaweisoft.huawei5g.model.User;
import com.huaweisoft.huawei5g.service.impl.UserServiceImpl;
import com.huaweisoft.huawei5g.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "UserController")
@RestController
@RequestMapping("/admin/user_info")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @GetMapping("/user")
    public User getUserById(@RequestParam("id") Integer id) {
        User user = userService.getUserById(id);
        System.out.println(user);
        return user;
    }

    @ApiOperation(value="获取全部用户信息，带分页信息")
    @GetMapping("/users")
    public ResponseResult getAllUsers(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userService.getUsers();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return ResponseResult.build(ResponseCode.SUCCESS,userPageInfo);
    }


}
