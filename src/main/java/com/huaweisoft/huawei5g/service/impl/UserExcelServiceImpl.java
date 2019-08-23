package com.huaweisoft.huawei5g.service.impl;

import com.huaweisoft.huawei5g.mapper.UserGroupMapper;
import com.huaweisoft.huawei5g.mapper.UserMapper;
import com.huaweisoft.huawei5g.model.User;
import com.huaweisoft.huawei5g.model.UserGroup;
import com.huaweisoft.huawei5g.service.UserExcelService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.*;

@Service
public class UserExcelServiceImpl implements UserExcelService {
    private static final String EXCEL2003 = "xls";

    private static final String EXCEL2007 = "xlsx";

    private static final int TEMPLATE_COLUMN_SIZE = 7;

    private static final int MOBILE_COLUMN = 5;

    @Autowired
    UserGroupMapper userGroupMapper;

    @Autowired
    UserMapper userMapper;

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
            // 若不存在该组织，将用户设置为无组织状态
            if (userGroupId == null) {
                user.setGroupid(-1);
                user.setUserGroup(new UserGroup(-1, "无组织"));
            } else {
                user.setGroupid(userGroupId);
                user.setUserGroup(new UserGroup(userGroupId, userGroupName));
            }


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

    public int addUsersBatch(List<User> users, HttpServletResponse response) {
        //判断导入的数据本身是否有重复
        Set<Set<Integer>> repeatRows = hasRepeatData(users);
        //若有重复的行
        if (repeatRows.size() > 0) {
            //生成Excel到前端，重复的行用不同背景颜色
            exportSelfRepeatExcel(users, response, repeatRows, "ROW");
            return 0;
        }

        //判断导入的数据本身手机号是否重复
        Set<Set<Integer>> repeatMobiles = hasSelfRepeatMobiles(users);
        if (repeatMobiles.size() > 0) {
            //生成Excel到前端，重复的手机号用不同背景颜色
            exportSelfRepeatExcel(users, response, repeatMobiles, "MOBILE");
            return 0;
        }

        //判断是否导入重复的数据
        List<User> databaseUsers = userMapper.getUsers();
        List<User> retainUsers = new ArrayList<>();
        retainUsers.addAll(databaseUsers);
        retainUsers.retainAll(users);
        Set<Integer> repeatRow = new HashSet<>();
        if (retainUsers.size() > 0) {
            for (int i=0; i<users.size(); i++) {
                for (User u : retainUsers) {
                    if (u.equals(users.get(i))) {
                        repeatRow.add(i);
                    }
                }
            }
        }
        if (repeatRow.size() > 0) {
            exportDataBaseRepeatExcel(users, response, repeatRow, "ROW");
            return 0;
        }


        //校验手机号码是否已经被注册
        HashSet<Integer> repeatMobilesData = hasDatabaseRepeatMobiles(databaseUsers, users);
        repeatMobilesData.stream().forEach(System.out::println);
        return userMapper.addUsersBatch(users);
    }

    private void exportDataBaseRepeatExcel(List<User> users, HttpServletResponse response, Set<Integer> repeatData, String flag) {
        XSSFWorkbook wb = new XSSFWorkbook();
        //生成excel页签
        Sheet sheet = wb.createSheet("Sheet1");
        sheet.setDefaultColumnWidth(11);

        //生成Excel标题行
        Row titleRow = sheet.createRow(0);
        for (int i=0; i<TEMPLATE_COLUMN_SIZE; i++) {
            Cell cell = titleRow.createCell(i);
            cell.setCellValue(getTemplateHeader().get(i));
        }

        setTemplateCellStyle(wb, sheet);

        //将数据写入excel中
        for (int i=0; i<users.size(); i++) {
            Row nextRow = sheet.getRow(i + 1);
            User user = users.get(i);
            nextRow.createCell(0).setCellValue(user.getUsername());
            nextRow.createCell(1).setCellValue(user.getNickName());
            nextRow.createCell(2).setCellValue(user.getImage());
            nextRow.createCell(3).setCellValue(user.getUserGroup().getName());
            nextRow.createCell(4).setCellValue(user.getEmail());
            nextRow.createCell(5).setCellValue(user.getMobile());
            nextRow.createCell(6).setCellValue(user.getStatus());
        }

        if ("ROW".equals(flag)) {
            //对excel数据重复的行增加背景颜色
            setDatabaseRepeatRowStyle(wb, repeatData);
        } else if ("MOBILE".equals(flag)) {
            //对excel数据重复的手机号增加背景颜色
            setDataBaseRepeatMobileStyle(wb, repeatData);
        }

        //生成Excel文件
        buildExcelDocument("数据库中某用户已存在.xlsx",wb,response);
    }

