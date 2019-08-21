package com.huaweisoft.huawei5g.controller;

import com.huaweisoft.huawei5g.consts.ResponseCode;
import com.huaweisoft.huawei5g.model.User;
import com.huaweisoft.huawei5g.service.UserRankService;
import com.huaweisoft.huawei5g.utils.ExportExcelUtil;
import com.huaweisoft.huawei5g.utils.ExportExcelWrapper;
import com.huaweisoft.huawei5g.utils.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Api(value = "UserRankController ")
@RequestMapping(value = "/admin")
@RestController
public class UserRankController {
    private final static String DATA_IS_NULL = "data is null.";
    private ResponseResult<List<User>> result;
    private List<User> users;
    @Autowired
    private UserRankService userRankServiceImpl;
    @Autowired
    ExportExcelWrapper exportExcelWrapper;

    @RequestMapping(value = "/getUsers", method = RequestMethod.POST)
    public Object getAllUser(HttpServletRequest request) {

        users = userRankServiceImpl.getAllUser();
        if (users == null || users.size() == 0) {
            return ResponseResult.build(ResponseCode.ERROR, DATA_IS_NULL);
        } else {
            return ResponseResult.build(ResponseCode.SUCCESS, users);
        }
    }

    @RequestMapping(value = "/searchUsers/{mobileOrName}", method = RequestMethod.POST)
    public Object searchUsers(@PathVariable("mobileOrName") String mobileOrName) {
        users = userRankServiceImpl.searchUsers(mobileOrName);
        if (users == null || users.size() == 0) {
            return ResponseResult.build(ResponseCode.ERROR, DATA_IS_NULL);
        } else {
            return ResponseResult.build(ResponseCode.SUCCESS, users);
        }
    }

    @RequestMapping(value = "/exportExcel", method = RequestMethod.POST)
    public String exportExcel(HttpServletResponse response) throws FileNotFoundException {
        users = userRankServiceImpl.getAllUser();
        String[] columnNames = {"排名", "ID", "累计积分", "累计积分排名", "本周积分", "本周积分排名", "签到次数", "签到积分",
                "闯关到达", "闯关次数", "闯关积分", "竞赛次数", "竞赛积分", "竞赛胜", "竞赛负", "姓名", "手机号", "组织", "分数"};

//        String fileName = "testAccountBill";
//        //网页导出Excel表
//        exportExcelWrapper.exportExcel(fileName, "用户导出", columnNames, list, response, ExportExcelUtil.EXCEl_FILE_2007);
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmss");
        String fileName = "users" + sf.format(new Date());
        exportExcelWrapper.exportExcel("用户导出", columnNames, users, new FileOutputStream("D:/" + fileName + ".xlsx"), ExportExcelUtil.EXCEl_FILE_2007);
        return "success";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    public Object getAll(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "2") Integer pageSize) {

        users = (List<User>) userRankServiceImpl.findUserList(pageNo, pageSize);
        if (users == null || users.size() == 0) {
            return ResponseResult.build(ResponseCode.ERROR, DATA_IS_NULL);
        } else {
            return ResponseResult.build(ResponseCode.SUCCESS, users);
        }
    }
}
