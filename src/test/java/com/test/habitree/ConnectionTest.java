package com.test.habitree;

import java.sql.Connection;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConnectionTest {

	@Autowired
	private DataSource dataSource;
	
	@Test
	void testConnection() throws Exception {
		
		try (Connection conn = dataSource.getConnection()) {
			System.out.println("DB 연결 성공");
			System.out.println("URL = " + conn.getMetaData().getURL());
			System.out.println("User = " + conn.getMetaData().getUserName());
		} catch (Exception e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
		
	}
	
	

}
