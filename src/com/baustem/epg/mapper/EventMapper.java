package com.baustem.epg.mapper;

import java.util.List;
import java.util.Map;

import com.baustem.xmlservice.entity.Event;

public interface EventMapper {

	List<Event> getList(Map<String, Object> requestParams);


	List<Event> getEventsByName(Map<String, Object> params);
	
	

}
