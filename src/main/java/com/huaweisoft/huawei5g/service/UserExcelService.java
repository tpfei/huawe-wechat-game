package com.huaweisoft.huawei5g.service;

import com.huaweisoft.huawei5g.model.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserExcelService {

    List<User> importUsers(MultipartFile file);

    int exportTemplate(HttpServletResponse response);

}
