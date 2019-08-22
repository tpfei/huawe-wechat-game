package com.huaweisoft.huawei5g.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huaweisoft.huawei5g.consts.ResponseCode;
import com.huaweisoft.huawei5g.model.User;
import com.huaweisoft.huawei5g.service.impl.UserExcelServiceImpl;
import com.huaweisoft.huawei5g.service.impl.UserServiceImpl;
import com.huaweisoft.huawei5g.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Api(value = "UserController")
@RestController
@RequestMapping("/admin/user_info")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserExcelServiceImpl userExcelService;

    @ApiOperation(value="根据id获取用户", notes="根据id获取用户")
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

    @ApiOperation(value="新增用户")
    @PostMapping("/user")
    public ResponseResult addUser(@RequestBody User user) {
        Map<Integer, String> map = userService.addUser(user);
        return map.containsKey(1) ? ResponseResult.success() : ResponseResult.build(ResponseCode.ERROR, map);
    }

    @ApiOperation(value="根据id删除用户")
    @DeleteMapping("/user/{id}")
    public ResponseResult deleteUserById(@PathVariable("id") Integer id) {
        int flag = userService.deleteUserById(id);
        return flag == 0 ? ResponseResult.build(ResponseCode.ERROR, "id：" + id + "不存在") : ResponseResult.success();
    }

    @ApiOperation(value="批量删除用户", notes="批量删除用户")
    @DeleteMapping("/users")
    public ResponseResult deleteUsersBatch(@RequestBody List<Integer> ids) {
        int flag = userService.deleteUsersBatch(ids);
        return flag == 0 ? ResponseResult.error() : ResponseResult.success();
    }

    @ApiOperation(value="根据Excel表格导入用户数据")
    @PostMapping("/import")
    public ResponseResult importUsers(MultipartFile file) {
        List<User> users = userExcelService.importUsers(file);
        for (User u : users) {
            System.out.println(u);
        }
        int count = userService.addUsersBatch(users);
        System.out.println("count: " + count);
        return users == null ? ResponseResult.error() : ResponseResult.build(ResponseCode.SUCCESS, users);
    }

}
