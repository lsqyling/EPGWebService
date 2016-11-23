package com.baustem.xmlservice.test;


import org.junit.Test;

import com.baustem.xmlservice.service.i.ProgramService;
import com.baustem.xmlservice.service.m.ProgramServiceImpl;

public class ProgramServiceImplTest {

	private ProgramService programService = new ProgramServiceImpl();
	
	@Test
	public void testCreateDataTable() {
		
		programService.createDataTable();
		
	}

	@Test
	public void testBatchInsertProgramListTable() {
		programService.batchInsertProgramListTable("D:/hmt/data/cfg/ProgramList.xml");
	}

}
