package com.baustem.xmlservice.dao.i;

import java.util.List;

import com.baustem.xmlservice.base.i.BaseDao;
import com.baustem.xmlservice.entity.ES;
import com.baustem.xmlservice.entity.Program;

public interface ESDao extends BaseDao<ES> {
	
	void createESTable();
	
	void batchInsertESTable(List<Program> programList);
	

}
