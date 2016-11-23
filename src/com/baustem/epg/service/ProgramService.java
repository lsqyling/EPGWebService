package com.baustem.epg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baustem.epg.mapper.ProgramMapper;
import com.baustem.xmlservice.entity.Event;
import com.baustem.xmlservice.entity.Program;
@Transactional
@Service
public class ProgramService {

	@Autowired
	private ProgramMapper programMapper;

	public List<Program> getProgramList(List<Event> events) {
		List<Program> programList = new ArrayList<>();
		for (Event event : events) {
			Program program = programMapper.getProgramByEvent(event);
			programList.add(program);
		}
		
		return programList;
	}

	public Program getProgram(Map<String, Object> requestParams) {
		return programMapper.getByLogicalNAndChannelN(requestParams);
	}
	
}
