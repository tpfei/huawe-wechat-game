package com.huaweisoft.huawei5g.service.impl;

import com.huaweisoft.huawei5g.mapper.UserGroupMapper;
import com.huaweisoft.huawei5g.model.User;
import com.huaweisoft.huawei5g.service.UserExcelService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserExcelServiceImpl implements UserExcelService {
    private static final String EXCEL2003 = "xls";

    private static final String EXCEL2007 = "xlsx";

    private static final int TEMPLATE_COLUMN_SIZE = 7;

    @Autowired
    UserGroupMapper userGroupMapper;

    /**
     * 读取并解析Excel，获取用户信息并存入数据库
     * @param file
     * @return
     */
    @Override
    public List<User> importUsers(MultipartFile file) {
        Workbook wb = null;
        try {
            String fileName = file.getOriginalFilename();
            if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
                System.out.println("上传文件格式不正确");
            }
            // 创建输入流，读取Excel
            InputStream is = file.getInputStream();
            List<User> users = new ArrayList<>();
            // 创建Workbook类
            if (fileName.endsWith(EXCEL2007)) {
                wb = new XSSFWorkbook(is);
                // 拿到shhet1页签的数据
                XSSFSheet xssfSheet = (XSSFSheet)wb.getSheetAt(0);
                // 读取excel中的数据，放到List中
                users = readDataFromXSSFSheet(xssfSheet);
            } else if (fileName.endsWith(EXCEL2003)) {
                wb = new HSSFWorkbook(is);
                HSSFSheet hssfSheet = (HSSFSheet)wb.getSheetAt(0);
                users = readDataFromHSSFSheet(hssfSheet);
            } else {
                return null;
            }

            return setDefaultProperty(users);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (wb != null) {
                    wb.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private List<User> setDefaultProperty(List<User> users) {
        for (User u : users) {
            u.setId(0);
            u.setCreatedAt(0);
            u.setUpdateAt(0);
        }
        return users;
    }

    private List<User> readDataFromHSSFSheet(HSSFSheet hssfSheet) {
        ArrayList<User> users = new ArrayList<>();
        // 每列内容写死，可能需要改动
        for (int i=1; i<=hssfSheet.getLastRowNum(); i++) {
            if (hssfSheet.getRow(i).getCell(0) == null || hssfSheet.getRow(i).getCell(0).getStringCellValue().trim().equals("")) {
                break;
            }
            User user = new User();

            HSSFCell usernameCell = hssfSheet.getRow(i).getCell(0);
            String username = usernameCell.getStringCellValue().trim();
            user.setUsername(username);

            HSSFCell nickNameCell = hssfSheet.getRow(i).getCell(1);
            String nickName = nickNameCell.getStringCellValue().trim();
            user.setNickName(nickName);

            HSSFCell imageCell = hssfSheet.getRow(i).getCell(2);
            String image = imageCell.getStringCellValue().trim();
            user.setImage(image);

            HSSFCell userGroupNameCell = hssfSheet.getRow(i).getCell(3);
            String userGroupName = userGroupNameCell.getStringCellValue().trim();
            Integer userGroupId = userGroupMapper.getIdByUserGroupName(userGroupName);
            // 若不存在该组织，默认将用户放到顶级组织
            if (userGroupId == null) {
                userGroupId = 0;
            }
            user.setGroupid(userGroupId);

            HSSFCell emailCell = hssfSheet.getRow(i).getCell(4);
            String email = emailCell.getStringCellValue().trim();
            user.setEmail(email);

            HSSFCell mobileCell = hssfSheet.getRow(i).getCell(5);
            String mobile = mobileCell.getStringCellValue().trim();
            user.setMobile(mobile);

            HSSFCell statusCell = hssfSheet.getRow(i).getCell(6);
            Byte status = (byte)statusCell.getNumericCellValue();
            user.setStatus(status);

            users.add(user);
        }
        return users;
    }

    private List<User> readDataFromXSSFSheet(XSSFSheet xssfSheet) {
        ArrayList<User> users = new ArrayList<>();
        // 最好是将数字设置成文本
        for (int i=1; i<=xssfSheet.getLastRowNum(); i++) {
            if (xssfSheet.getRow(i).getCell(0) == null || xssfSheet.getRow(i).getCell(0).getStringCellValue().trim().equals("")) {
                break;
            }
            User user = new User();

            XSSFCell usernameCell = xssfSheet.getRow(i).getCell(0);
            String username = usernameCell.getStringCellValue().trim();
            user.setUsername(username);

            XSSFCell nickNameCell = xssfSheet.getRow(i).getCell(1);
            String nickName = nickNameCell.getStringCellValue().trim();
            user.setNickName(nickName);

            XSSFCell imageCell = xssfSheet.getRow(i).getCell(2);
            String image = imageCell.getStringCellValue().trim();
            user.setImage(image);

            XSSFCell userGroupNameCell = xssfSheet.getRow(i).getCell(3);
            String userGroupName = userGroupNameCell.getStringCellValue().trim();
            Integer userGroupId = userGroupMapper.getIdByUserGroupName(userGroupName);
            // 若不存在该组织，默认将用户放到顶级组织
            if (userGroupId == null) {
                userGroupId = 0;
            }
            user.setGroupid(userGroupId);

            XSSFCell emailCell = xssfSheet.getRow(i).getCell(4);
            String email = emailCell.getStringCellValue().trim();
            user.setEmail(email);

            XSSFCell mobileCell = xssfSheet.getRow(i).getCell(5);
            String mobile = mobileCell.getStringCellValue().trim();
            user.setMobile(mobile);

            XSSFCell statusCell = xssfSheet.getRow(i).getCell(6);
            Byte status = (byte)statusCell.getNumericCellValue();
            user.setStatus(status);

            users.add(user);
        }
        return users;
    }

    @Override
    public int exportTemplate(HttpServletResponse response) {
        return 0;
    }
}
