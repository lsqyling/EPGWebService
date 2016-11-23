package com.baustem.xmlservice.dao.i;

import java.util.List;

import com.baustem.xmlservice.base.i.BaseDao;
import com.baustem.xmlservice.entity.Program;
import com.baustem.xmlservice.entity.Transport;

public interface TransportDao extends BaseDao<Transport> {
	
	void createTransportTable();
	
	void batchInsertTransportTable(List<Program> programList);
	
	
	

}
