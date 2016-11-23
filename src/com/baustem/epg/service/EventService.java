package com.baustem.epg.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baustem.epg.mapper.EventMapper;
import com.baustem.xmlservice.entity.Event;
import com.baustem.xmlservice.entity.Program;
@Transactional
@Service
public class EventService {

	@Autowired
	private EventMapper eventMapper;
	
	public List<Event> getEventList(Program program,Map<String, Object> requestParams) {
		//ONID='223' AND TSID='23' AND SID='101'
		if(program!=null&&program.getONID()!=null){
			requestParams.put("ONID", program.getONID());   
			requestParams.put("TSID", program.getTSID());
			requestParams.put("SID", program.getSID());
		}else{
			requestParams.put("ONID", null);
		}
		List<Event> eventList = eventMapper.getList(requestParams);
		return eventList;
	}

	public List<Event> getEventsByName(Map<String, Object> params) {
		return eventMapper.getEventsByName(params);
	}
	
	
	
}
