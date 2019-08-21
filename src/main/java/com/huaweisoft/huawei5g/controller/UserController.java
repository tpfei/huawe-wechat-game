package com.huaweisoft.huawei5g.controller;

import com.huaweisoft.huawei5g.model.User;
import com.huaweisoft.huawei5g.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "UserController")
@RestController
@RequestMapping("/admin/user_info")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @GetMapping("/user")
    public User getUserById(@RequestParam("id") Integer id) {
        return userService.getUserById(id);
    }

}
