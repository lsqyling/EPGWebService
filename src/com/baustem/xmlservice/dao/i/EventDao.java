package com.baustem.xmlservice.dao.i;

import java.util.List;

import com.baustem.xmlservice.base.i.BaseDao;
import com.baustem.xmlservice.entity.Event;

public interface EventDao extends BaseDao<Event> {
	
	void createEPGListTable();
	
	void batchInsertEPGListTable(List<Event> eventList);
	
	

}