    private void setDataBaseRepeatMobileStyle(XSSFWorkbook wb, Set<Integer> repeatRows) {
        for (Integer i : repeatRows) {
            XSSFCellStyle style = wb.createCellStyle();
            style.setFillForegroundColor(IndexedColors.RED.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            //对这重复的手机号列添加背景颜色
            wb.getSheet("Sheet1").getRow(i + 1).getCell(MOBILE_COLUMN).setCellStyle(style);
        }
    }

    private void setDatabaseRepeatRowStyle(XSSFWorkbook wb, Set<Integer> repeatRows) {
        for (Integer i : repeatRows) {
            XSSFCellStyle style = wb.createCellStyle();
            style.setFillForegroundColor(IndexedColors.RED.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            //对这一行的所有列添加背景颜色
            for (int j=0; j<TEMPLATE_COLUMN_SIZE; j++) {
                wb.getSheet("Sheet1").getRow(i + 1).getCell(j).setCellStyle(style);
            }
        }
    }

    private Set<Set<Integer>> hasSelfRepeatMobiles(List<User> users) {
        Set<Set<Integer>> repeatRows = new HashSet<>();
        for (int i=0; i<users.size()-1; i++) {
            String mobile = users.get(i).getMobile();
            for (int j=i+1; j<users.size(); j++) {
                String nextMobile = users.get(j).getMobile();
                if (mobile.equals(nextMobile)) {
                    //先判断跟之前存在的是否相同
                    boolean isExistRepeat = false;
                    for (Set<Integer> set : repeatRows) {
                        for (Integer oldRow : set) {
                            if (users.get(oldRow).getMobile().equals(mobile) || users.get(oldRow).getMobile().equals(nextMobile)) {
                                set.add(i);
                                set.add(j);
                                isExistRepeat = true;
                                break;
                            }
                        }
                    }
                    if (!isExistRepeat) {
                        Set<Integer> newRepeatSet = new HashSet<>();
                        newRepeatSet.add(i);
                        newRepeatSet.add(j);
                        repeatRows.add(newRepeatSet);
                    }
                }
            }
        }
        return repeatRows;
    }

    private void exportSelfRepeatExcel(List<User> users, HttpServletResponse response, Set<Set<Integer>> repeatData, String flag) {
        XSSFWorkbook wb = new XSSFWorkbook();
        //生成excel页签
        Sheet sheet = wb.createSheet("Sheet1");
        sheet.setDefaultColumnWidth(11);

        //生成Excel标题行
        Row titleRow = sheet.createRow(0);
        for (int i=0; i<TEMPLATE_COLUMN_SIZE; i++) {
            Cell cell = titleRow.createCell(i);
            cell.setCellValue(getTemplateHeader().get(i));
        }

        setTemplateCellStyle(wb, sheet);

        //将数据写入excel中
        for (int i=0; i<users.size(); i++) {
            Row nextRow = sheet.getRow(i + 1);
            User user = users.get(i);
            nextRow.createCell(0).setCellValue(user.getUsername());
            nextRow.createCell(1).setCellValue(user.getNickName());
            nextRow.createCell(2).setCellValue(user.getImage());
            nextRow.createCell(3).setCellValue(user.getUserGroup().getName());
            nextRow.createCell(4).setCellValue(user.getEmail());
            nextRow.createCell(5).setCellValue(user.getMobile());
            nextRow.createCell(6).setCellValue(user.getStatus());
        }


        if ("ROW".equals(flag)) {
            //对excel数据重复的行增加背景颜色
            setSelfRepeatRowStyle(wb, repeatData);
        } else if ("MOBILE".equals(flag)) {
            //对excel数据重复的手机号增加背景颜色
            setSelfRepeatMobileStyle(wb, repeatData);
        }

        //生成Excel文件
        buildExcelDocument("error.xlsx",wb,response);
    }

    private void setSelfRepeatMobileStyle(XSSFWorkbook wb, Set<Set<Integer>> repeatData) {
        short color = 2;
        for (Set<Integer> set : repeatData) {
            for (Integer i : set) {
                XSSFCellStyle style = wb.createCellStyle();
                style.setFillForegroundColor(color);
                style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                //对这一行的所有列添加背景颜色
                wb.getSheet("Sheet1").getRow(i + 1).getCell(MOBILE_COLUMN).setCellStyle(style);
            }
            color ++;
            if (color == 64) {
                color = 0;
            }
        }
    }

    private void setSelfRepeatRowStyle(XSSFWorkbook wb, Set<Set<Integer>> repeatRows) {
        short color = 2;
        for (Set<Integer> set : repeatRows) {
            for (Integer i : set) {
                XSSFCellStyle style = wb.createCellStyle();
                style.setFillForegroundColor(color);
                style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                //对这一行的所有列添加背景颜色
                for (int j=0; j<TEMPLATE_COLUMN_SIZE; j++) {
                    wb.getSheet("Sheet1").getRow(i + 1).getCell(j).setCellStyle(style);
                }
            }
            color ++;
            if (color == 64) {
                color = 0;
            }
        }
    }

    /**
     * 浏览器下载excel
     * @param fileName
     * @param wb
     * @param response
     */
    private void buildExcelDocument(String fileName, Workbook wb,HttpServletResponse response){
        try {
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "utf-8"));
            response.flushBuffer();
            wb.write(response.getOutputStream());
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置模版的单元格样式
     * @param wb
     * @param sheet
     */
    private void setTemplateCellStyle(XSSFWorkbook wb, Sheet sheet) {
        //文本格式
        XSSFCellStyle textCellStyle = wb.createCellStyle();
        textCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("@"));//设置格式为文本

        //设置日期格式
        /*XSSFCellStyle dateCellStyle = wb.createCellStyle();
        XSSFDataFormat df = wb.createDataFormat(); // 此处设置数据格式
        dateCellStyle.setDataFormat(df.getFormat("yyyy-MM-dd HH:mm:ss"));*/

        //数值格式
        XSSFCellStyle digitCellStyle = wb.createCellStyle();
        XSSFDataFormat format = wb.createDataFormat();
        digitCellStyle.setDataFormat(format.getFormat("#,#0"));

        for (int i=1; i<1000; i++) {
            Row row = sheet.createRow(i);
            for (int j=0; j<TEMPLATE_COLUMN_SIZE; j++) {
                if (j == 5) {
                    row.createCell(j).setCellStyle(textCellStyle);
                }
                if (j == 6) {
                    row.createCell(j).setCellStyle(digitCellStyle);
                }
            }
        }


    }

    //模版标题数据
    private List<String> getTemplateHeader() {
        return Arrays.asList("用户名", "昵称", "头像", "部门", "邮箱", "手机", "状态");
    }

    private HashSet<Integer> hasDatabaseRepeatMobiles(List<User> databaseUsers, List<User> users) {
        HashSet<Integer> repeatMobilesRows = new HashSet<>();
        for (int i=0; i<databaseUsers.size(); i++) {
            User databaseUser = databaseUsers.get(i);
            for (int j=0; j<users.size(); j++) {
                User nextUser = users.get(j);
                if (databaseUser.getMobile().equals(nextUser.getMobile())) {
                    repeatMobilesRows.add(i);
                    repeatMobilesRows.add(j);
                }
            }
        }
        return repeatMobilesRows;
    }

    /*private Set<Integer> hasRepeatData(List<User> users) {
        Set<Integer> repeatRows = new HashSet<>();
        for (int i=0; i<users.size()-1; i++) {
            User user = users.get(i);
            for (int j=i+1; j<users.size(); j++) {
                User userNext = users.get(j);
                if (user.equals(userNext)) {
                    repeatRows.add(i);
                    repeatRows.add(j);
                }
            }
        }
        return repeatRows;
    }*/
    private Set<Set<Integer>> hasRepeatData(List<User> users) {
        Set<Set<Integer>> repeatRows = new HashSet<>();

        for (int i=0; i<users.size()-1; i++) {
            User user = users.get(i);
            for (int j=i+1; j<users.size(); j++) {
                User nextUser = users.get(j);
                if (user.equals(nextUser)) {
                    //先判断跟之前存在的是否相同
                    boolean isExistRepeat = false;
                    for (Set<Integer> set : repeatRows) {
                        for (Integer oldRow : set) {
                            if (users.get(oldRow).equals(user) || users.get(oldRow).equals(nextUser)) {
                                set.add(i);
                                set.add(j);
                                isExistRepeat = true;
                                break;
                            }
                        }
                    }
                    if (!isExistRepeat) {
                        Set<Integer> newRepeatSet = new HashSet<>();
                        newRepeatSet.add(i);
                        newRepeatSet.add(j);
                        repeatRows.add(newRepeatSet);
                    }
                }
            }
        }
        return repeatRows;
    }
}
