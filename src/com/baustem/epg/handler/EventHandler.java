package com.baustem.epg.handler;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baustem.epg.service.EventService;
import com.baustem.epg.service.ProgramService;
import com.baustem.xmlservice.entity.Event;
import com.baustem.xmlservice.entity.Program;
import com.google.gson.Gson;
@RequestMapping("/program")
@Controller
public class EventHandler {
	
	@Autowired
	private EventService eventService;
	@Autowired
	private ProgramService programService;
	
	@ResponseBody
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public String eventList(@RequestBody String body,HttpServletResponse response){
		Map<String, Object> requestParams = getRequestParams(body);
		Program program = programService.getProgram(requestParams);
		List<Event> events = eventService.getEventList(program,requestParams);
		JSONArray jsonArray = toJsonArray(events);
		Gson gson = new Gson();
		String jsObj = gson.toJson(program);
		int status = response.getStatus();
		
		return "{\"Response\":{\"status\":\""+status+"\",\"totalNum\":\""+events.size()+"\",\"channelInfo\":"+jsObj+",\"epgEvents\":"+jsonArray.toString()+"}}"; 
	}
	
	@RequestMapping(value="/list/all",method=RequestMethod.POST)
	public String allList(@RequestBody String body,HttpServletResponse response){
		Map<String,Object> requestParams = getRequestParams(body);
		Program program = new Program();
		List<Event> allEvents = eventService.getEventList(program, requestParams);
		JSONArray jsonArray = toJsonArray(allEvents);
		int status = response.getStatus();
		return "{\"Response\":{\"status\":\""+status+"\",\"totalNum\":\""+allEvents.size()+"\",\"epgEvents\":"+jsonArray.toString()+"}}";
	}
	
	private JSONArray toJsonArray(List<Event> events){
		JSONArray jsonArray = new JSONArray();
		for (Event event : events) {
			JSONObject jo = new JSONObject();
			jo.put("ONID", event.getONID());
			jo.put("SID", event.getSID());
			jo.put("TSID", event.getTSID());
			jo.put("programName", event.getEventName());
			jo.put("startTime", event.getStartTime());
			jo.put("endTime", event.getEndTime());
			jo.put("playUrl", event.getPlayUrl());
			jo.put("postUrl", event.getPostUrl());
			jsonArray.put(jo);
		}
		return jsonArray;
	}
	
	private Map<String,Object> getRequestParams(String body){

		String reqBody = null; 
		try {
			reqBody = URLDecoder.decode(body, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		reqBody = reqBody.substring(reqBody.indexOf("{"), reqBody.lastIndexOf("}")+1);
		Map<String,Object> reqMap = new HashMap<String, Object>();
		JSONObject JSObj = new JSONObject(reqBody);
		JSONObject jsonContent = JSObj.getJSONObject("Request");
		String ln = jsonContent.getString("logicalNumber");
		String cn = jsonContent.getString("channelName");
		reqMap.put("logicalNumber", ln.trim().equals("")?null:ln);
		reqMap.put("channelName",cn.trim().equals("")?null:cn );
		try {
			String start = jsonContent.getString("startTime");
			String end = jsonContent.getString("endTime");
			int offset = Calendar.getInstance().getTimeZone().getRawOffset();
			long s = Long.parseLong(start.trim().equals("")?"0":start);
			long endTime = Long.parseLong(end.trim().equals("")?"0":end);
			reqMap.put("startTime", (Long)(s-offset)/1000<0?null:(Long)(s-offset)/1000);
			reqMap.put("endTime", (Long)(endTime-offset)/1000<0?null:(Long)(endTime-offset));
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		return reqMap;
	}
	
	
	
	
	
	
	
	

}
