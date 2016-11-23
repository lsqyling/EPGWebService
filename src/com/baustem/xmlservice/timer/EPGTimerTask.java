package com.baustem.xmlservice.timer;

import java.io.File;
import java.util.HashSet;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.baustem.xmlservice.service.i.EventService;
import com.baustem.xmlservice.service.m.EventServiceImpl;

public class EPGTimerTask extends TimerTask {
	
	private Log log = LogFactory.getLog(EPGTimerTask.class);
	private EventService eventService = new EventServiceImpl();
	private String xmlFilePath ;
	private HashSet<Long> set;
	
	public EPGTimerTask(String xmlFilePath) {
		this.xmlFilePath = xmlFilePath;
		set = new HashSet<>();
	}
	
	@Override
	public void run() {
		
		File file = new File(xmlFilePath);
		set.add(file.length());
		
		if(set.size()==1){
			eventService.createDataTable();
			eventService.batchInsertEPGListTable(xmlFilePath);
			log.info("create data base success");
		}else{
			log.info("there is no update");
		}
		
	}

}
