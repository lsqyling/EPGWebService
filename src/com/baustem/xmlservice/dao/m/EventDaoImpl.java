package com.baustem.xmlservice.dao.m;

import java.util.List;

import com.baustem.xmlservice.base.m.BaseDaoImpl;
import com.baustem.xmlservice.dao.i.EventDao;
import com.baustem.xmlservice.entity.Event;

public class EventDaoImpl extends BaseDaoImpl<Event> implements EventDao {

	@Override
	public void createEPGListTable() {
		String sql = "DROP TABLE IF EXISTS EPGList";
		this.createDataTable(sql);
		sql = "CREATE TABLE IF NOT EXISTS EPGList("
				+ "id INT(11) NOT NULL AUTO_INCREMENT,"
				+ "ONID INT(11),"
				+ "TSID INT(11),"
				+ "SID INT(11),"
				+ "EID INT(11),"
				+ "startTime LONG,"
				+ "duration LONG,"
				+ "eventName VARCHAR(255),"
				+ "eventName_language VARCHAR(255),"
				+ "eventText_language VARCHAR(255),"
				+ "PRIMARY KEY(id),"
				+ "playUrl VARCHAR(255),"
				+ "postUrl VARCHAR(255),"
				+ "endTime LONG"
				+ ")ENGINE=INNODB DEFAULT CHARSET=utf8";
		this.createDataTable(sql);
	}

	@Override
	public void batchInsertEPGListTable(List<Event> eventList) {
		int count ;
		String sql = "INSERT INTO EPGList("
				+ "ONID,TSID,SID,EID,"
				+ "startTime,duration,"
				+ "eventName,eventName_language,eventText_language,endTime)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		Object[][] params = new Object[eventList.size()][];
		for (int i = 0; i < params.length; i++) {
			Event event = eventList.get(i);
			params[i] = new Object[]{
					event.getONID(),
					event.getTSID(),
					event.getSID(),
					event.getEID(),
					event.getStartTime(),
					event.getDuration(),
					event.getEventName(),
					event.getEventName_language(),
					event.getEventText_language(),
					event.getStartTime()+event.getDuration()
					};
		}
		
		count = this.batch(sql, params);
		System.out.println("EPGList 表更新 "+count+" 条数据");
	}
	
	
	
	

}
