package com.baustem.epg.mapper;

import java.util.Map;

import com.baustem.xmlservice.entity.Event;
import com.baustem.xmlservice.entity.Program;

public interface ProgramMapper {

	Program getByLogicalNAndChannelN(Map<String, Object> requestParams);

	Program getProgramByEvent(Event event);

}
