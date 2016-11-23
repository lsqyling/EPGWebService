package com.baustem.xmlservice.test;

import org.junit.Test;

import com.baustem.xmlservice.service.i.EventService;
import com.baustem.xmlservice.service.m.EventServiceImpl;

public class EventServiceImplTest {
	
	
	private EventService eventService = new EventServiceImpl();

	@Test
	public void testCreateDataTable() {
		eventService.createDataTable();
	}

	@Test
	public void testBatchInsertEPGListTable() {
		
		eventService.batchInsertEPGListTable("D:/hmt/data/cfg/ScheduleEPG.xml");
	}

}
