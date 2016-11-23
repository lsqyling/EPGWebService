package com.baustem.xmlservice.dao.m;

import java.util.List;

import com.baustem.xmlservice.base.m.BaseDaoImpl;
import com.baustem.xmlservice.dao.i.TransportDao;
import com.baustem.xmlservice.entity.Program;
import com.baustem.xmlservice.entity.Transport;

public class TransportDaoImpl extends BaseDaoImpl<Transport> implements TransportDao {

	@Override
	public void createTransportTable() {
		String sql = "DROP TABLE IF EXISTS ProgramList";
		this.createDataTable(sql);
		sql = "DROP TABLE IF EXISTS Transport_ESList";
		this.createDataTable(sql);
		sql = "DROP TABLE IF EXISTS Transport";
		this.createDataTable(sql);
		
		sql = "CREATE TABLE IF NOT EXISTS Transport("
				+ "id VARCHAR(255) PRIMARY KEY NOT NULL,"
				+ "frequency VARCHAR(255),"
				+ "PMTPID INT(11),"
				+ "PCRPID INT(11)"
				+ ")ENGINE=INNODB DEFAULT CHARSET=utf8";
		
		this.createDataTable(sql);
	}

	@Override
	public void batchInsertTransportTable(List<Program> programList) {
		int count;
		String sql = "INSERT INTO Transport(id,frequency,PMTPID,PCRPID) VALUES(?,?,?,?)";
		
		Object[][] params = new Object[programList.size()][];
		for (int i = 0; i < params.length; i++) {
			Program p = programList.get(i);
			Transport t = p.getTransport();
			params[i] = new Object[]{
					t.getId(),
					t.getFrequency(),
					t.getPMTPID(),
					t.getPCRPID()
					};
		}
		count = this.batch(sql, params);
		System.out.println("Transport 表更新 "+count+" 条数据");
	}

}
