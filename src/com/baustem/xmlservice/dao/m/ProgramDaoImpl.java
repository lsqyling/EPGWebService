package com.baustem.xmlservice.dao.m;

import java.util.List;

import com.baustem.xmlservice.base.m.BaseDaoImpl;
import com.baustem.xmlservice.dao.i.ProgramDao;
import com.baustem.xmlservice.entity.Program;
import com.baustem.xmlservice.entity.Transport;

public class ProgramDaoImpl extends BaseDaoImpl<Program> implements ProgramDao {
	
	@Override
	public void createProgramListTable() {
		String sql = "DROP TABLE IF EXISTS ProgramList";
		this.createDataTable(sql);
		
		sql = "CREATE TABLE IF NOT EXISTS ProgramList("
				+ "id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,"
				+ "ONID INT(11),TSID INT(11),"
				+ "SID INT(11),logicalNumber INT(11),"
				+ "`name` VARCHAR(255),"
				+ "multilingualName VARCHAR(255),"
				+ "multilingualName_language VARCHAR(255),"
				+ "provider VARCHAR(255),"
				+ "serviceType VARCHAR(255),"
				+ "scrambled VARCHAR(255),"
				+ "transport_id VARCHAR(255) NOT NULL,"
				+ "FOREIGN KEY(transport_id) REFERENCES Transport(id)"
				+ ")ENGINE=INNODB DEFAULT CHARSET=utf8";
		
		this.createDataTable(sql);
		
		
	}

	@Override
	public void batchInsertProgramListTable(List<Program> programList) {
		int count;
		String sql = "INSERT INTO ProgramList("
				+ "ONID,TSID,SID,"
				+ "logicalNumber,"
				+ "`name`,"
				+ "multilingualName,"
				+ "multilingualName_language,"
				+ "provider,serviceType,scrambled,"
				+ "transport_id) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		Object[][] params = new Object[programList.size()][];
		for (int i = 0; i < params.length; i++) {
			Program p = programList.get(i);
			Transport t = p.getTransport();
			params[i] = new Object[]{
					p.getONID(),
					p.getTSID(),
					p.getSID(),
					p.getLogicalNumber(),
					p.getName(),
					p.getMultilingualName(),
					p.getMultilingualName_language(),
					p.getProvider(),
					p.getServiceType(),
					p.getScrambled(),
					t.getId()
			};
			
		}
		
		count = this.batch(sql, params);
		System.out.println("ProgramList 表更新 "+count+" 条数据");
	}

}
