package com.baustem.xmlservice.dao.i;

import java.util.List;

import com.baustem.xmlservice.base.i.BaseDao;
import com.baustem.xmlservice.entity.Program;

public interface ProgramDao extends BaseDao<Program> {
	
	
	void createProgramListTable();
	
	void batchInsertProgramListTable(List<Program> programList);
	
	

}
