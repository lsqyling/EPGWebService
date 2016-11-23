package com.baustem.epg.test;


import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {
	
	private ApplicationContext ioc;
	
	{
		ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testDataConnection() throws SQLException{
		DataSource dataSource = ioc.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
	
	

}
