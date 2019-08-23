package com.huaweisoft.huawei5g.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huaweisoft.huawei5g.consts.ExcelConstant;
import com.huaweisoft.huawei5g.consts.ResponseCode;
import com.huaweisoft.huawei5g.mapper.UserGroupMapper;
import com.huaweisoft.huawei5g.model.UserGroup;
import com.huaweisoft.huawei5g.model.UserGroupVO;
import com.huaweisoft.huawei5g.service.UserGroupRankService;
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
public class UserGroupRankServiceImpl extends ServiceImpl<UserGroupMapper, UserGroup> implements UserGroupRankService {

    private List<UserGroupVO> usergroups;
    private final static String DATA_IS_NULL = "data is null.";
    @Autowired
    private UserGroupMapper userGroupMapper;
    @Autowired
    private ConvertToVO convertToVO;
    @Autowired
    private ExportExcelWrapper exportExcelWrapper;

    @Override
    public Object findUserGroupList(Integer pageNo, Integer pageSize) {
        IPage<UserGroup> page = new Page<>(pageNo, pageSize);
        QueryWrapper<UserGroup> wrapper = new QueryWrapper<>();
        IPage<UserGroup> userPages = baseMapper.selectMyPage(page, wrapper);
        if (userPages == null) {
            return ResponseResult.build(ResponseCode.ERROR, DATA_IS_NULL);
        }
        return ResponseResult.build(ResponseCode.SUCCESS, userPages);
    }

    @Override
    public boolean exportExcel(HttpServletResponse response) {
        usergroups = convertToVO.toUserGroupVO(userGroupMapper.getUserGroups());
        String excelName = ExcelConstant.USERGROUP_RANK + ExcelConstant.SIMPLE_DATE_FORMAT.format(new Date());
        return exportExcelWrapper.exportExcel(excelName, ExcelConstant.USERGROUP_TITLE, ExcelConstant.USERGROUP_COLUMN_NAMES, usergroups, response, ExportExcelUtil.EXCEl_FILE_2007);
    }

    @Override
    public Object searchGroupList(String name, Integer pageNo, Integer pageSize) {
        IPage<UserGroup> page = new Page<>(pageNo, pageSize);
        QueryWrapper<UserGroup> wrapper = new QueryWrapper<>();
        IPage<UserGroup> userPages = baseMapper.serachUserGroups(page, wrapper, name);
        if (userPages == null) {
            return ResponseResult.build(ResponseCode.ERROR, DATA_IS_NULL);
        }
        return ResponseResult.build(ResponseCode.SUCCESS, userPages);
    }
}
