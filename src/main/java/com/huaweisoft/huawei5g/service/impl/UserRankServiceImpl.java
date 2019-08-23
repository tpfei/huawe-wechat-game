package com.huaweisoft.huawei5g.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huaweisoft.huawei5g.consts.ExcelConstant;
import com.huaweisoft.huawei5g.consts.ResponseCode;
import com.huaweisoft.huawei5g.mapper.UserMapper;
import com.huaweisoft.huawei5g.model.User;
import com.huaweisoft.huawei5g.model.UserVO;
import com.huaweisoft.huawei5g.service.UserRankService;
import com.huaweisoft.huawei5g.utils.ConvertToVO;
import com.huaweisoft.huawei5g.utils.ExportExcelUtil;
import com.huaweisoft.huawei5g.utils.ExportExcelWrapper;
import com.huaweisoft.huawei5g.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Service
public class UserRankServiceImpl extends ServiceImpl<UserMapper, User> implements UserRankService {

    private final static String DATA_IS_NULL = "data is null.";
    @Autowired
    UserMapper userMapper;
    @Autowired
    private ConvertToVO convertToVO;
    @Autowired
    private ExportExcelWrapper exportExcelWrapper;

    @Override
    public Object searchUsers(String mobileOrName, Integer pageNo, Integer pageSize) {
        IPage<User> page = new Page<>(pageNo, pageSize);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        IPage<User> searchIPage = baseMapper.searchUsers(page, wrapper, mobileOrName);
        if (searchIPage == null) {
            return ResponseResult.build(ResponseCode.ERROR, DATA_IS_NULL);
        }
        return ResponseResult.build(ResponseCode.SUCCESS, searchIPage);
    }

    @Override
    public Object findUserList(Integer pageNo, Integer pageSize) {
        IPage<User> page = new Page<>(pageNo, pageSize);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        IPage<User> userIPage = baseMapper.rankByTotalScore(page, wrapper);
        if (userIPage == null) {
            return ResponseResult.build(ResponseCode.ERROR, DATA_IS_NULL);
        }
        return ResponseResult.build(ResponseCode.SUCCESS, userIPage);
    }

    @Override
    public Object findUserList(String weeks, Integer pageNo, Integer pageSize) {
        IPage<User> page = new Page<>(pageNo, pageSize);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        IPage<User> userIPage = baseMapper.rankByWeeks(page, wrapper, weeks);
        if (userIPage == null) {
            return ResponseResult.build(ResponseCode.ERROR, DATA_IS_NULL);
        }
        return ResponseResult.build(ResponseCode.SUCCESS, userIPage);
    }

    @Override
    public boolean exportExcel(HttpServletResponse response) {
        List<UserVO> usersVO = convertToVO.toUserVO(userMapper.getLists());
        String excelName = ExcelConstant.PERSON_RANK + ExcelConstant.SIMPLE_DATE_FORMAT.format(new Date());
        return exportExcelWrapper.exportExcel(excelName, ExcelConstant.PERSON_TITLE, ExcelConstant.USER_COLUMN_NAMES, usersVO, response, ExportExcelUtil.EXCEl_FILE_2007);
    }
}
