package com.baustem.xmlservice.service.m;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;

import com.baustem.xmlservice.dao.i.EventDao;
import com.baustem.xmlservice.dao.m.EventDaoImpl;
import com.baustem.xmlservice.entity.Event;
import com.baustem.xmlservice.service.i.EventService;
import com.baustem.xmlservice.utils.XMLParseUtil;

public class EventServiceImpl implements EventService {
	
	private EventDao eventDao = new EventDaoImpl();

	@Override
	public void createDataTable() {
		eventDao.createEPGListTable();
	}

	@Override
	public void batchInsertEPGListTable(String xmlFilePath) {
		List<String> kList = new ArrayList<>();
		List<String> vList = new ArrayList<>();
		try {
			XMLParseUtil.parseXML(xmlFilePath, kList, vList);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		List<Integer> indexList = new ArrayList<>();
		List<Event> eventList = new ArrayList<>();

		for (int i = 0; i < kList.size(); i++) {
			String str = kList.get(i);
			if (str.equalsIgnoreCase("Event")) {
				indexList.add(i);
			}
		}

		for (int i = 0; i < indexList.size(); i++) {

			Integer eventIndex = indexList.get(i);
			String tableN = "";
			if (i == 0) {
				tableN = kList.get(eventIndex - 1);
				
				Integer oNID = Integer.parseInt(vList.get(eventIndex + 1));
				Integer tSID = Integer.parseInt(vList.get(eventIndex + 2));
				Integer sID = Integer.parseInt(vList.get(eventIndex + 3));
				Integer eID = Integer.parseInt(vList.get(eventIndex + 4));
				
				Long startTime = Long.parseLong(vList.get(eventIndex + 5));
				Long duration = Long.parseLong(vList.get(eventIndex + 6));
				
				String eventName = vList.get(eventIndex + 7);
				String eventName_language = vList.get(eventIndex + 8);
				String eventText_language = vList.get(eventIndex + 10);

				Event event = new Event(tableN, oNID, tSID, sID, eID,
						startTime, duration, eventName, eventName_language,
						eventText_language);
				eventList.add(event);
			} else {
				Integer oNID = Integer.parseInt(vList.get(eventIndex + 1));
				Integer tSID = Integer.parseInt(vList.get(eventIndex + 2));
				Integer sID = Integer.parseInt(vList.get(eventIndex + 3));
				Integer eID = Integer.parseInt(vList.get(eventIndex + 4));
				
				Long startTime = Long.parseLong(vList.get(eventIndex + 5));
				Long duration = Long.parseLong(vList.get(eventIndex + 6));
				
				String eventName = vList.get(eventIndex + 7);
				String eventName_language = vList.get(eventIndex + 8);
				String eventText_language = vList.get(eventIndex + 10);

				Event event = new Event(oNID, tSID, sID, eID, startTime,
						duration, eventName, eventName_language,
						eventText_language);
				eventList.add(event);
			}
		}

		eventDao.batchInsertEPGListTable(eventList);

	}

}
