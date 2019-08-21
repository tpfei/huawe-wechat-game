package com.huaweisoft.huawei5g;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Huawei5gApplicationTests.class)
@Slf4j
public class Huawei5gApplicationTests {
	DataSource dataSource;
	
	@Test
	public void contextLoads() throws SQLException {
//		if (dataSource!=null) {
//			System.out.println(dataSource.getClass());
//			
//			Connection conn=dataSource.getConnection();
//			System.out.println(conn);
//			conn.close();
//		}
	}
}
