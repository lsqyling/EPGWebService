package com.baustem.xmlservice.service.m;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.dom4j.DocumentException;

import com.baustem.xmlservice.dao.i.ESDao;
import com.baustem.xmlservice.dao.i.ProgramDao;
import com.baustem.xmlservice.dao.i.TransportDao;
import com.baustem.xmlservice.dao.m.ESDaoImpl;
import com.baustem.xmlservice.dao.m.ProgramDaoImpl;
import com.baustem.xmlservice.dao.m.TransportDaoImpl;
import com.baustem.xmlservice.entity.ES;
import com.baustem.xmlservice.entity.Program;
import com.baustem.xmlservice.entity.Transport;
import com.baustem.xmlservice.service.i.ProgramService;
import com.baustem.xmlservice.utils.XMLParseUtil;

public class ProgramServiceImpl implements ProgramService {
	
	private ProgramDao programDao = new ProgramDaoImpl();
	private TransportDao transportDao = new TransportDaoImpl();
	private ESDao esDao = new ESDaoImpl();

	@Override
	public void createDataTable() {
		
		transportDao.createTransportTable();
		esDao.createESTable();
		programDao.createProgramListTable();
		
		
	}

	@Override
	public void batchInsertProgramListTable(String xmlFilePath) {
		List<String> kList = new ArrayList<>();
		List<String> vList = new ArrayList<>();
		try {
			XMLParseUtil.parseXML(xmlFilePath, kList, vList);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		List<Integer> indexList = new ArrayList<>();
		List<Program> programList = new ArrayList<>();
		
		for (int i = 0; i < kList.size(); i++) {
			String kName = kList.get(i);
			if(kName.equalsIgnoreCase("Program")){
				indexList.add(i);
			}
		}
		
		for (int i = 0; i < indexList.size(); i++) {
			
			Integer programIndex = indexList.get(i);
			
			Integer oNID = Integer.parseInt(vList.get(programIndex+1));
			Integer tSID = Integer.parseInt(vList.get(programIndex+2));
			Integer sID = Integer.parseInt(vList.get(programIndex+3));
			Integer logicalNumber = Integer.parseInt(vList.get(programIndex+4));

			String name = vList.get(programIndex+5);
			String multilingualName = vList.get(programIndex+6);
			String multilingualName_language = vList.get(programIndex+7);
			String provider = vList.get(programIndex+8);
			String serviceType = vList.get(programIndex+9);
			String scrambled = vList.get(programIndex+10);

			String frequency = vList.get(programIndex+12);
			Integer pMTPID = Integer.parseInt(vList.get(programIndex+13));
			Integer pCRPID = Integer.parseInt(vList.get(programIndex+14));

			List<ES> esList = new ArrayList<ES>();
			Transport transport = new Transport(frequency, pMTPID, pCRPID, esList);
			transport.setId(UUID.randomUUID().toString());
			
			String streamType = vList.get(programIndex+17);
			Integer pID = Integer.parseInt(vList.get(programIndex+18));
			String es_scrambled = vList.get(programIndex+19);
			ES es = new ES(streamType, pID, es_scrambled);
			es.setId(UUID.randomUUID().toString());
			esList.add(es);
			
			String streamTypeN = vList.get(programIndex+21);
			Integer pIDN = Integer.parseInt(vList.get(programIndex+22));
			String es_scrambledN = vList.get(programIndex+23);
			//String languageCodeN = vList.get(programIndex+24);
			ES esN = new ES(streamTypeN, pIDN, es_scrambledN, "");
			esN.setId(UUID.randomUUID().toString());
			esList.add(esN);
			
			Program p = new Program(oNID, tSID, sID, logicalNumber, name, multilingualName, multilingualName_language, provider, serviceType, scrambled, transport);
			programList.add(p);
		}
		transportDao.batchInsertTransportTable(programList);
		esDao.batchInsertESTable(programList);
		programDao.batchInsertProgramListTable(programList);
	}

}
