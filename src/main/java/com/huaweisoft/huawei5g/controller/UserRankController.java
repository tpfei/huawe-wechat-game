package com.huaweisoft.huawei5g.controller;

import com.huaweisoft.huawei5g.consts.ResponseCode;
import com.huaweisoft.huawei5g.consts.Weeks;
import com.huaweisoft.huawei5g.service.UserRankService;
import com.huaweisoft.huawei5g.utils.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Api(value = "个人排行 ")
@RequestMapping(value = "/admin")
@RestController
public class UserRankController {
    @Autowired
    private UserRankService userRankServiceImpl;

    @RequestMapping(value = "/getUsers/{weeks}", method = RequestMethod.POST)
    public Object getAllUser(@PathVariable("weeks") String weeks,
                             @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                             @RequestParam(value = "pageSize", defaultValue = "2") Integer pageSize) {

        if (Arrays.asList(Weeks.WEEKS).contains(weeks)) {
            return userRankServiceImpl.findUserList(weeks, pageNo, pageSize);
        }
        return userRankServiceImpl.findUserList(pageNo, pageSize);
    }

    @RequestMapping(value = "/searchUsers/{mobileOrName}", method = RequestMethod.POST)
    public Object searchUsers(@PathVariable("mobileOrName") String mobileOrName,
                              @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                              @RequestParam(value = "pageSize", defaultValue = "2") Integer pageSize) {
        return userRankServiceImpl.searchUsers(mobileOrName, pageNo, pageSize);
    }

    @RequestMapping(value = "/exportExcel", method = RequestMethod.POST)
    public Object exportExcel(HttpServletResponse response) {
        if (userRankServiceImpl.exportExcel(response)) {
            return ResponseResult.build(ResponseCode.SUCCESS);
        }
        return ResponseResult.build(ResponseCode.ERROR);
    }
}
