package com.baustem.epg.handler;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baustem.epg.service.EventService;
import com.baustem.epg.service.ProgramService;
import com.baustem.xmlservice.entity.Event;
import com.baustem.xmlservice.entity.Program;
import com.google.gson.Gson;
@RequestMapping("/channel/list")
@Controller
public class ProgramHandler {
	
	@Autowired
	private ProgramService programService;
	@Autowired
	private EventService eventService;
	
	@ResponseBody
	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	public String get(@PathVariable("name") String programName,
			@RequestParam("startTime") Long startTime,
			@RequestParam("endTime") Long endTime,
			HttpServletResponse response){
		Map<String,Object> params = new HashMap<>();
		int offset = Calendar.getInstance().getTimeZone().getRawOffset();
		
		params.put("likeProgramName", "%"+programName+"%");
		params.put("startTime", startTime==null?null:(startTime-offset)/1000);
		params.put("endTime", endTime==null?null:(endTime-offset)/1000);
		List<Event> events =  eventService.getEventsByName(params);
		List<Program> programs = programService.getProgramList(events);
		String jsonStr = toJsonStr(programs, events,response);
		return jsonStr;
	}
	
	private String toJsonStr(List<Program> programs,List<Event> events,HttpServletResponse response){
		int status = response.getStatus();
		Gson gson = new Gson();
		StringBuilder jsonstr = new StringBuilder();
		jsonstr.append("{\"Response\":{\"status\":\""+status+"\",\"totalNum\":\""+events.size()+"\",\"content\":[");
		for (int i= 0;i<events.size();i++) {
			Event event = events.get(i);
			Program program = programs.get(i);
			String jse = gson.toJson(event);
			String jsp = gson.toJson(program);
			jsonstr.append(jse);
			jsonstr.append(",");
			jsonstr.append(jsp);
			if(i!=events.size()-1)
				jsonstr.append(",");
		}
		jsonstr.append("]}}");
		return jsonstr.toString();
	}
	
	
	

}
