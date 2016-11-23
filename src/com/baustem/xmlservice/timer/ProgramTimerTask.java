package com.baustem.xmlservice.timer;

import java.io.File;
import java.util.HashSet;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.baustem.xmlservice.service.i.ProgramService;
import com.baustem.xmlservice.service.m.ProgramServiceImpl;

public class ProgramTimerTask extends TimerTask {
	
	private Log log = LogFactory.getLog(ProgramTimerTask.class);
	private ProgramService pService = new ProgramServiceImpl();
	private String xmlFilePath;
	private HashSet<Long> set;
	
	public ProgramTimerTask(String xmlFilePath) {
		this.xmlFilePath = xmlFilePath;
		set = new HashSet<Long>();
	}
	

	@Override
	public void run() {
		File file = new File(xmlFilePath);
		long length = file.length();
		set.add(length);
		if(set.size()==1){
			pService.createDataTable();
			pService.batchInsertProgramListTable(xmlFilePath);
			log.info("create data base success");
		} else{
			log.info("create data base is failed");
		}
		
	}

}
